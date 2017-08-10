package com.earyant.commentdatabase.redis;

import com.earyant.commentdatabase.redis.exception.UnableToAquireLockException;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by earyant on 2017 : 07 : 2017/7/31 : 11:19 : .
 * ln_spring_boot  com.earyant.commentdatabase.redis
 */
@Component
public class RedisLocker  implements DistributedLocker{

    private final static String LOCKER_PREFIX = "lock:";

    @Autowired
    RedissonConnector redissonConnector;
    @Override
    public <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws InterruptedException, UnableToAquireLockException, Exception {

        return lock(resourceName, worker, 100);
    }

    @Override
    public <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws UnableToAquireLockException, Exception {
        RedissonClient redisson= redissonConnector.getClient();
        RLock lock = redisson.getLock(LOCKER_PREFIX + resourceName);
        // Wait for 100 seconds seconds and automatically unlock it after lockTime seconds
        boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);
        if (success) {
            try {
                return worker.invokeAfterLockAquire();
            } finally {
                lock.unlock();
            }
        }
        throw new UnableToAquireLockException();
    }
}
