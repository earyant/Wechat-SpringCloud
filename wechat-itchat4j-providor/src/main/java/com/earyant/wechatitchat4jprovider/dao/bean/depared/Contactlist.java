///**
// * Copyright 2017 aTool.org
// */
//package com.earyant.wechatitchat4jprovider.dao.bean.depared;
//
//import com.earyant.wechatitchat4jprovider.dao.User;
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
//
//@Entity
//@Data
//public class Contactlist {
//
//    @Id
//    @GeneratedValue
//    Long id;
//    @JsonProperty("Uin")
//    private int uin;
//    @JsonProperty("UserName")
//    private String username;
//    @JsonProperty("NickName")
//    private String nickname;
//    @JsonProperty("HeadImgUrl")
//    private String headimgurl;
//    @JsonProperty("ContactFlag")
//    private int contactflag;
//    @JsonProperty("MemberCount")
//    private int membercount;
//    @JsonProperty("MemberList")
//
//    private String memberlist;
//    @JsonProperty("RemarkName")
//    private String remarkname;
//    @JsonProperty("HideInputBarFlag")
//    private int hideinputbarflag;
//    @JsonProperty("Sex")
//    private int sex;
//    @JsonProperty("Signature")
//    private String signature;
//    @JsonProperty("VerifyFlag")
//    private int verifyflag;
//    @JsonProperty("OwnerUin")
//    private int owneruin;
//    @JsonProperty("PYInitial")
//    private String pyinitial;
//    @JsonProperty("PYQuanPin")
//    private String pyquanpin;
//    @JsonProperty("RemarkPYInitial")
//    private String remarkpyinitial;
//    @JsonProperty("RemarkPYQuanPin")
//    private String remarkpyquanpin;
//    @JsonProperty("StarFriend")
//    private int starfriend;
//    @JsonProperty("AppAccountFlag")
//    private int appaccountflag;
//    @JsonProperty("Statues")
//    private int statues;
//    @JsonProperty("AttrStatus")
//    private int attrstatus;
//    @JsonProperty("Province")
//    private String province;
//    @JsonProperty("City")
//    private String city;
//    @JsonProperty("Alias")
//    private String alias;
//    @JsonProperty("SnsFlag")
//    private int snsflag;
//    @JsonProperty("UniFriend")
//    private int unifriend;
//    @JsonProperty("DisplayName")
//    private String displayname;
//    @JsonProperty("ChatRoomId")
//    private int chatroomid;
//    @JsonProperty("KeyWord")
//    private String keyword;
//    @JsonProperty("EncryChatRoomId")
//    private String encrychatroomid;
//    @JsonProperty("IsOwner")
//
//    @ManyToOne
//    User userInfo;
//
//    private int isowner;
//
//    public void setUin(int uin) {
//        this.uin = uin;
//    }
//
//    public int getUin() {
//        return uin;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getUsername() {
//        return username;
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
//    public void setHeadimgurl(String headimgurl) {
//        this.headimgurl = headimgurl;
//    }
//
//    public String getHeadimgurl() {
//        return headimgurl;
//    }
//
//    public void setContactflag(int contactflag) {
//        this.contactflag = contactflag;
//    }
//
//    public int getContactflag() {
//        return contactflag;
//    }
//
//    public void setMembercount(int membercount) {
//        this.membercount = membercount;
//    }
//
//    public int getMembercount() {
//        return membercount;
//    }
//
//    public void setMemberlist(String memberlist) {
//        this.memberlist = memberlist;
//    }
//
//    public String getMemberlist() {
//        return memberlist;
//    }
//
//    public void setRemarkname(String remarkname) {
//        this.remarkname = remarkname;
//    }
//
//    public String getRemarkname() {
//        return remarkname;
//    }
//
//    public void setHideinputbarflag(int hideinputbarflag) {
//        this.hideinputbarflag = hideinputbarflag;
//    }
//
//    public int getHideinputbarflag() {
//        return hideinputbarflag;
//    }
//
//    public void setSex(int sex) {
//        this.sex = sex;
//    }
//
//    public int getSex() {
//        return sex;
//    }
//
//    public void setSignature(String signature) {
//        this.signature = signature;
//    }
//
//    public String getSignature() {
//        return signature;
//    }
//
//    public void setVerifyflag(int verifyflag) {
//        this.verifyflag = verifyflag;
//    }
//
//    public int getVerifyflag() {
//        return verifyflag;
//    }
//
//    public void setOwneruin(int owneruin) {
//        this.owneruin = owneruin;
//    }
//
//    public int getOwneruin() {
//        return owneruin;
//    }
//
//    public void setPyinitial(String pyinitial) {
//        this.pyinitial = pyinitial;
//    }
//
//    public String getPyinitial() {
//        return pyinitial;
//    }
//
//    public void setPyquanpin(String pyquanpin) {
//        this.pyquanpin = pyquanpin;
//    }
//
//    public String getPyquanpin() {
//        return pyquanpin;
//    }
//
//    public void setRemarkpyinitial(String remarkpyinitial) {
//        this.remarkpyinitial = remarkpyinitial;
//    }
//
//    public String getRemarkpyinitial() {
//        return remarkpyinitial;
//    }
//
//    public void setRemarkpyquanpin(String remarkpyquanpin) {
//        this.remarkpyquanpin = remarkpyquanpin;
//    }
//
//    public String getRemarkpyquanpin() {
//        return remarkpyquanpin;
//    }
//
//    public void setStarfriend(int starfriend) {
//        this.starfriend = starfriend;
//    }
//
//    public int getStarfriend() {
//        return starfriend;
//    }
//
//    public void setAppaccountflag(int appaccountflag) {
//        this.appaccountflag = appaccountflag;
//    }
//
//    public int getAppaccountflag() {
//        return appaccountflag;
//    }
//
//    public void setStatues(int statues) {
//        this.statues = statues;
//    }
//
//    public int getStatues() {
//        return statues;
//    }
//
//    public void setAttrstatus(int attrstatus) {
//        this.attrstatus = attrstatus;
//    }
//
//    public int getAttrstatus() {
//        return attrstatus;
//    }
//
//    public void setProvince(String province) {
//        this.province = province;
//    }
//
//    public String getProvince() {
//        return province;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setAlias(String alias) {
//        this.alias = alias;
//    }
//
//    public String getAlias() {
//        return alias;
//    }
//
//    public void setSnsflag(int snsflag) {
//        this.snsflag = snsflag;
//    }
//
//    public int getSnsflag() {
//        return snsflag;
//    }
//
//    public void setUnifriend(int unifriend) {
//        this.unifriend = unifriend;
//    }
//
//    public int getUnifriend() {
//        return unifriend;
//    }
//
//    public void setDisplayname(String displayname) {
//        this.displayname = displayname;
//    }
//
//    public String getDisplayname() {
//        return displayname;
//    }
//
//    public void setChatroomid(int chatroomid) {
//        this.chatroomid = chatroomid;
//    }
//
//    public int getChatroomid() {
//        return chatroomid;
//    }
//
//    public void setKeyword(String keyword) {
//        this.keyword = keyword;
//    }
//
//    public String getKeyword() {
//        return keyword;
//    }
//
//    public void setEncrychatroomid(String encrychatroomid) {
//        this.encrychatroomid = encrychatroomid;
//    }
//
//    public String getEncrychatroomid() {
//        return encrychatroomid;
//    }
//
//    public void setIsowner(int isowner) {
//        this.isowner = isowner;
//    }
//
//    public int getIsowner() {
//        return isowner;
//    }
//
//}