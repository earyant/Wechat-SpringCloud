/**
  * Copyright 2017 aTool.org 
  */
package com.earyant.wechatitchat4jprovider.dao.wxsync;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2017-08-13 20:23:58
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
public class Profile {

    @JsonProperty("BitFlag")
    private int bitflag;
    @JsonProperty("UserName")
    private Username username;
    @JsonProperty("NickName")
    private Nickname nickname;
    @JsonProperty("BindUin")
    private int binduin;
    @JsonProperty("BindEmail")
    private Bindemail bindemail;
    @JsonProperty("BindMobile")
    private Bindmobile bindmobile;
    @JsonProperty("Status")
    private int status;
    @JsonProperty("Sex")
    private int sex;
    @JsonProperty("PersonalCard")
    private int personalcard;
    @JsonProperty("Alias")
    private String alias;
    @JsonProperty("HeadImgUpdateFlag")
    private int headimgupdateflag;
    @JsonProperty("HeadImgUrl")
    private String headimgurl;
    @JsonProperty("Signature")
    private String signature;
    public void setBitflag(int bitflag) {
         this.bitflag = bitflag;
     }
     public int getBitflag() {
         return bitflag;
     }

    public void setUsername(Username username) {
         this.username = username;
     }
     public Username getUsername() {
         return username;
     }

    public void setNickname(Nickname nickname) {
         this.nickname = nickname;
     }
     public Nickname getNickname() {
         return nickname;
     }

    public void setBinduin(int binduin) {
         this.binduin = binduin;
     }
     public int getBinduin() {
         return binduin;
     }

    public void setBindemail(Bindemail bindemail) {
         this.bindemail = bindemail;
     }
     public Bindemail getBindemail() {
         return bindemail;
     }

    public void setBindmobile(Bindmobile bindmobile) {
         this.bindmobile = bindmobile;
     }
     public Bindmobile getBindmobile() {
         return bindmobile;
     }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setSex(int sex) {
         this.sex = sex;
     }
     public int getSex() {
         return sex;
     }

    public void setPersonalcard(int personalcard) {
         this.personalcard = personalcard;
     }
     public int getPersonalcard() {
         return personalcard;
     }

    public void setAlias(String alias) {
         this.alias = alias;
     }
     public String getAlias() {
         return alias;
     }

    public void setHeadimgupdateflag(int headimgupdateflag) {
         this.headimgupdateflag = headimgupdateflag;
     }
     public int getHeadimgupdateflag() {
         return headimgupdateflag;
     }

    public void setHeadimgurl(String headimgurl) {
         this.headimgurl = headimgurl;
     }
     public String getHeadimgurl() {
         return headimgurl;
     }

    public void setSignature(String signature) {
         this.signature = signature;
     }
     public String getSignature() {
         return signature;
     }

}