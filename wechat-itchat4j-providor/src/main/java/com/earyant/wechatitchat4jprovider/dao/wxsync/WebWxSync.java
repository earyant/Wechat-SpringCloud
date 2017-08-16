/**
  * Copyright 2017 aTool.org 
  */
package com.earyant.wechatitchat4jprovider.dao.wxsync;

import com.earyant.wechatitchat4jprovider.dao.bean.ContactListBean;
import com.earyant.wechatitchat4jprovider.dao.bean.SyncKeyBean;
import com.earyant.wechatitchat4jprovider.itchat4j.beans.BaseMsg;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
/**
 * Auto-generated: 2017-08-13 20:23:58
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
public class WebWxSync {

    @JsonProperty("BaseResponse")
    private Baseresponse baseresponse;
    @JsonProperty("AddMsgCount")
    private int addmsgcount;
    @JsonProperty("AddMsgList")
    private List<BaseMsg> addmsglist;
    @JsonProperty("ModContactCount")
    private int modcontactcount;
    @JsonProperty("ModContactList")

    private List<ContactListBean> modcontactlist;
    @JsonProperty("DelContactCount")
    private int delcontactcount;
    @JsonProperty("DelContactList")
    private List<String> delcontactlist;
    @JsonProperty("ModChatRoomMemberCount")
    private int modchatroommembercount;
    @JsonProperty("ModChatRoomMemberList")
    private List<String> modchatroommemberlist;
    @JsonProperty("Profile")
    private Profile profile;
    @JsonProperty("ContinueFlag")
    private int continueflag;
    @JsonProperty("SyncKey")
    private SyncKeyBean synckey;
    @JsonProperty("SKey")
    private String skey;
    @JsonProperty("SyncCheckKey")
    private Synccheckkey synccheckkey;
    public void setBaseresponse(Baseresponse baseresponse) {
         this.baseresponse = baseresponse;
     }
     public Baseresponse getBaseresponse() {
         return baseresponse;
     }

    public void setAddmsgcount(int addmsgcount) {
         this.addmsgcount = addmsgcount;
     }
     public int getAddmsgcount() {
         return addmsgcount;
     }

    public void setAddmsglist(List<BaseMsg> addmsglist) {
         this.addmsglist = addmsglist;
     }
     public List<BaseMsg> getAddmsglist() {
         return addmsglist;
     }

    public void setModcontactcount(int modcontactcount) {
         this.modcontactcount = modcontactcount;
     }
     public int getModcontactcount() {
         return modcontactcount;
     }

    public void setModcontactlist(List<ContactListBean> modcontactlist) {
         this.modcontactlist = modcontactlist;
     }
     public List<ContactListBean> getModcontactlist() {
         return modcontactlist;
     }

    public void setDelcontactcount(int delcontactcount) {
         this.delcontactcount = delcontactcount;
     }
     public int getDelcontactcount() {
         return delcontactcount;
     }

    public void setDelcontactlist(List<String> delcontactlist) {
         this.delcontactlist = delcontactlist;
     }
     public List<String> getDelcontactlist() {
         return delcontactlist;
     }

    public void setModchatroommembercount(int modchatroommembercount) {
         this.modchatroommembercount = modchatroommembercount;
     }
     public int getModchatroommembercount() {
         return modchatroommembercount;
     }

    public void setModchatroommemberlist(List<String> modchatroommemberlist) {
         this.modchatroommemberlist = modchatroommemberlist;
     }
     public List<String> getModchatroommemberlist() {
         return modchatroommemberlist;
     }

    public void setProfile(Profile profile) {
         this.profile = profile;
     }
     public Profile getProfile() {
         return profile;
     }

    public void setContinueflag(int continueflag) {
         this.continueflag = continueflag;
     }
     public int getContinueflag() {
         return continueflag;
     }

    public SyncKeyBean getSynckey() {
        return synckey;
    }

    public void setSynckey(SyncKeyBean synckey) {
        this.synckey = synckey;
    }

    public void setSkey(String skey) {
         this.skey = skey;
     }
     public String getSkey() {
         return skey;
     }

    public void setSynccheckkey(Synccheckkey synccheckkey) {
         this.synccheckkey = synccheckkey;
     }
     public Synccheckkey getSynccheckkey() {
         return synccheckkey;
     }

}