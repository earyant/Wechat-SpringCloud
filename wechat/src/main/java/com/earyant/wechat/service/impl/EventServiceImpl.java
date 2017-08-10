package com.earyant.wechat.service.impl;

import com.earyant.wechat.service.EventService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


/**
 * ClassName: EventServiceImpl
 *
 * @author dapengniao
 * @Description: 事件消息业务分发器
 * @date 2016年3月7日 下午4:04:41
 */
@Service
public class EventServiceImpl implements EventService {
    private static Logger logger = Logger.getLogger(EventServiceImpl.class);
    @Autowired
    RestTemplate restTemplate;


    @Override
    public String processEvent(Map<String, String> map) throws Exception {
        return restTemplate.postForObject("http://WECHAT-PROVIDER/wechat/processEvent",map, String.class,map);
    }

//    @Override
//    public String getContent(NewsMessage newmsg, String type) throws Exception {
//        return "No Data";
//    }
//
//    @Override
//    public String getContentByDate(NewsMessage newmsg, String date) throws Exception {
//        return "No Data";
//    }
//
//    @Override
//    public String getOneDayGank(NewsMessage newmsg) throws Exception {
//        return "No Data";
//    }
}
