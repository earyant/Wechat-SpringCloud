package com.earyant;

public class CommonConstants {
    public static final String TABLE_SCHEMA = "CTSIG";
    /**
     * 项目信息
     */
    public static final String APP_NAME = "wechat";
    public static final String PREFIX = "/spring-mybatis/";
    /****系统参数*******/
    public static final String SEND_EMAIL_PROP_PATH = "sysProps.properties";

    public static final String RN = "\r\n"; //	回车换行

    //邮件类型  1发送类型 2接收类型
    public static final String MAIL_TYPE_SEND = "1";
    //项目中默认状态 0是， 1否
    public static final String STATUS_OK = "0";
    public static final String STATUS_NO = "1";
    public static final String STATUS_QT = "2";
    //系统默认开始路径  spring初始化
    public static String SYSTEMPATH = "";
    public static final String MAIL_PATH = "data/mail/send";//邮件生成Excel路径
}
