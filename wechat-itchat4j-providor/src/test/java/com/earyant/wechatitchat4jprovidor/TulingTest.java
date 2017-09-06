package com.earyant.wechatitchat4jprovidor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.MyHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by earyant on 2017 : 09 : 2017/9/5 0005 : 14:28 : .
 * WechatCloud  com.earyant.wechatitchat4jprovidor
 */
public class TulingTest {
    static  String url = "http://www.tuling123.com/openapi/api";
    static String apiKey = "bfe2554daee073aa2dc7673ea8e7541d";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("key", apiKey);
        paramMap.put("info", "123456");
        paramMap.put("userid", "123456");
        String paramStr = JSON.toJSONString(paramMap);
        MyHttpClient myHttpClient = MyHttpClient.getInstance();
        HttpEntity entity = myHttpClient.doPost(url, paramStr);
        String  result  = restTemplate.postForObject(url,paramMap,String.class);
//        String  result = null;
        try {
            result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        JSONObject obj = JSON.parseObject(result);
        if (obj.getString("code").equals("100000")) {
            result = obj.getString("text");
        } else {
            result = "处理有误";
        }
        System.out.println(result);
    }
}
