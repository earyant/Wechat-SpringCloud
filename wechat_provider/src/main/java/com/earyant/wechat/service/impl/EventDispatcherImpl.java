package com.earyant.wechat.service.impl;

import com.earyant.commentdatabase.redis.service.RedisServiceImpl;
import com.earyant.token.service.WechatConfigService;
import com.earyant.wechat.common.GetUseInfo;
import com.earyant.wechat.message.resp.Article;
import com.earyant.wechat.message.resp.Image;
import com.earyant.wechat.message.resp.ImageMessage;
import com.earyant.wechat.message.resp.NewsMessage;
import com.earyant.wechat.service.EventDisPatcherService;
import com.earyant.wechat.util.HttpPostUploadUtil;
import com.earyant.wechat.util.MessageUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * ClassName: EventDispatcherImpl
 *
 * @author dapengniao
 * @Description: 事件消息业务分发器
 * @date 2016年3月7日 下午4:04:41
 */
@Service("eventDispatcherImpl")
public class EventDispatcherImpl implements EventDisPatcherService {
    private static Logger logger = Logger.getLogger(EventDispatcherImpl.class);
    //    @Resource
//    private GankContentMapper gankContentMapper;
//    @Resource
//    private DayMapper dayMapper;
//    @Resource
//    AllContentBeanMapper allContentBeanMapper;
    @Autowired
    RedisServiceImpl redisService;
    @Autowired
    WechatConfigService wechatConfigService;
    @Autowired
    GetUseInfo getUseInfo;

