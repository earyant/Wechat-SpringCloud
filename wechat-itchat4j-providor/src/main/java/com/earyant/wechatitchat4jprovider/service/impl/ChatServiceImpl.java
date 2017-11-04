package com.earyant.wechatitchat4jprovider.service.impl;

import com.earyant.wechat.message.resp.Image;
import com.earyant.wechat.message.resp.ImageMessage;
import com.earyant.wechat.message.resp.TextMessage;
import com.earyant.wechat.util.HttpPostUploadUtil;
import com.earyant.wechat.util.MessageUtil;
import com.earyant.wechatitchat4jprovider.dao.ReplyConfig;
import com.earyant.wechatitchat4jprovider.dao.repository.ReplyConfigRepository;
import com.earyant.wechatitchat4jprovider.dao.repository.UserInfoRepository;
import com.earyant.wechatitchat4jprovider.itchat4j.service.ILoginService;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.SleepUtils;
import com.earyant.wechatitchat4jprovider.service.ChatService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 17:17 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.service.impl
 */
@Service
public class ChatServiceImpl implements ChatService {
    private Logger LOG = LoggerFactory.getLogger(ChatServiceImpl.class);
    @Autowired
    private ILoginService loginService;
    @Autowired
    UserInfoRepository userRepository;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ReplyConfigRepository replyConfigRepository;

    @Override
    public String chat(Map<String, String> map, String path) {
        String openid = map.get("FromUserName"); // 用户openid
        String mpid = map.get("ToUserName"); // 公众号原始ID
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setToUserName(openid);
        imageMessage.setFromUserName(mpid);
        imageMessage.setCreateTime(new Date().getTime());
        imageMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);

        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        String qrPath = path; // 保存登陆二维码图片的路径，这里需要在本地新建目录
//        IMsgHandlerFace msgHandler = new WechatHandler(); // 实现IMsgHandlerFace接口的类
        String qr_path = "";
        for (int count = 0; count < 10; count++) {
            LOG.info("get UUID");
            String uuid = loginService.getUuid(openid);
            if (uuid == null) {
                LOG.info("1. get wechat UUID");
                while (loginService.getUuid(openid) == null) {
                    LOG.warn("1.1. get wechat UUID失败，2 second retry");
                    SleepUtils.sleep(1000);
                }
            }
            LOG.info("2. get login qr img");
            qr_path = loginService.getQR(qrPath, openid, uuid);
            if (!ObjectUtils.isEmpty(qr_path)) {
                break;
//            } else if (count == 2) {
//                stringRedisTemplate.opsForValue().get("user");
//                LOG.error("2.2.  get login qr img, system out");
//                qr_path = "出现错误，请重试";
            }
        }
        String token = map.get("access_token");
//        imageMessage.setImage(new Image());
        Image img = new Image();
        HttpPostUploadUtil util = new HttpPostUploadUtil(token);
        String filepath = qr_path;
        Map<String, String> textMap = new HashMap<String, String>();
        textMap.put("name", "testname");
        Map<String, String> fileMap = new HashMap<String, String>();
        fileMap.put("userfile", filepath);
        String mediaidrs = util.formUpload(textMap, fileMap);
        LOG.info("mediaidrs::  " + mediaidrs);
        String mediaid = JSONObject.fromObject(mediaidrs).getString("media_id");
        img.setMediaId(mediaid);
        imageMessage.setImage(img);
//        User user = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(openid);

//        开启线程检查是否登录
//        ExecutorService service = Executors.newFixedThreadPool(4);
//        service.submit(new Runnable() {
//            @Override
//            public void run() {
//                User u = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(openid);
//                while (!u.isAlive()) {
//                    loginService.login(u);
//                    u = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(openid);
//                }
//            }
//        });


        return MessageUtil.imageMessageToXml(imageMessage);
    }

    @Override
    public String login(HashMap<String, String> map) {
        return null;
    }

    @Override
    public String setBackUp(HashMap<String, String> map) {
        String openid = map.get("FromUserName"); // 用户openid
        String mpid = map.get("ToUserName"); // 公众号原始ID
        TextMessage TextMessage = new TextMessage();
        TextMessage.setToUserName(openid);
        TextMessage.setFromUserName(mpid);
        TextMessage.setCreateTime(new Date().getTime());
        TextMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

        String content = map.get("Content");
        ReplyConfig replyConfig = new ReplyConfig();
        replyConfig.setWechatId(openid);
        LOG.debug("Content :  " + content);
        /**
         * 	TEXT("Text", "文本消息"),
         PIC("Pic", "图片消息"),
         VOICE("Voice", "语音消息"),
         VIEDO("Viedo", "小视频消息"),
         NAMECARD("NameCard", "名片消息"),
         SYS("Sys", "系统消息"),
         VERIFYMSG("VerifyMsg", "添加好友"),
         MEDIA("app", "文件消息");
         */
        switch (content) {
            case "开启聊天回复":
                replyConfig.setReplyType(1);
                break;
            case "开启语音回复":
                replyConfig.setReplyType(2);
                break;
            case "开启图片回复":
                replyConfig.setReplyType(4);
                break;
            case "开启撤回回复":
                replyConfig.setReplyType(8);
                break;
            case "开启视频回复":
                replyConfig.setReplyType(16);
                break;
            case "开启名片回复":
                replyConfig.setReplyType(32);
                break;
            case "开启系统消息回复":
                replyConfig.setReplyType(64);
                break;
            case "开启添加好友回复":
                replyConfig.setReplyType(128);
                break;
            case "开启文件消息回复":
                replyConfig.setReplyType(256);
                break;
            case "开启群消息回复":
                replyConfig.setReplyType(512);
                break;
            default:
                replyConfig.setReplyType(1);
        }
        replyConfigRepository.save(replyConfig);
        TextMessage.setContent("设置成功");
        return MessageUtil.textMessageToXml(TextMessage);
    }
}
