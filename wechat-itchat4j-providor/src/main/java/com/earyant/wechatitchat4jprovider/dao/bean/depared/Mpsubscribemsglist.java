///**
// * Copyright 2017 aTool.org
// */
//package com.earyant.wechatitchat4jprovider.dao.bean.depared;
//
//import com.earyant.wechatitchat4jprovider.dao.User;
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
//@Entity
//@Data
//public class Mpsubscribemsglist {
//
//    @Id
//    @GeneratedValue
//    Long id;
//    @JsonProperty("UserName")
//    private String username;
//    @JsonProperty("MPArticleCount")
//    private int mparticlecount;
//    @JsonProperty("MPArticleList")
//    @OneToMany
//    @JoinTable(name = "publicmsg_publicArticle", joinColumns = {
//            @JoinColumn(name = "publicmsg_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
//            @JoinColumn(name = "publicArticle_ID", referencedColumnName = "ID")})
//    private List<Mparticlelist> mparticlelist;
//    @JsonProperty("Time")
//    private int time;
//    @JsonProperty("NickName")
//    private String nickname;
//    @ManyToOne
//    User userInfo;
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setMparticlecount(int mparticlecount) {
//        this.mparticlecount = mparticlecount;
//    }
//
//    public int getMparticlecount() {
//        return mparticlecount;
//    }
//
//    public void setMparticlelist(List<Mparticlelist> mparticlelist) {
//        this.mparticlelist = mparticlelist;
//    }
//
//    public List<Mparticlelist> getMparticlelist() {
//        return mparticlelist;
//    }
//
//    public void setTime(int time) {
//        this.time = time;
//    }
//
//    public int getTime() {
//        return time;
//    }
//
//    public void setNickname(String nickname) {
//        this.nickname = nickname;
//    }
//
//    public String getNickname() {
//        return nickname;
//    }
//
//}