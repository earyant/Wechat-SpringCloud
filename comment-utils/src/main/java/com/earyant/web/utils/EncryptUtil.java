package com.earyant.web.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * MD5加密    用户注册 用户登录
 **/
public class EncryptUtil {
    public static String md5(String str) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bts = md.digest(str.getBytes());
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(bts);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("" + md5("APP_KEY_ANDROID:cnview-beijing-2007"));
        System.out.println("" + md5("APP_KEY_IOS:cnview-beijing-2007"));
        System.out.println("" + md5("APP_KEY_H5:cnview-beijing-2007"));
        System.out.println("" + md5("APP_KEY_WECHAT:cnview-beijing-2007"));
    }
}
