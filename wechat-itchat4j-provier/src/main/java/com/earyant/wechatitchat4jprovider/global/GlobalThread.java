package com.earyant.wechatitchat4jprovider.global;

import com.alibaba.fastjson.JSON;
import com.earyant.wechatitchat4jprovider.dao.User;
import com.earyant.wechatitchat4jprovider.itchat4j.service.impl.LoginServiceImpl;
import com.earyant.wechatitchat4jprovider.utils.JedisUtil;
import com.earyant.wechatitchat4jprovider.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by earyant on 2017 : 08 : 2017/8/8 : 15:24 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.global
 */

@Component
public class GlobalThread implements Runnable {
    @Autowired
    LoginServiceImpl loginService;
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void run() {
        while (true) {
            User user = null;
            JedisUtil je = JedisUtil.getRu();
            String us = je.lpop("user");
            if (!StringUtils.isEmpty(us)) {
                try {
                    System.out.println("us:  " + us);
                    user = JSON.parseObject(us, User.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (user != null && !user.isAlive()) {
                    loginService.login(user);
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
