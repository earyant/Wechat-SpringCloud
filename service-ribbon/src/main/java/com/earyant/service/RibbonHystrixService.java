package com.earyant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by earyant on 2017 : 07 : 2017/7/29 : 17:07 : .
 * ln_spring_boot  com.earyant.service
 */
@Service
public class RibbonHystrixService {
    @Autowired
    RestTemplate restTemplate;



}
