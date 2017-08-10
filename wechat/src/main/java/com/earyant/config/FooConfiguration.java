//package com.earyant.config;
//
//import feign.Contract;
//import feign.auth.BasicAuthRequestInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Created by earyant on 2017 : 07 : 2017/7/21 : 14:26 : .
// * ln_spring_boot  com.earyant.config
// */
//@Configuration
//public class FooConfiguration {
//    @Bean
//    public Contract feignContractg() {
//        return new feign.Contract.Default();
//    }
//
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user", "password");
//    }
//}