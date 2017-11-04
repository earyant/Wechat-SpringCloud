package com.earyant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by earyant on 2017 : 09 : 2017/9/7 0007 : 10:27 : .
 * WechatCloud  com.earyant
 */
public class PatternTest {
    public static void main(String[] args) {
        String content = "开启聊天备份";
        Pattern p = Pattern.compile("开启((聊天)*|(语音)*|(图片)*)备份");
        Matcher m = p.matcher(content);
        if (m.find()) {
            System.out.println(m.group());
        }
    }
}
