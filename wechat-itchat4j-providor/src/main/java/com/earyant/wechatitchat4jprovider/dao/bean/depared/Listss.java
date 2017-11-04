///**
// * Copyright 2017 aTool.org
// */
//package com.earyant.wechatitchat4jprovider.dao.bean.depared;
//
//import lombok.Data;
//import org.codehaus.jackson.annotate.JsonProperty;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
///**
// * Auto-generated: 2017-08-13 12:9:23
// *
// * @author aTool.org (i@aTool.org)
// * @website http://www.atool.org/json2javabean.php
// */
//@Entity
//@Data
//public class Listss {
//    @Id
//    @GeneratedValue
//    Long id;
//
//    @JsonProperty("Key")
//    private Integer keyss;
//    @JsonProperty("Val")
//    private Integer val;
//
//    @ManyToOne
//    Synckey synckey;
//
//    public void setKey(int key) {
//        this.keyss = key;
//    }
//
//    public int getKey() {
//        return keyss;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//
//    public int getVal() {
//        return val;
//    }
//
//}