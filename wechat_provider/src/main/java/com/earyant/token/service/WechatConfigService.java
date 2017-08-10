package com.earyant.token.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by earyant on 2017 : 07 : 2017/7/21 : 14:24 : .
 * ln_spring_boot  com.earyant.service
 */
@FeignClient(value = "wechat-config", fallback = WechatConfigServiceHystric.class)
public interface WechatConfigService {
//    @GetMapping(value = "/getTokenUrl")
//    String sayHiFromClientOne();

    @GetMapping(value = "/getTokenUrl")
    String getTokenUrl();

//    @GetMapping(value = "/timestamp")
//    String timestamp();
//
    @GetMapping(value = "/OpenidUserinfoUrl")
    String OpenidUserinfoUrl();
//
//    @GetMapping(value = "/jsapi_ticket")
//    String jsapi_ticket();
}
