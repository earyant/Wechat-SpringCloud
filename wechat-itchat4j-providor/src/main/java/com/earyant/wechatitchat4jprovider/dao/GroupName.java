package com.earyant.wechatitchat4jprovider.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 21:59 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.dao
 */
@Entity
@Data
public class GroupName {

    @Id
    String id;
    String names;
    String ids;
    String GroupNickName;

}
