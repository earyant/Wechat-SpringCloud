package com.earyant.wechat.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 11:23 : .
 * ln_spring_boot  com.earyant.wechat.dao
 */
@Data
public class WechatMsg {
//    {Content=？, CreateTime=1501989787, ToUserName=gh_6f6020aa1960, FromUserName=o80Q1uBfORQkIBKbVwGH8cnEhOtE, MsgType=text, MsgId=6450997014507206540}
    @JsonProperty("Content")
    private String  Content;
    @JsonProperty("CreateTime")
    private String  CreateTime;
    @JsonProperty("ToUserName")
    private String  ToUserName;
    @JsonProperty("FromUserName")
    private String  FromUserName;
    @JsonProperty("MsgType")
    private String  MsgType;
    @JsonProperty("MsgId")
    private String  MsgId;
}
