package com.earyant.controller;

import com.earyant.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by earyant on 2017 : 07 : 2017/7/21 : 11:46 : .
 * ln_spring_boot  com.earyant.controller
 */

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        return helloService.hello(name);
    }
}
