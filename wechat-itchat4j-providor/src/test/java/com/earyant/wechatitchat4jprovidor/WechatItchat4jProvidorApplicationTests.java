package com.earyant.wechatitchat4jprovidor;

import com.earyant.wechatitchat4jprovider.WechatItchat4jProvidorApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WechatItchat4jProvidorApplication.class)
public class WechatItchat4jProvidorApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
        stringRedisTemplate.opsForValue().set("111", "1");
        System.out.println("11111" + stringRedisTemplate.opsForValue().get("111"));
    }

}
