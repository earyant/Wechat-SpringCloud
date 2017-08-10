package com.earyant.wechatitchat4jprovider.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 17:17 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.service
 */
public interface ChatService {
    String chat(Map<String, String> map, String path);

    String login(HashMap<String, String> map);
}
