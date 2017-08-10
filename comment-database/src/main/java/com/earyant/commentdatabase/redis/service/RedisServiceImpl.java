package com.earyant.commentdatabase.redis.service;

import org.springframework.stereotype.Service;

/**
 * Created by earyant on 2017 : 08 : 2017/8/4 : 22:12 : .
 * ln_spring_boot  com.earyant.commentdatabase.redis.service
 */
@Service
public class RedisServiceImpl<T> extends IRedisService<T> {
    private static final String REDIS_KEY = "wechat";

    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}