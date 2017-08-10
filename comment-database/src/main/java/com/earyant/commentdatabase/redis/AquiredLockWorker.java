package com.earyant.commentdatabase.redis;

/**
 * Created by earyant on 2017 : 07 : 2017/7/31 : 11:12 : .
 * ln_spring_boot  com.earyant.commentdatabase.mongodb
 */
public interface AquiredLockWorker<T> {
    T invokeAfterLockAquire() throws Exception;
}
