package com.earyant.wechat.common;

import com.earyant.token.service.WechatConfigService;
import com.earyant.wechat.util.HttpUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * ClassName: GetUseInfo
 *
 * @author dapengniao
 * @Description: 获取微信用户信息
 * @date 2016年3月18日 下午2:00:52
 */
@Component
public class GetUseInfo {
    @Autowired
    WechatConfigService wechatConfigService;
//    @Autowired
//    RedisServiceImpl redisService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * @param @param  openid
     * @param @return
     * @param @throws Exception
     * @param appid
     * @Description: 通过openid获取用户微信信息
     * @author dapengniao
     * @date 2016年3月18日 下午2:01:30
     */
    public HashMap<String, String> Openid_userinfo(String openid, String appid)
            throws Exception {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("access_token", stringRedisTemplate.opsForValue().get("access_token_" + appid));  //定时器中获取到的token
//		System.out.println(GlobalConstants.getInterfaceUrl("access_token"));
        params.put("openid", openid);  //需要获取的用户的openid
        params.put("lang", "zh_CN");
        String subscribers = HttpUtils.sendGet(wechatConfigService.OpenidUserinfoUrl(), params);
//		System.out.println(subscribers);
        params.clear();
        //这里返回参数只取了昵称、头像、和性别
        params.put("nickname",
                JSONObject.fromObject(subscribers).getString("nickname")); //昵称
        params.put("headimgurl",
                JSONObject.fromObject(subscribers).getString("headimgurl"));  //图像
        params.put("sex", JSONObject.fromObject(subscribers).getString("sex"));  //性别
        return params;
    }

}
