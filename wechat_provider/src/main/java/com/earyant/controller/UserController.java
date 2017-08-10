package com.earyant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by earyant on 2017 : 07 : 2017/7/29 : 15:38 : .
 * ln_spring_boot  com.earyant.controller
 */
@RestController
public class UserController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/id")
    public String findById(String id){
        return " id ::: "+id+"";
    }
    @GetMapping("/instace-info")
    public ServiceInstance showInfo(){
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }
}
