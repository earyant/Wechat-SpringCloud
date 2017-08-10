package com.earyant.commentdatabase.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by earyant on 2017 : 07 : 2017/7/31 : 11:14 : .
 * ln_spring_boot  com.earyant.commentdatabase.redis
 */
@Component
public class RedissonConnector {
    RedissonClient redisson;
    @PostConstruct
    public void init(){
        redisson = Redisson.create();
    }

    public RedissonClient getClient(){
        return redisson;
    }

}