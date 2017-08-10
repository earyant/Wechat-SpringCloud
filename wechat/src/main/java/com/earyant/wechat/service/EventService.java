package com.earyant.wechat.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by earyant on 2016/11/13.
 */
public interface EventService {
      String processEvent(@RequestParam Map<String, String> map) throws Exception;
}
