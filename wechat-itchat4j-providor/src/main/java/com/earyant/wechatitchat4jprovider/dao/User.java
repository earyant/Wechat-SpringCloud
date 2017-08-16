/**
 * Copyright 2017 aTool.org
 */
package com.earyant.wechatitchat4jprovider.dao;

import com.earyant.wechatitchat4jprovider.dao.bean.ContactListBean;
import com.earyant.wechatitchat4jprovider.dao.bean.MPSubscribeMsgListBean;
import com.earyant.wechatitchat4jprovider.dao.bean.SyncKeyBean;
import com.earyant.wechatitchat4jprovider.dao.bean.WechatinitBean;
import com.earyant.wechatitchat4jprovider.itchat4j.beans.BaseMsg;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2017-08-13 12:9:23
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
@NoArgsConstructor
@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    Long id;
    @JsonProperty("Uin")
    private int uin;
    @JsonProperty("UserName")
    private String username;
    @JsonProperty("NickName")
    private String nickname;
    @JsonProperty("HeadImgUrl")
    private String headimgurl;
    @JsonProperty("RemarkName")
    private String remarkname;
    @JsonProperty("PYInitial")
    private String pyinitial;
    @JsonProperty("PYQuanPin")
    private String pyquanpin;
    @JsonProperty("RemarkPYInitial")
    private String remarkpyinitial;
    @JsonProperty("RemarkPYQuanPin")
    private String remarkpyquanpin;
    @JsonProperty("HideInputBarFlag")
    private int hideinputbarflag;
    @JsonProperty("StarFriend")
    private int starfriend;
    @JsonProperty("Sex")
    private int sex;
    @JsonProperty("Signature")
    private String signature;
    @JsonProperty("AppAccountFlag")
    private int appaccountflag;
    @JsonProperty("VerifyFlag")
    private int verifyflag;
    @JsonProperty("ContactFlag")
    private int contactflag;
    @JsonProperty("WebWxPluginSwitch")
    private int webwxpluginswitch;
    @JsonProperty("HeadImgFlag")
    private int headimgflag;
    @JsonProperty("SnsFlag")
    private int snsflag;
    @Column(name = "Sync_Keys")
    String synckey;
    @OneToMany(cascade={CascadeType.PERSIST})
    @JoinTable(name = "user_contact", joinColumns = {
            @JoinColumn(name = "user_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "contact_ID", referencedColumnName = "ID")})
    List<ContactListBean> contactlist;

    @OneToMany(cascade={CascadeType.PERSIST})
    @JoinTable(name = "user_publicMsg", joinColumns = {
            @JoinColumn(name = "user_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "publicMsg_ID", referencedColumnName = "ID")})
    List<MPSubscribeMsgListBean> mpsubscribemsglist;


    @Column
    boolean alive = false;
    @Column
    private int memberCount = 0;
    @Column
    private String indexUrl;
    @Column
    String uuid;
    @Column
    String wechatId;
    @Column
    Long lastNormalRetcodeTime;
    @Column
    String url;
    @Column
    String pass_ticket;
    @Column
    Integer InviteStartCount;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.ALL})
    @JoinTable(name = "user_sync", joinColumns = {
            @JoinColumn(name = "user_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "sync_ID", referencedColumnName = "ID")})
    SyncKeyBean SyncKey;

    @OneToOne(cascade={CascadeType.PERSIST})
    WechatinitBean wechatinitBean;

    public SyncKeyBean getSyncKey() {
        return SyncKey;
    }

    public void setSyncKey(SyncKeyBean syncKey) {
        SyncKey = syncKey;
    }

    public String getSynckey() {
        return synckey;
    }

    public void setSynckey(String synckey) {
        this.synckey = synckey;
    }

    @OneToMany(cascade={CascadeType.PERSIST})
    List<GroupName> groupIdList;


    @OneToMany(cascade = {CascadeType.ALL})
    public List<BaseMsg> msgList;

    @OneToOne
    private User userSelf; // 登陆账号自身信息


    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "user_contact", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "contact_id", referencedColumnName = "ID")})
    private List<Contact> memberList;

    @Column
    int receivingRetryCount = 5;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<ContactListBean> publicUsersList;
    // 公众号／服务号
    @OneToMany(cascade = {CascadeType.ALL})
    private List<ContactListBean> specialUsersList;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<GroupName> groupNickNameList; // 群NickName列表
    @OneToMany(cascade = {CascadeType.ALL})
    private List<ContactListBean> groupList;

    @Column
    String fileUrl;
    @Column
    String syncUrl;
    @Column
    String deviceid;
    @Column
    String BaseRequest;
    @Column
    String skey;
    @Column
    String wxsid;
    @Column
    String wxuin;
    @Column
    String createTime;

//    @ManyToOne
//    ContactListBean contactListBean;
}