package com.earyant.wechatitchat4jprovider.dao;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 21:59 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.dao
 */
@Entity
@Data
public class GroupName {

    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    User user;
    @Column
    String name;

    public GroupName(String name){
        this.name = name;
    }
}
