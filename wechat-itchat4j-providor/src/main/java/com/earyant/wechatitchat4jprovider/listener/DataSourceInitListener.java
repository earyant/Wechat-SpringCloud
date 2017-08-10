package com.earyant.wechatitchat4jprovider.listener;

import com.earyant.wechatitchat4jprovider.global.GlobalThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by earyant on 2017 : 08 : 2017/8/8 : 16:40 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.listener
 */
public class DataSourceInitListener implements ApplicationListener<ContextRefreshedEvent> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(DataSourceInitListener.class);

    @SuppressWarnings("unchecked")
    @Override
    public void onApplicationEvent(ContextRefreshedEvent ev) {
        System.out.println("start complete!");
        //防止重复执行。
    }

}