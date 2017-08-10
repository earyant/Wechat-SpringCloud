package com.earyant.wechat.dao;

import lombok.Data;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 11:23 : .
 * ln_spring_boot  com.earyant.wechat.dao
 */
@Data
public class WechatMsg {
//    {Content=？, CreateTime=1501989787, ToUserName=gh_6f6020aa1960, FromUserName=o80Q1uBfORQkIBKbVwGH8cnEhOtE, MsgType=text, MsgId=6450997014507206540}
    private String  Content;
    private String  CreateTime;
    private String  ToUserName;
    private String  FromUserName;
    private String  MsgType;
    private String  MsgId;
}
