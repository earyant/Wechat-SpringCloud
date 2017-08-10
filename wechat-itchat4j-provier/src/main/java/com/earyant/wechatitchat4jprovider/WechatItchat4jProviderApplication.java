package com.earyant.wechatitchat4jprovider;

import com.earyant.wechatitchat4jprovider.listener.DataSourceInitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
public class WechatItchat4jProviderApplication {

    public static void main(String[] args) {
//		SpringApplication.run(WechatItchat4jProviderApplication.class, args);
        SpringApplication springApplication = new SpringApplication(WechatItchat4jProviderApplication.class);
        springApplication.addListeners(new
                DataSourceInitListener());

        springApplication.run(args);
    }
}
