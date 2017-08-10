package com.earyant.wechatitchat4jprovider.global;

import com.alibaba.fastjson.JSON;
import com.earyant.wechatitchat4jprovider.dao.User;
import com.earyant.wechatitchat4jprovider.itchat4j.api.WechatTools;
import com.earyant.wechatitchat4jprovider.itchat4j.service.impl.LoginServiceImpl;
import com.earyant.wechatitchat4jprovider.itchat4j.thread.CheckLoginStatusThread;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.tools.CommonTools;
import com.earyant.wechatitchat4jprovider.utils.JedisUtil;
import com.earyant.wechatitchat4jprovider.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by earyant on 2017 : 08 : 2017/8/8 : 15:24 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.global
 */

@Component
@EnableScheduling
public class GlobalThread {
    Logger LOG = Logger.getLogger(GlobalThread.class.getName());
    @Autowired
    LoginServiceImpl loginService;
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    //    @Override
    @Scheduled(fixedDelay = 6000000)
    public void run() {
        LOG.info("启动成功，正在检测状态");
        while (true) {
            User user = null;
            JedisUtil je = JedisUtil.getRu();
            String us = je.lpop("user");
            if (!StringUtils.isEmpty(us)) {
                try {
                    user = JSON.parseObject(us, User.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (user != null && !user.isAlive() && loginService.login(user)) {

                    LOG.info("5. 登陆成功，微信初始化");
                    if (!loginService.webWxInit(user.getWechatId())) {
                        LOG.info("6. 微信初始化异常");
                        System.exit(0);
                    }

                    LOG.info("6. 开启微信状态通知");
                    loginService.wxStatusNotify(user.getWechatId());

                    LOG.info("7. 清除。。。。");
                    CommonTools.clearScreen();
                    LOG.info(String.format("欢迎回来， %s", user.getNickName()));

                    LOG.info("8. 开始接收消息");
                    loginService.startReceiving(user.getWechatId());

                    LOG.info("9. 获取联系人信息");
                    loginService.webWxGetContact(user.getWechatId());

                    LOG.info("10. 获取群好友及群好友列表");
                    loginService.WebWxBatchGetContact(user.getWechatId());

                    LOG.info("11. 缓存本次登陆好友相关消息");
                    WechatTools.setUserInfo(); // 登陆成功后缓存本次登陆好友相关消息（NickName, UserName）

                    LOG.info("12.开启微信状态检测线程");
                    new Thread(new CheckLoginStatusThread()).start();
                } else {
                    je.lpush("user", JSON.toJSONString(user));
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
