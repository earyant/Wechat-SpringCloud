package com.earyant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RefreshScope注解必不可少，否则即便是调用了/refresh，配置也不会刷新
 */
@RestController
@SpringBootApplication
@EnableEurekaClient
@RefreshScope
public class WechatConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatConfigApplication.class, args);
    }

    @Value("${foo}")
    String foo;

    @GetMapping(value = "/hi")
    public String hi() {
        return foo;
    }
//
    @Value("${tokenUrl}")
    String tokenUrl;
    @GetMapping("/getTokenUrl")
    public String getTokenUrl() {
        return tokenUrl;
    }

    @Value("${mediaUrl}")
    String mediaUrl;
    @GetMapping("/mediaUrl")
    public String mediaUrl() {
        return tokenUrl;
    }


    @Value("${OpenidUserinfoUrl}")
    String OpenidUserinfoUrl;
    @GetMapping("/OpenidUserinfoUrl")
    public String OpenidUserinfoUrl() {
        return tokenUrl;
    }


    @Value("${ticketUrl}")
    String ticketUrl;

    @GetMapping("/ticketUrl")
    public String ticketUrl() {
        return tokenUrl;
    }


    @Value("${gank_history}")
    String gank_history;
    @GetMapping("/gank_history")
    public String gank_history() {
        return tokenUrl;
    }



    @Value("${upload_pic}")
    String upload_pic;
    @GetMapping("/upload_pic")
    public String upload_pic() {
        return tokenUrl;
    }



    @Value("${get_user_info}")
    String get_user_info;

    @GetMapping("/get_user_info")
    public String get_user_info() {
        return tokenUrl;
    }


    @Value("${getOneDayContent}")
    String getOneDayContent;

    @GetMapping("/getOneDayContent")
    public String getOneDayContent() {
        return tokenUrl;
    }
    @Value("${allContent}")
    String allContent;

    @GetMapping("/allContent")
    public String allContent() {
        return tokenUrl;
    }

}
