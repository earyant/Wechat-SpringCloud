//package com.earyant.wechatitchat4jprovider.itchat4j.controller;
//
//import com.earyant.wechatitchat4jprovider.itchat4j.api.WechatTools;
//import com.earyant.wechatitchat4jprovider.itchat4j.core.Core;
//import com.earyant.wechatitchat4jprovider.itchat4j.service.ILoginService;
//import com.earyant.wechatitchat4jprovider.itchat4j.service.impl.LoginServiceImpl;
//import com.earyant.wechatitchat4jprovider.itchat4j.thread.CheckLoginStatusThread;
//import com.earyant.wechatitchat4jprovider.itchat4j.utils.SleepUtils;
//import com.earyant.wechatitchat4jprovider.itchat4j.utils.tools.CommonTools;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.ObjectUtils;
//
///**
// * 登陆控制器
// *
// * @author https://github.com/yaphone
// * @version 1.0
// * @date 创建时间：2017年5月13日 下午12:56:07
// */
//
//public class LoginController {
//    private static Logger LOG = LoggerFactory.getLogger(LoginController.class);
//    private ILoginService loginService = new LoginServiceImpl();
//    private static Core core = new Core();
//
//    public void login(String qrPath) {
//        if (core.isAlive()) { // 已登陆
//            LOG.info("itchat4j is logined");
//            return;
//        }
//        while (true) {
//            for (int count = 0; count < 10; count++) {
//                LOG.info("get UUID");
//                while (loginService.getUuid() == null) {
//                    LOG.info("1. get wechat UUID");
//                    while (loginService.getUuid() == null) {
//                        LOG.warn("1.1. get wechat UUID失败，2 second retry");
//                        SleepUtils.sleep(2000);
//                    }
//                }
//                LOG.info("2. get login qr img");
//                if (!ObjectUtils.isEmpty(loginService.getQR(qrPath))) {
//                    break;
//                } else if (count == 10) {
//                    LOG.error("2.2.  get login qr img, system out");
//                    System.exit(0);
//                }
//            }
//            LOG.info("3. please scan the img");
//            if (!core.isAlive()) {
//                loginService.login();
////				core.setAlive(true);
//                LOG.info(("please login"));
//                break;
//            }
//            LOG.info("4. login timeout ");
//        }
//
//        LOG.info("5. login seccess");
//        if (!loginService.webWxInit()) {
//            LOG.info("6. wechat init exception");
//            System.exit(0);
//        }
//
//        LOG.info("6. open wechat notify");
//        loginService.wxStatusNotify();
//
//        LOG.info("7. clear。。。。");
//        CommonTools.clearScreen();
//        LOG.info(String.format("welcome back ， %s", core.getNickName()));
//
//        LOG.info("8. starting accept message");
//        loginService.startReceiving();
//
//        LOG.info("9. get constact info ");
//        loginService.webWxGetContact();
//
//        LOG.info("10. get group info ");
//        loginService.WebWxBatchGetContact();
//
//        LOG.info("11. cache friend info ");
//        WechatTools.setUserInfo(); // 登陆成功后缓存本次登陆好友相关消息（NickName, UserName）
//
//        LOG.info("12.start wechat status inspect thread");
//        new Thread(new CheckLoginStatusThread()).start();
//    }
//}