package com.earyant.wechat.service;

import com.earyant.wechat.message.resp.NewsMessage;

import java.util.Map;

/**
 * Created by earyant on 2016/11/13.
 */

public interface EventDisPatcherService {
    public String processEvent(Map<String, String> map) throws Exception;

    String getContent(NewsMessage newmsg, String iOS) throws Exception;

    public String getOneDayGank(NewsMessage newmsg) throws Exception;

    String getContentByDate(NewsMessage newmsg, String date) throws Exception;
}
