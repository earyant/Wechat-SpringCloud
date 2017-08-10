package com.earyant.commentdatabase.redis.model;

import lombok.Data;

/**
 * Created by earyant on 2017 : 08 : 2017/8/4 : 22:11 : .
 * ln_spring_boot  com.earyant.commentdatabase.redis.model
 */
@Data
public class RedisModel {
    private String redisKey;//redis中的key
    private String name;//姓名
    private String tel;//电话
    private String address;//住址
}
