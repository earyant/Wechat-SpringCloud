package com.earyant.wechat.service.impl;

import com.earyant.wechat.message.resp.Article;
import com.earyant.wechat.message.resp.NewsMessage;
import com.earyant.wechat.message.resp.TextMessage;
import com.earyant.wechat.service.EventDisPatcherService;
import com.earyant.wechat.service.MsgDisPatcherService;
import com.earyant.wechat.util.MessageUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: MsgDispatcherImpl
 *
 * @author dapengniao
 * @Description: 消息业务处理分发器
 * @date 2016年3月7日 下午4:04:21
 */
@Service("magDispatcherImpl")
public class MsgDispatcherImpl implements MsgDisPatcherService {

    @Resource
    EventDisPatcherService eventDisPatcherService;
    org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;
    //    @Autowired
//    RedisServiceImpl redisService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String processMessage(Map<String, String> map) throws Exception {
        String openid = map.get("FromUserName"); //用户openid
        String mpid = map.get("ToUserName");   //公众号原始ID
        String token = stringRedisTemplate.opsForValue().get("access_token_" + map.get("appid"));
//        String token = (String) redisService.get("access_token_" + map.get("appid"));
        map.put("access_token", token);
        //普通文本消息
        TextMessage txtmsg = new TextMessage();
        txtmsg.setToUserName(openid);
        txtmsg.setFromUserName(mpid);
        txtmsg.setCreateTime(new Date().getTime());
        txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

        //对图文消息
        NewsMessage newmsg = new NewsMessage();
        newmsg.setToUserName(openid);
        newmsg.setFromUserName(mpid);
        newmsg.setCreateTime(new Date().getTime());
        newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            String content = map.get("Content");
            if ("1".equals(content) || "Android".equals(content)) {
                return eventDisPatcherService.getContent(newmsg, "Android");
            } else if ("2".equals(content) || "iOS".equals(content)) {
                return eventDisPatcherService.getContent(newmsg, "iOS");
            } else if ("3".equals(content) || "福利".equals(content)) {
                return eventDisPatcherService.getContent(newmsg, "福利");
            } else if ("4".equals(content) || "前端".equals(content)) {
                return eventDisPatcherService.getContent(newmsg, "前端");
            } else if ("5".equals(content) || "拓展资源".equals(content)) {
                return eventDisPatcherService.getContent(newmsg, "拓展资源");
            } else if ("6".equals(content) || "休息视频".equals(content)) {
                return eventDisPatcherService.getContent(newmsg, "休息视频");
            } else if ("7".equals(content) || "瞎推荐".equals(content)) {
                return eventDisPatcherService.getContent(newmsg, "瞎推荐");
            } else if ("8".equals(content)) {
                return restTemplate.postForObject("http://WECHAT-ITCHAT-PROVIDER/getQrImg", map, String.class, map);
            } else {
                try {
//                    logger.info("content::  " + content);
                    Pattern p = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
                    Matcher m = p.matcher(content);
                    if (m.find()) {
//                        logger.info("找到了：：：" + m.group());
                        if (eventDisPatcherService.getContentByDate(newmsg, m.group(0)) != null) ;
                        return eventDisPatcherService.getContentByDate(newmsg, m.group(0));
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                    logger.info("没找到该天资源");
                    txtmsg.setContent("您输入的日期格式有误，请您重新输入！");
                    return MessageUtil.textMessageToXml(txtmsg);
                }
                txtmsg.setContent("查看最新Andriod资源请回复“Android！”或“1”！\n" +
                        "查看最新iOS资源请回复“iOS”或“2”！\n" +
                        "查看福利请回复“福利”或“3”！\n" +
                        "查看前端请回复“前端”或“4”！\n" +
                        "查看拓展资源请回复“拓展资源”或“5”！\n" +
                        "查看休息视频请回复“休息视频”或“6”！\n" +
                        "查看瞎推荐请回复“瞎推荐”或者“7”！\n" +
                        "或者直接输入日期返回当天的资源，例如2016-11-07\n");

            }
            return MessageUtil.textMessageToXml(txtmsg);
        }


        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
//			System.out.println("==============这是图片消息！");
            Article article = new Article();
            article.setDescription("欢迎光临我的blog"); //图文消息的描述
            article.setPicUrl("http://ww2.sinaimg.cn/large/610dc034jw1f978bh1cerj20u00u0767.jpg"); //图文消息图片地址
            article.setTitle("我的博客");  //图文消息标题
            article.setUrl("https://earyant.github.io/");  //图文url链接
            List<Article> list = new ArrayList<Article>();
            list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
            newmsg.setArticleCount(list.size());
            newmsg.setArticles(list);
            return MessageUtil.newsMessageToXml(newmsg);
        }


        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            txtmsg.setContent("");
            return MessageUtil.textMessageToXml(txtmsg);
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
//			System.out.println("==============这是位置消息！");
            return "";
        }


        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
//			System.out.println("==============这是视频消息！");
            return "";
        }


        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
//			System.out.println("==============这是语音消息！");
            return "";
        }

        return null;
    }
}