    @Override
    public String processEvent(Map<String, String> map) throws Exception {
        String token = (String) redisService.get("access_token_" + map.get("appid"));
        String openid = map.get("FromUserName"); // 用户openid
        String mpid = map.get("ToUserName"); // 公众号原始ID
        ImageMessage imgmsg = new ImageMessage();
        imgmsg.setToUserName(openid);
        imgmsg.setFromUserName(mpid);
        imgmsg.setCreateTime(new Date().getTime());
        imgmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);
        //对图文消息
        NewsMessage newmsg = new NewsMessage();
        newmsg.setToUserName(openid);
        newmsg.setFromUserName(mpid);
        newmsg.setCreateTime(new Date().getTime());
        newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { // 关注事件
//			System.out.println("==============这是关注事件！");
            try {
                HashMap<String, String> userinfo = getUseInfo.Openid_userinfo(openid, map.get("appid"));
                Article article = new Article();
                article.setDescription("欢迎来到李睿的个人博客：菜鸟程序员成长之路！"); //图文消息的描述
                article.setPicUrl(userinfo.get("headimgurl")); //图文消息图片地址
                article.setTitle("尊敬的：" + userinfo.get("nickname") + ",你好！");  //图文消息标题
                article.setUrl("earyant.github.io");  //图文url链接
                List<Article> list = new ArrayList<Article>();
                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
                newmsg.setArticleCount(list.size());
                newmsg.setArticles(list);
                return MessageUtil.newsMessageToXml(newmsg);
            } catch (Exception e) {
//				System.out.println("====代码有问题额☺！");
                logger.error(e, e);
            }

        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { // 取消关注事件
//			System.out.println("==============这是取消关注事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { // 扫描二维码事件
//			System.out.println("==============这是扫描二维码事件！");
            Article article = new Article();
            article.setDescription("好吧，既然你扫我了，那我得回应你啊"); //图文消息的描述
            article.setPicUrl("http://res.earyant.com/2016/03/201603086749_6850.png"); //图文消息图片地址
            article.setTitle("扫我干嘛");  //图文消息标题
            article.setUrl("https://earyant.github.io/");  //图文url链接
            List<Article> list = new ArrayList<Article>();
            list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
            newmsg.setArticleCount(list.size());
            newmsg.setArticles(list);
            return MessageUtil.newsMessageToXml(newmsg);
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { // 位置上报事件
//			System.out.println("==============这是位置上报事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { // 自定义菜单点击事件
//			System.out.println("==============这是自定义菜单点击事件！");
            if (map.get("EventKey").equals("image")) {
                Image img = new Image();
                HttpPostUploadUtil util = new HttpPostUploadUtil(token);
                HashMap<String, String> userinfo = getUseInfo.Openid_userinfo(openid, openid);
                String filepath = userinfo.get("headimgurl");
                Map<String, String> textMap = new HashMap<String, String>();
                textMap.put("name", "testname");
                Map<String, String> fileMap = new HashMap<String, String>();
                fileMap.put("userfile", filepath);
                String mediaidrs = util.formUpload(textMap, fileMap);
//                System.out.println(mediaidrs);
                String mediaid = JSONObject.fromObject(mediaidrs).getString("media_id");
                img.setMediaId(mediaid);
                imgmsg.setImage(img);
                return MessageUtil.imageMessageToXml(imgmsg);
            } else if (map.get("EventKey").equals("text")) {
//			    System.out.println("这里是回复图文消息!");
                Article article = new Article();
                article.setDescription("这是图文消息1"); //图文消息的描述
                article.setPicUrl("http://res.earyant.com/2016/03/201603086749_6850.png"); //图文消息图片地址
                article.setTitle("图文消息1");  //图文消息标题
                article.setUrl("https://earyant.github.io/");  //图文url链接
                List<Article> list = new ArrayList<Article>();
                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
                newmsg.setArticleCount(list.size());
                newmsg.setArticles(list);
                return MessageUtil.newsMessageToXml(newmsg);
            } else if (map.get("EventKey").equals("getOneDayContent")) {
                return getOneDayGank(newmsg);

            } else if (map.get("EventKey").equals("getAndroidContent")) {
                return getContent(newmsg, "Android");

            } else if (map.get("EventKey").equals("getIOSContent")) {
                return getContent(newmsg, "iOS");

            }
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { // 自定义菜单View事件
//			System.out.println("==============这是自定义菜单View事件！");
        }

        return null;
    }

    @Override
    public String getContent(NewsMessage newmsg, String type) throws Exception {
        //对图文消息
        newmsg.setCreateTime(new Date().getTime());
        newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
//        List<AllContentBeanWithBLOBs> allContentBeanWithBLOBs = allContentBeanMapper.selectByType(type);
//        List<Article> list = new ArrayList<>();
//        if (allContentBeanWithBLOBs.size() > 0) {
////            logger.debug("数据库中Android消息的个数" + allContentBeanWithBLOBs.size());
//            for (int i = 0; i < ((allContentBeanWithBLOBs.size() <= 9) ? allContentBeanWithBLOBs.size() : 9); i++) {
//                AllContentBeanWithBLOBs allContentBeanWithBLOB = allContentBeanWithBLOBs.get(i);
//                Article article = new Article();
//                logger.info(allContentBeanWithBLOB.gettDesc());
//                article.setDescription(allContentBeanWithBLOB.gettDesc()); //图文消息的描述
//                if ("福利".equals(type) ) {
//                    article.setPicUrl(allContentBeanWithBLOB.gettUrl());
//                } else {
//                    if (!ObjectUtils.isEmpty(allContentBeanWithBLOB.gettImages() )) {
//                        try {
////                        List<String> picUrls = JsonStringUtils.jsonStringToListString(allContentBeanWithBLOB.gettImages());
//                            logger.info(allContentBeanWithBLOB.gettImages());
//                            String[] picUrls = allContentBeanWithBLOB.gettImages().substring(1, allContentBeanWithBLOB.gettImages().length() - 1).split(",");
//                            if (picUrls.length > 0) {
//                                article.setPicUrl(picUrls[0]); //图文消息图片地址
//                            } else {
//                                article.setPicUrl("http://ww2.sinaimg.cn/large/610dc034jw1f9vyl2fqi0j20u011habc.jpg");
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            article.setPicUrl("http://ww2.sinaimg.cn/large/610dc034jw1f9vyl2fqi0j20u011habc.jpg");
//                        }
//                    } else {
//                        article.setPicUrl("http://ww2.sinaimg.cn/large/610dc034jw1f9vyl2fqi0j20u011habc.jpg");
//                    }
//                }
//                article.setTitle(allContentBeanWithBLOB.gettDesc());  //图文消息标题
//                article.setUrl(allContentBeanWithBLOB.gettUrl());  //图文url链接
//                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
//            }
//        } else {
//            return null;
        logger.info("没有任何数据。。。");
//            list.add(new Article("没有找到数据","没有找到您需求的数据","http://ww2.sinaimg.cn/large/610dc034jw1f9vyl2fqi0j20u011habc.jpg",""));
//        }
//        newmsg.setArticleCount(list.size());
//        newmsg.setArticles(list);
        return MessageUtil.newsMessageToXml(newmsg);

    }

    @Override
    public String getContentByDate(NewsMessage newmsg, String date) throws Exception {
        //对图文消息
        newmsg.setCreateTime(new Date().getTime());
        newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
//        List<AllContentBeanWithBLOBs> allContentBeanWithBLOBs = allContentBeanMapper.selectByDate(date + "%");
//        List<Article> list = new ArrayList<Article>();
//        if (allContentBeanWithBLOBs.size() > 0) {
////            logger.debug("数据库中Android消息的个数" + allContentBeanWithBLOBs.size());
//            for (int i = 0; i < ((allContentBeanWithBLOBs.size() <= 9) ? allContentBeanWithBLOBs.size() : 9); i++) {
//                AllContentBeanWithBLOBs allContentBeanWithBLOB = allContentBeanWithBLOBs.get(i);
//                Article article = new Article();
//                article.setDescription(allContentBeanWithBLOB.gettDesc()); //图文消息的描述
//                if (null != allContentBeanWithBLOB.gettImages() && !"".equals(allContentBeanWithBLOB.gettImages())) {
//                    try {
//                        String[] picUrls = allContentBeanWithBLOB.gettImages().substring(1, allContentBeanWithBLOB.gettImages().length() - 1).split(",");
//                        if (picUrls.length > 0) {
//                            article.setPicUrl(picUrls[0]); //图文消息图片地址
//                        } else {
//                            article.setPicUrl("http://ww2.sinaimg.cn/large/610dc034jw1f9vyl2fqi0j20u011habc.jpg");
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        article.setPicUrl("http://ww2.sinaimg.cn/large/610dc034jw1f9vyl2fqi0j20u011habc.jpg");
//                    } finally {
//                    }
//                } else {
//                    article.setPicUrl("http://ww2.sinaimg.cn/large/610dc034jw1f9vyl2fqi0j20u011habc.jpg");
//                }
//                article.setTitle(allContentBeanWithBLOB.gettDesc());  //图文消息标题
//                article.setUrl(allContentBeanWithBLOB.gettUrl());  //图文url链接
//                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
//            }
//        } else {
//            logger.info("没有任何数据。。。");
//            return "没有任何数据。。。";
//        }
//        newmsg.setArticleCount(list.size());
//        newmsg.setArticles(list);
        return MessageUtil.newsMessageToXml(newmsg);
    }

    @Override
    public String getOneDayGank(NewsMessage newmsg) throws Exception {
        //先获取所有日期。
//        String date = dayMapper.select().get(0).getDayDate();
//        Calendar calendar;
//        calendar = Calendar.getInstance();
//        //再通过日期获取出该日的数据；
//        Map<String, String> param = new HashMap<String, String>();
//        String getOneDayContentUrl = getInterfaceUrl("getOneDayContent");
//        String getOneDayContentUrls = getOneDayContentUrl + date;
//        System.out.println(getOneDayContentUrls);
//        String content = "";
//        Pattern p;
//        Matcher m = null;
//        String picUrl = "";
//        try {
//            List<GankContent> gankContents = gankContentMapper.selectByNewDate(date);
//            System.out.println(gankContents.size());
//            if (gankContents.size() < 1) {
//            } else {
//                //TODO 如果如果数据库中存在，获取出数据，然后正则表达式匹配；
//                GankContent gankContent = gankContents.get(0);
//                content = gankContent.getContent();
//                p = Pattern.compile("<img[^>]+src\\s*=\\s*\\\\['\"]([^'\"]+)['\"][^>]*>");//<img[^<>]*src=[\'\"]([0-9A-Za-z.\\/]*)[\'\"].(.*?)>");
//                m = p.matcher(content);
//                picUrl = gankContent.getImgUrl();
//            }
//        } catch (Exception e) {
//        } finally {
//        }
//        //对图文消息
//        newmsg.setCreateTime(new Date().getTime());
//        newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
//        Article article = new Article();
//        article.setDescription("每日最新的技术分享"); //图文消息的描述
//        article.setPicUrl(picUrl); //图文消息图片地址
//        article.setTitle("Android、IOS技术分享");  //图文消息标题
//        article.setUrl("http://earyant.tunnel.qydev.com/wechat/gank/getOneDayContent.action?day=" + date);  //图文url链接
//        List<Article> list = new ArrayList<Article>();
//        list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
//        newmsg.setArticleCount(list.size());
//        newmsg.setArticles(list);
        return MessageUtil.newsMessageToXml(newmsg);
    }
}
