package com.earyant.commentdatabase.redis.exception;

/**
 * Created by earyant on 2017 : 07 : 2017/7/31 : 11:13 : .
 * ln_spring_boot  com.earyant.commentdatabase.redis.exception
 */



public class UnableToAquireLockException extends RuntimeException {

    public UnableToAquireLockException() {
    }

    public UnableToAquireLockException(String message) {
        super(message);
    }

    public UnableToAquireLockException(String message, Throwable cause) {
        super(message, cause);
    }
}