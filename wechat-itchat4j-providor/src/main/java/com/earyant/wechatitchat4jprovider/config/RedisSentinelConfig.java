//package com.earyant.wechatitchat4jprovider.config;
//
//import com.earyant.wechatitchat4jprovider.EcejRedisProperties;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.util.StringUtils;
//import redis.clients.jedis.JedisPoolConfig;
//
//import javax.annotation.Resource;
//import java.util.HashSet;
//
///**
// * Created by earyant on 2017 : 08 : 2017/8/8 : 18:05 : .
// * ln_spring_boot  com.earyant.wechatitchat4jprovider.config
// */
//@Configuration
//@EnableConfigurationProperties(EcejRedisProperties.class)
//@ConditionalOnProperty(name = "spring.redis")
//public class RedisSentinelConfig {
//    private Logger LOG = LoggerFactory.getLogger(RedisSentinelConfig.class);
//
//    @Resource
//    private EcejRedisProperties redisProperties;
//
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
//        jedisPoolConfig.setMaxTotal(redisProperties.getMaxTotal());
//        jedisPoolConfig.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
//        return jedisPoolConfig;
//
//    }
//
//    public RedisSentinelConfiguration jedisSentinelConfig() {
//        String[] hosts = redisProperties.getHostName().split(",");
//        HashSet<String> sentinelHostAndPorts = new HashSet<>();
//        for (String hn : hosts) {
//            sentinelHostAndPorts.add(hn);
//        }
//        return new RedisSentinelConfiguration(redisProperties.getMastername(), sentinelHostAndPorts);
//
//    }
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisSentinelConfig(),
//                jedisPoolConfig());
//        if (!StringUtils.isEmpty(redisProperties.getPassword()))
//            jedisConnectionFactory.setPassword(redisProperties.getPassword());
//        return jedisConnectionFactory;
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate() {
//
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
//        LOG.info("create redisTemplate success");
//        return redisTemplate;
//    }
//
//}
