package com.earyant.wechatitchat4jprovider.dao.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by earyant on 2017 : 08 : 2017/8/15 : 14:12 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.bean
 */
@NoArgsConstructor
@Data
@Entity
public class ListBean {
    /**
     * Key : 1
     * Val : 686075797
     */

    @Column(name = "keyss")
    private int Key;

    private int Val;


    String syncKeyBeanId;
    @Id
    String id;
}
