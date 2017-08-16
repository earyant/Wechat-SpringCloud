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
//public class Mparticlelist {
//
//    @Id
//    @GeneratedValue
//    Long id;
//
//    @JsonProperty("Title")
//    private String title;
//    @JsonProperty("Digest")
//    private String digest;
//    @JsonProperty("Cover")
//    private String cover;
//    @JsonProperty("Url")
//    private String url;
//    @ManyToOne
//    Mpsubscribemsglist mpsubscribemsglist;
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setDigest(String digest) {
//        this.digest = digest;
//    }
//
//    public String getDigest() {
//        return digest;
//    }
//
//    public void setCover(String cover) {
//        this.cover = cover;
//    }
//
//    public String getCover() {
//        return cover;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//}