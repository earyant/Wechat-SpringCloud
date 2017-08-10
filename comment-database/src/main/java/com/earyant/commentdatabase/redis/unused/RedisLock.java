package com.earyant.commentdatabase.redis.unused;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by earyant on 2017 : 07 : 2017/7/29 : 23:30 : .
 * ln_spring_boot  com.earyant.commentdatabase.redis
 */
@Data
@AllArgsConstructor
public class RedisLock {
    private String name;
    private String value;
}
