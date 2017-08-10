package com.earyant.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by earyant on 2017 : 07 : 2017/7/21 : 14:24 : .
 * ln_spring_boot  com.earyant.service
 */
@FeignClient(value = "wechat-provider",fallback = SchedualServiceHiHystric.class )
public interface SchedualServiceHi {
    @GetMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
