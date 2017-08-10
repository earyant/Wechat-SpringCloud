package com.earyant.wechatitchat4jprovider;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by earyant on 2017 : 08 : 2017/8/8 : 18:06 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider
 */
@ConfigurationProperties(prefix = "ecej.redis")
public class EcejRedisProperties {

    /**
     * Max number of "idle" connections in the pool. Use a negative value to
     * indicate an unlimited number of idle connections.
     */
    private int maxIdle = 10;

    /**
     * 最大连接数
     */
    private int maxTotal = 500;

    private int maxWaitMillis = 3000;

    private String hostName = "localhost";

    private String password;

    /**
     * Maximum number of redirects to follow when executing commands across the
     * cluster.
     */
    private int maxRedirects = 10;

    private String mastername;

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxRedirects() {
        return maxRedirects;
    }

    public void setMaxRedirects(int maxRedirects) {
        this.maxRedirects = maxRedirects;
    }

    public String getMastername() {
        return mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername;
    }

}