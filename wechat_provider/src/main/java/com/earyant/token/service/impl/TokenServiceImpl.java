package com.earyant.token.service.impl;

import com.earyant.commentdatabase.redis.service.RedisServiceImpl;
import com.earyant.token.repostity.Token;
import com.earyant.token.repostity.TokenRepsitory;
import com.earyant.token.service.TokenService;
import com.earyant.token.service.WechatConfigService;
import com.earyant.wechat.util.HttpUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: WeChatTaskImpl
 *
 * @author dapengniao
 * @Description: 微信两小时定时任务体
 * @date 2016年3月10日 下午1:42:29
 */
@Service
public class TokenServiceImpl implements TokenService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TokenRepsitory tokenRepsitory;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RedisServiceImpl redisService;
    @Autowired
    WechatConfigService wechatConfigService;

    /**
     * @param @throws Exception
     * @Description: 任务执行体
     * @author dapengniao
     * @date 2016年3月10日 下午2:04:37
     */

    @Scheduled(fixedDelay = 7000000)
    public void getToken_getTicket() throws Exception {
        String tokenUrl = wechatConfigService.getTokenUrl();
        List<Token> tokens = tokenRepsitory.findAll();
        tokens.forEach((Token o) -> {
            logger.debug(o.toString());
            Map<String, String> params = new HashMap<String, String>();
            //获取token执行体
            params.put("grant_type", "client_credential");
            params.put("appid", o.getAppid());
            params.put("secret", o.getSecret());
            String jstoken = null;
            try {
                System.out.println(tokenUrl);
                jstoken = HttpUtils.sendGet(tokenUrl,params);
            } catch (Exception e) {
                logger.info("获取token失败，原因是：" + e.toString());
            }
            logger.info(o.getAppid() + "    id   token :::" + jstoken);
            String access_token = JSONObject.fromObject(jstoken).getString(
                    "access_token"); // 获取到token并赋值保存
            redisService.put("access_token_" + o.getAppid(), access_token, 7200);
            //获取jsticket的执行体
//            params.clear();
//            params.put("access_token", access_token);
//            params.put("type", "jsapi");
//            String jsticket = null;
//            try {
//                jsticket = HttpUtils.sendGet(
//
//                        restTemplate.getForObject("http://config-client/ticketUrl", String.class), params);
//            } catch (Exception e) {
//                logger.info("获取ticket失败，失败原因是：" + e.toString());
//            }
//            System.out.println("jsticket:: "+jsticket);
//            String jsapi_ticket = JSONObject.fromObject(jsticket).getString(
//                    "ticket");
//            redisService.put("jsapi_ticket_" + o.getAppid(), jsapi_ticket, 7200);
//            String sql = "";
        });
    }
}
