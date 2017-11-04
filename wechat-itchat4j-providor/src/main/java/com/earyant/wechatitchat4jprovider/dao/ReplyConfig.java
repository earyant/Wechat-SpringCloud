package com.earyant.wechatitchat4jprovider.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by earyant on 2017 : 09 : 2017/9/7 0007 : 10:58 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao
 */
@Entity
@Data
public class ReplyConfig {

    @Id
    String wechatId;
    //1是文本回复，2是语音回复，4是图片回复，8撤回回复
    int replyType;
    Date createDate = new Date();
}
