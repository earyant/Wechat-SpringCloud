package com.earyant.wechatitchat4jprovider.handler;

import com.earyant.wechatitchat4jprovider.dao.User;
import com.earyant.wechatitchat4jprovider.dao.wxsync.WebWxSync;
import com.earyant.wechatitchat4jprovider.itchat4j.api.MessageTools;
import com.earyant.wechatitchat4jprovider.itchat4j.api.WechatTools;
import com.earyant.wechatitchat4jprovider.itchat4j.core.Core;
import com.earyant.wechatitchat4jprovider.itchat4j.face.IMsgHandlerFace;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.MsgTypeEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.tools.DownloadTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 简单示例程序，收到文本信息自动回复原信息，收到图片、语音、小视频后根据路径自动保存
 *
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 创建时间：2017年4月25日 上午12:18:09
 */
@Service
public class WechatHandler implements IMsgHandlerFace {
    Logger LOG = Logger.getLogger(WechatHandler.class);
    String url = "http://www.tuling123.com/openapi/api";
    String apiKey = "597b34bea4ec4c85a775c469c84b6817";
    @Autowired
    MessageTools messageTools;
    @Autowired
    WechatTools wechatTools;

    @Override
    public String textMsgHandle(WebWxSync.AddMsgListBean msg) {
        // String docFilePath = "D:/itchat4j/pic/1.jpg"; // 这里是需要发送的文件的路径
//        if (msg.getFromUserName().equals("filehelper")) {
//            String text = msg.getText();
//            Map<String, String> paramMap = new HashMap<String, String>();
//            paramMap.put("key", apiKey);
//            paramMap.put("info", text);
//            paramMap.put("userid", "123456");
//            String paramStr = JSON.toJSONString(paramMap);
//            MyHttpClient myHttpClient = MyHttpClient.getInstance();
//            HttpEntity entity = myHttpClient.doPost(url, paramStr);
//            String result = null;
//            try {
//                result = EntityUtils.toString(entity, "UTF-8");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            JSONObject obj = JSON.parseObject(result);
//            if (obj.getString("code").equals("100000")) {
//                result = obj.getString("text");
//            } else {
//                result = "处理有误";
//            }
//            return result;
//        }
        if (!msg.isGroupMsg()) { // 群消息不处理
            // String userId = msg.getString("FromUserName");
            // MessageTools.sendFileMsgByUserId(userId, docFilePath); // 发送文件
            // MessageTools.sendPicMsgByUserId(userId, docFilePath);
            String text = msg.getText(); // 发送文本消息，也可调用MessageTools.sendFileMsgByUserId(userId,text);
            LOG.info(text);
            if (text.equals("111")) {
                wechatTools.logout();
            }
            if (text.equals("222")) {
                wechatTools.remarkNameByNickName("yaphone", "Hello");
            }
            if (text.equals("333")) { // 测试群列表
                System.out.print(wechatTools.getGroupNickNameList());
                System.out.print(wechatTools.getGroupIdList());
                System.out.print(new Core().getGroupMemeberMap());
            }
            return text;
        }
        return null;
    }

    @Override
    public String picMsgHandle(WebWxSync.AddMsgListBean msg) {
        String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());// 这里使用收到图片的时间作为文件名
        String picPath = "D://workspace/java/m/WechatCloud/wechat-itchat4j-providor/msg/pic" + File.separator + fileName + msg.getFileName(); // 调用此方法来保存图片
        DownloadTools.getDownloadFn(msg, MsgTypeEnum.PIC.getType(), picPath); // 保存图片的路径
        return "图片保存成功";
    }

    @Override
    public String voiceMsgHandle(WebWxSync.AddMsgListBean msg) {
        String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String voicePath = "D://workspace/java/m/WechatCloud/wechat-itchat4j-providor/msg/voice" + File.separator + fileName + ".mp3";
        DownloadTools.getDownloadFn(msg, MsgTypeEnum.VOICE.getType(), voicePath);
        return "声音保存成功";
    }

    @Override
    public String viedoMsgHandle(WebWxSync.AddMsgListBean msg) {
        String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String viedoPath = "D://workspace/java/m/WechatCloud/wechat-itchat4j-providor/msg/viedo" + File.separator + fileName + ".mp4";
        DownloadTools.getDownloadFn(msg, MsgTypeEnum.VIEDO.getType(), viedoPath);
        return "视频保存成功";
    }

    @Override
    public String nameCardMsgHandle(WebWxSync.AddMsgListBean msg) {
        return "收到名片消息";
    }

    @Override
    public void sysMsgHandle(WebWxSync.AddMsgListBean msg) { // 收到系统消息
        String text = msg.getContent();
        LOG.info(text);
    }

    @Override
    public String verifyAddFriendMsgHandle(WebWxSync.AddMsgListBean msg, User core) {
        messageTools.addFriend(msg, true, core); // 同意好友请求，false为不接受好友请求
        WebWxSync.AddMsgListBean.RecommendInfoBean recommendInfo = msg.getRecommendInfo();
        String nickName = recommendInfo.getNickName();
        String province = recommendInfo.getProvince();
        String city = recommendInfo.getCity();
        String text = "你好，来自" + province + city + "的" + nickName + "， 欢迎添加我为好友！";
        return text;
    }

    @Override
    public String mediaMsgHandle(WebWxSync.AddMsgListBean msg) {
        String fileName = msg.getFileName();
        String filePath = "D://workspace/java/m/WechatCloud/wechat-itchat4j-providor/msg/file" + File.separator + fileName; // 这里是需要保存收到的文件路径，文件可以是任何格式如PDF，WORD，EXCEL等。
        DownloadTools.getDownloadFn(msg, MsgTypeEnum.MEDIA.getType(), filePath);
        return "文件" + fileName + "保存成功";
    }

}
