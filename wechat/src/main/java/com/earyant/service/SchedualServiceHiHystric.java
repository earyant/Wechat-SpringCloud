package com.earyant.service;

import org.springframework.stereotype.Component;

/**
 * Created by earyant on 2017 : 07 : 2017/7/21 : 14:45 : .
 * ln_spring_boot  com.earyant.service
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
