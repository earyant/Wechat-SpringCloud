package com.earyant.wechatitchat4jprovider.config;

import com.earyant.wechatitchat4jprovider.dao.User;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 21:32 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.config
 */
@Configuration
@EnableCaching
public class BeanConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }

}
