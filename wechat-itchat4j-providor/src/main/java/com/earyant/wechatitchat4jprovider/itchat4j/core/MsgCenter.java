package com.earyant.wechatitchat4jprovider.itchat4j.core;

import com.alibaba.fastjson.JSONObject;
import com.earyant.wechatitchat4jprovider.itchat4j.api.MessageTools;
import com.earyant.wechatitchat4jprovider.itchat4j.beans.BaseMsg;
import com.earyant.wechatitchat4jprovider.itchat4j.face.IMsgHandlerFace;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.MsgCodeEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.MsgTypeEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.tools.CommonTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

/**
 * 消息处理中心
 *
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 创建时间：2017年5月14日 下午12:47:50
 */
public class MsgCenter {
    private static Logger LOG = LoggerFactory.getLogger(MsgCenter.class);

    private static Core core = new Core();

    /**
     * 接收消息，放入队列
     *
     * @param msgList
     * @return
     * @author https://github.com/yaphone
     * @date 2017年4月23日 下午2:30:48
     */
    public static List<BaseMsg> produceMsg(List<BaseMsg> msgList) {
        List<BaseMsg> result = new ArrayList<>();
        for (int i = 0; i < msgList.size(); i++) {
            JSONObject msg = new JSONObject();
            BaseMsg m = msgList.get(i);
            System.out.println("m ==== " + m);
            m.setGroupMsg(false);// 是否是群消息
            if (m.getFromUserName().contains("@@") || m.getToUserName().contains("@@")) { // 群聊消息
                if (m.getFromUserName().contains("@@")
                        && !core.getGroupIdList().contains(m.getFromUserName())) {
                    core.getGroupIdList().add((m.getFromUserName()));
                } else if (m.getToUserName().contains("@@")
                        && !core.getGroupIdList().contains(m.getToUserName())) {
                    core.getGroupIdList().add((m.getToUserName()));
                }
                // 群消息与普通消息不同的是在其消息体（Content）中会包含发送者id及":<br/>"消息，这里需要处理一下，去掉多余信息，只保留消息内容
                if (m.getContent().contains("<br/>")) {
                    String content = m.getContent().substring(m.getContent().indexOf("<br/>") + 5);
                    m.setContent(content);
                    m.setGroupMsg(true);
                }
            } else {
                CommonTools.msgContentFormatter(m);
            }
            if (m.getMsgType() == (MsgCodeEnum.MSGTYPE_TEXT.getCode())) { // words
                // 文本消息
                if (m.getUrl().length() != 0) {
                    String regEx = "(.+?\\(.+?\\))";
                    Matcher matcher = CommonTools.getMatcher(regEx, m.getContent());
                    String data = "Map";
                    if (matcher.find()) {
                        data = matcher.group(1);
                    }
                    msg.put("Type", "Map");
                    msg.put("Text", data);
                } else {
                    msg.put("Type", MsgTypeEnum.TEXT.getType());
                    msg.put("Text", m.getContent());
                }
                m.setType(msg.getString("Type"));
                m.setText(msg.getString("Text"));
            } else if (m.getMsgType() == (MsgCodeEnum.MSGTYPE_IMAGE.getCode())
                    || m.getMsgType() == (MsgCodeEnum.MSGTYPE_EMOTICON.getCode())) { // 图片消息
                m.setType(MsgTypeEnum.PIC.getType());
            } else if (m.getMsgType() == (MsgCodeEnum.MSGTYPE_VOICE.getCode())) { // 语音消息
                m.setType(MsgTypeEnum.VOICE.getType());
            } else if (m.getMsgType()==(MsgCodeEnum.MSGTYPE_VERIFYMSG.getCode())) {// friends
                // 好友确认消息
                // MessageTools.addFriend(core, userName, 3, ticket); // 确认添加好友
                m.setType(MsgTypeEnum.VERIFYMSG.getType());

            } else if (m.getMsgType()==(MsgCodeEnum.MSGTYPE_SHARECARD.getCode())) { // 共享名片
                m.setType(MsgTypeEnum.NAMECARD.getType());

            } else if (m.getMsgType()==(MsgCodeEnum.MSGTYPE_VIDEO.getCode())
                    || m.getMsgType()==(MsgCodeEnum.MSGTYPE_MICROVIDEO.getCode())) {// viedo
                m.setType(MsgTypeEnum.VIEDO.getType());
            } else if (m.getMsgType()==(MsgCodeEnum.MSGTYPE_MEDIA.getCode())) { // 多媒体消息
                m.setType(MsgTypeEnum.MEDIA.getType());
            } else if (m.getMsgType()==(MsgCodeEnum.MSGTYPE_STATUSNOTIFY.getCode())) {// phone
                // init
                // 微信初始化消息

            } else if (m.getMsgType()==(MsgCodeEnum.MSGTYPE_SYS.getCode())) {// 系统消息
                m.setType(MsgTypeEnum.SYS.getType());
            } else if (m.getMsgType()==(MsgCodeEnum.MSGTYPE_RECALLED.getCode())) { // 撤回消息

            } else {
                LOG.info("Useless msg");
            }
            LOG.info("收到消息一条，来自: " + m.getFromUserName());
            result.add(m);
        }
        return result;
    }

