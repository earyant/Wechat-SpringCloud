package com.earyant.commentdatabase.redis.unused;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by earyant on 2017 : 07 : 2017/7/29 : 23:36 : .
 * ln_spring_boot  com.earyant.commentdatabase.redis
 */
@RestController
public class RedisLockDemo {

    @Autowired
    DistributedLockHandler distributedLockHandler;

    @GetMapping("/getRedisLock")
    public void getRedisLock() {
        RedisLock redisLock = new RedisLock("lock", "ssss");
        if (distributedLockHandler.tryLock(redisLock)) {
            //TODO dosomething
            distributedLockHandler.releaseLock(redisLock);
        }
    }
}
