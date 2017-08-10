package com.earyant.token.service;

import org.springframework.stereotype.Component;

/**
 * Created by earyant on 2017 : 07 : 2017/7/21 : 14:45 : .
 * ln_spring_boot  com.earyant.service
 */
@Component
public class WechatConfigServiceHystric implements WechatConfigService {
//    @Override
//    public String sayHiFromClientOne() {
//        return "sorry";
//    }

    @Override
    public String getTokenUrl() {
        return "https://api.weixin.qq.com/cgi-bin/token";
    }


    @Override
    public String OpenidUserinfoUrl() {
        return "https://api.weixin.qq.com/cgi-bin/user/info";
    }

}
