package com.earyant.wechat.service.impl;

import com.earyant.wechat.service.EventService;
import com.earyant.wechat.service.MsgService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ClassName: MsgDispatcherImpl
 *
 * @author dapengniao
 * @Description: 消息业务处理分发器
 * @date 2016年3月7日 下午4:04:21
 */
@Service
public class MsgServiceImpl implements MsgService {
    @Autowired
    RestTemplate restTemplate;
    @Resource
    EventService eventDisPatcherService;
    org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @HystrixCommand(fallbackMethod = "processMessageError")
    @Override
    public String processMessage(Map<String, String> map) throws Exception {
        return restTemplate.postForObject("http://WECHAT-PROVIDER/wechat/processMessage",map, String.class,map);
    }



    public String processMessageError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
