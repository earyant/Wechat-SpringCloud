package com.earyant.wechat.service;

import java.util.Map;

/**
 * Created by earyant on 2016/11/13.
 */
public interface MsgService {
      String processMessage(Map<String, String> map) throws Exception;
}
