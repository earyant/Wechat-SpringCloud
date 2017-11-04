//package com.earyant.wechatitchat4jprovider.global;
//
//import com.earyant.wechatitchat4jprovider.dao.User;
//import com.earyant.wechatitchat4jprovider.dao.bean.ContactListBean;
//import com.earyant.wechatitchat4jprovider.dao.repository.UserInfoRepository;
//import com.earyant.wechatitchat4jprovider.dao.wxsync.WebWxSync;
//import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.RetCodeEnum;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//import java.util.logging.Logger;
//
///**
// * Created by earyant on 2017 : 09 : 2017/9/6 0006 : 11:06 : .
// * WechatCloud  com.earyant.wechatitchat4jprovider.global
// */
//public class ReceiveThread implements Runnable {
//    Logger LOG = Logger.getLogger(ReceiveThread.class.getName());
//    int retryCount = 0;
//    @Autowired
//    UserInfoRepository userInfoRepository;
//    @Override
//    public void run() {
//        while (true) {
//            User core = userInfoRepository.findTop1ByWechatIdOrderByCreateTimeDesc(wechatId);
//            try {
//                Map<String, String> resultMap = syncCheck(core);
//                String retcode = resultMap.get("retcode");
//                String selector = resultMap.get("selector");
//                if (retcode.equals(RetCodeEnum.UNKOWN.getCode())) {
//                    LOG.info(RetCodeEnum.UNKOWN.getType());
//                    continue;
//                } else if (retcode.equals(RetCodeEnum.LOGIN_OUT.getCode())) { // 退出
//                    LOG.info(RetCodeEnum.LOGIN_OUT.getType());
//                    break;
//                } else if (retcode.equals(RetCodeEnum.LOGIN_OTHERWHERE.getCode())) { // 其它地方登陆
//                    LOG.info(RetCodeEnum.LOGIN_OTHERWHERE.getType());
//                    break;
//                } else if (retcode.equals(RetCodeEnum.MOBILE_LOGIN_OUT.getCode())) { // 移动端退出
//                    LOG.info(RetCodeEnum.MOBILE_LOGIN_OUT.getType());
//                    break;
//                } else if (retcode.equals(RetCodeEnum.NORMAL.getCode())) {
//                    core.setLastNormalRetcodeTime(System.currentTimeMillis()); // 最后收到正常报文时间
//                    WebWxSync msgObj = webWxSync(core);
//                    if (selector.equals("2")) {
//                        if (msgObj != null) {
//                            try {
//                                List<WebWxSync.AddMsgListBean> msgList;
//                                msgList = msgObj.getAddMsgList();
////                                        消息处理
//                                msgList = msgCenter.produceMsg(msgList, core);
//                                msgList.forEach(msg -> {
//                                    WebWxSync.AddMsgListBean.RecommendInfoBean recommendInfo = msg.getRecommendInfo();
//                                    msg = addMsgListBeanRepository.save(msg);
//                                    String msgId = msg.getId() + "";
//                                    recommendInfo.setMsgId(msgId);
//                                    recommendInfoBeanRepository.save(recommendInfo);
//                                });
//                            } catch (Exception e) {
//                                LOG.info(e.getMessage());
//                            }
//                        }
//                    } else if (selector.equals("7")) {
//                        webWxSync(core);
//                    } else if (selector.equals("4")) {
//                        continue;
//                    } else if (selector.equals("3")) {
//                        continue;
//                    } else if (selector.equals("6")) {
//                        if (msgObj != null) {
//                            try {
//                                List<WebWxSync.AddMsgListBean> msgList;
//                                msgList = msgObj.getAddMsgList();
//                                List<ContactListBean> modContactList = msgObj.getModContactList(); // 存在删除或者新增的好友信息
//                                msgList = msgCenter.produceMsg(msgList, core);
//                                for (int j = 0; j < msgList.size(); j++) {
//                                    ContactListBean userInfo = modContactList.get(j);
//                                    core.getContactlist().add(userInfo);
//                                }
//                            } catch (Exception e) {
//                                LOG.info(e.getMessage());
//                            }
//                        }
//
//                    }
//                } else {
//                    WebWxSync obj = webWxSync(core);
//                }
//            } catch (Exception e) {
//                LOG.info(e.getMessage());
//                retryCount += 1;
//                if (core.getReceivingRetryCount() < retryCount) {
//                    core.setAlive(false);
//                } else {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e1) {
//                        LOG.info(e.getMessage());
//                    }
//                }
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//}
