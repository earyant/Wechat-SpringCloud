///**
// * Copyright 2017 aTool.org
// */
//package com.earyant.wechatitchat4jprovider.dao.bean.depared;
//
//import lombok.Data;
//import org.codehaus.jackson.annotate.JsonProperty;
//
//import javax.persistence.*;
//import java.util.List;
//
///**
// * Auto-generated: 2017-08-13 12:9:23
// *
// * @author aTool.org (i@aTool.org)
// * @website http://www.atool.org/json2javabean.php
// */
//
//@Entity
//@Data
//public class Synckey {
//    @Id
//    @GeneratedValue
//    Long id;
//
//    @JsonProperty("Count")
//    private int count;
//    @JsonProperty("List")
//    @OneToMany
//    @JoinTable(name = "SyncKey_List", joinColumns = {
//            @JoinColumn(name = "SyncKey_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
//            @JoinColumn(name = "List_ID", referencedColumnName = "ID")})
//    private List<Listss> list;
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setList(List<Listss> list) {
//        this.list = list;
//    }
//
//    public List<Listss> getList() {
//        return list;
//    }
//
//}