    /**
     * 消息处理
     *
     * @param msgHandler
     * @author https://github.com/yaphone
     * @date 2017年5月14日 上午10:52:34
     */
    public static void handleMsg(IMsgHandlerFace msgHandler) {
        while (true) {
            if (core.getMsgList().size() > 0 && core.getMsgList().get(0).getContent() != null) {
                if (core.getMsgList().get(0).getContent().length() > 0) {
                    BaseMsg msg = core.getMsgList().get(0);
                    if (msg.getType() != null) {
                        try {
                            if (msg.getType().equals(MsgTypeEnum.TEXT.getType())) {
                                String result = msgHandler.textMsgHandle(msg);
                                MessageTools.sendMsgById(result, core.getMsgList().get(0).getFromUserName());
                            } else if (msg.getType().equals(MsgTypeEnum.PIC.getType())) {

                                String result = msgHandler.picMsgHandle(msg);
                                MessageTools.sendMsgById(result, core.getMsgList().get(0).getFromUserName());
                            } else if (msg.getType().equals(MsgTypeEnum.VOICE.getType())) {
                                String result = msgHandler.voiceMsgHandle(msg);
                                MessageTools.sendMsgById(result, core.getMsgList().get(0).getFromUserName());
                            } else if (msg.getType().equals(MsgTypeEnum.VIEDO.getType())) {
                                String result = msgHandler.viedoMsgHandle(msg);
                                MessageTools.sendMsgById(result, core.getMsgList().get(0).getFromUserName());
                            } else if (msg.getType().equals(MsgTypeEnum.NAMECARD.getType())) {
                                String result = msgHandler.nameCardMsgHandle(msg);
                                MessageTools.sendMsgById(result, core.getMsgList().get(0).getFromUserName());
                            } else if (msg.getType().equals(MsgTypeEnum.SYS.getType())) { // 系统消息
                                msgHandler.sysMsgHandle(msg);
                            } else if (msg.getType().equals(MsgTypeEnum.VERIFYMSG.getType())) { // 确认添加好友消息
                                String result = msgHandler.verifyAddFriendMsgHandle(msg);
                                MessageTools.sendMsgById(result,
                                        core.getMsgList().get(0).getRecommendInfo().getUserName());
                            } else if (msg.getType().equals(MsgTypeEnum.MEDIA.getType())) { // 多媒体消息
                                String result = msgHandler.mediaMsgHandle(msg);
                                MessageTools.sendMsgById(result, core.getMsgList().get(0).getFromUserName());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                core.getMsgList().remove(0);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
