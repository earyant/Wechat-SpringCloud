package com.earyant.wechatitchat4jprovider.itchat4j.core;

import com.alibaba.fastjson.JSONObject;
import com.earyant.wechatitchat4jprovider.dao.GroupName;
import com.earyant.wechatitchat4jprovider.dao.User;
import com.earyant.wechatitchat4jprovider.dao.repository.GroupNameRepository;
import com.earyant.wechatitchat4jprovider.dao.wxsync.WebWxSync;
import com.earyant.wechatitchat4jprovider.handler.WechatHandler;
import com.earyant.wechatitchat4jprovider.itchat4j.api.MessageTools;
import com.earyant.wechatitchat4jprovider.itchat4j.face.IMsgHandlerFace;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.MsgCodeEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.MsgTypeEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.tools.CommonTools;
import com.earyant.wechatitchat4jprovider.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;

/**
 * 消息处理中心
 *
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 创建时间：2017年5月14日 下午12:47:50
 */
@Component
public class MsgCenter {
    private static Logger LOG = LoggerFactory.getLogger(MsgCenter.class);

    @Autowired
    GroupNameRepository groupNameRepository;

    @Autowired
    MessageTools messageTools;
    /**
     * 接收消息，放入队列
     *
     * @param msgList
     * @param core
     * @return
     * @author https://github.com/yaphone
     * @date 2017年4月23日 下午2:30:48
     */
    public List<WebWxSync.AddMsgListBean> produceMsg(List<WebWxSync.AddMsgListBean> msgList, User core) {
        List<GroupName> groupNameList = groupNameRepository.findAllById(core.getId());
        msgList.forEach(m -> {
            JSONObject msg = new JSONObject();
            m.setGroupMsg(false);// 是否是群消息
            if (m.getFromUserName().contains("@@") || m.getToUserName().contains("@@")) { // 群聊消息
                WebWxSync.AddMsgListBean finalM = m;
                groupNameList.forEach(groupName -> {
                    if (finalM.getFromUserName().contains("@@")
                            && !groupName.getIds().contains(finalM.getFromUserName())
                            ) {
//                        core.getGroupIdList().add((finalM.getFromUserName()));
                        GroupName groupName1 = new GroupName();
                        groupName1.setId(core.getId());
                        groupName1.setIds(finalM.getFromUserName());
                        groupNameRepository.save(groupName1);
                    } else if (finalM.getToUserName().contains("@@")
                            && !groupName.getIds().contains(finalM.getToUserName())) {
                        GroupName groupName1 = new GroupName();
                        groupName1.setId(core.getId());
                        groupName1.setIds(finalM.getToUserName());
                        groupNameRepository.save(groupName1);
                    }
                });

                // 群消息与普通消息不同的是在其消息体（Content）中会包含发送者id及":<br/>"消息，这里需要处理一下，去掉多余信息，只保留消息内容
                if (m.getContent().contains("<br/>")) {
                    String content = m.getContent().substring(m.getContent().indexOf("<br/>") + 5);
                    m.setContent(content);
                    m.setGroupMsg(true);
                }
            } else {
                m = CommonTools.msgContentFormatter(m);
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
            } else if (m.getMsgType() == (MsgCodeEnum.MSGTYPE_VERIFYMSG.getCode())) {// friends
                // 好友确认消息
                // messageTools.addFriend(core, userName, 3, ticket); // 确认添加好友
                m.setType(MsgTypeEnum.VERIFYMSG.getType());

            } else if (m.getMsgType() == (MsgCodeEnum.MSGTYPE_SHARECARD.getCode())) { // 共享名片
                m.setType(MsgTypeEnum.NAMECARD.getType());

            } else if (m.getMsgType() == (MsgCodeEnum.MSGTYPE_VIDEO.getCode())
                    || m.getMsgType() == (MsgCodeEnum.MSGTYPE_MICROVIDEO.getCode())) {// viedo
                m.setType(MsgTypeEnum.VIEDO.getType());
            } else if (m.getMsgType() == (MsgCodeEnum.MSGTYPE_MEDIA.getCode())) { // 多媒体消息
                m.setType(MsgTypeEnum.MEDIA.getType());
            } else if (m.getMsgType() == (MsgCodeEnum.MSGTYPE_STATUSNOTIFY.getCode())) {// phone
                // init
                // 微信初始化消息
            } else if (m.getMsgType() == (MsgCodeEnum.MSGTYPE_SYS.getCode())) {// 系统消息
                m.setType(MsgTypeEnum.SYS.getType());
            } else if (m.getMsgType() == (MsgCodeEnum.MSGTYPE_RECALLED.getCode())) { // 撤回消息

            } else {
                LOG.info("Useless msg");
            }
            LOG.info("accept a message  " + msgList.get(0).getContent() + " ,from : " + m.getFromUserName());
        });
        handleMsg(msgList, core);
        return msgList;
    }

    /**
     * 消息处理
     *
     * @author https://github.com/yaphone
     * @date 2017年5月14日 上午10:52:34
     */
    public void handleMsg(List<WebWxSync.AddMsgListBean> msgListBeans, User core) {
        IMsgHandlerFace msgHandler = new WechatHandler();
        if (msgListBeans.size() > 0 && msgListBeans.get(0).getContent() != null) {
            if (msgListBeans.get(0).getContent().length() > 0) {
                WebWxSync.AddMsgListBean msg = msgListBeans.get(0);
                if (msg.getType() != null) {
                    try {
                        if (msg.isGroupMsg()) {
                            return;
                        }
                        if (msg.getType().equals(MsgTypeEnum.TEXT.getType())) {
                            String result = msgHandler.textMsgHandle(msg);
                            if (!StringUtils.isEmail(result)) {
                                messageTools.sendMsgById(result, msgListBeans.get(0).getFromUserName(), core);
                            }
                        } else if (msg.getType().equals(MsgTypeEnum.PIC.getType())) {
                            String result = msgHandler.picMsgHandle(msg);
//                            messageTools.sendMsgById(result, msgListBeans.get(0).getFromUserName(), core);
                        } else if (msg.getType().equals(MsgTypeEnum.VOICE.getType())) {
                            String result = msgHandler.voiceMsgHandle(msg);
//                            messageTools.sendMsgById(result, msgListBeans.get(0).getFromUserName(), core);
                        } else if (msg.getType().equals(MsgTypeEnum.VIEDO.getType())) {
                            String result = msgHandler.viedoMsgHandle(msg);
//                            messageTools.sendMsgById(result, msgListBeans.get(0).getFromUserName(), core);
                        } else if (msg.getType().equals(MsgTypeEnum.NAMECARD.getType())) {
                            String result = msgHandler.nameCardMsgHandle(msg);
//                            messageTools.sendMsgById(result, msgListBeans.get(0).getFromUserName(), core);
                        } else if (msg.getType().equals(MsgTypeEnum.SYS.getType())) { // 系统消息
                            msgHandler.sysMsgHandle(msg);
                        } else if (msg.getType().equals(MsgTypeEnum.VERIFYMSG.getType())) { // 确认添加好友消息
                            String result = msgHandler.verifyAddFriendMsgHandle(msg, core);
//                            messageTools.sendMsgById(result,msgListBeans.get(0).getRecommendInfo().getUserName(), core);
                        } else if (msg.getType().equals(MsgTypeEnum.MEDIA.getType())) { // 多媒体消息
                            String result = msgHandler.mediaMsgHandle(msg);
//                            messageTools.sendMsgById(result, msgListBeans.get(0).getFromUserName(), core);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
