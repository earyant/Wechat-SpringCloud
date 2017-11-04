/**
 * Copyright 2017 aTool.org
 */
package com.earyant.wechatitchat4jprovider.dao;

import com.earyant.wechatitchat4jprovider.dao.bean.ContactListBean;
import com.earyant.wechatitchat4jprovider.dao.bean.MPSubscribeMsgListBean;
import com.earyant.wechatitchat4jprovider.dao.bean.SyncKeyBean;
import com.earyant.wechatitchat4jprovider.dao.bean.WechatinitBean;
import com.earyant.wechatitchat4jprovider.dao.wxsync.WebWxSync;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Auto-generated: 2017-08-13 12:9:23
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
@Entity
@JsonIgnoreProperties
@NoArgsConstructor
@Data
public class User implements Serializable {

    /**
     * Uin : 445565535
     * UserName : @911ceb61491ba62a71f34ce7900df3fe
     * NickName : 李睿
     * HeadImgUrl : /cgi-bin/mmwebwx-bin/webwxgeticon?seq=2014782132&username=@911ceb61491ba62a71f34ce7900df3fe&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1
     * RemarkName :
     * PYInitial :
     * PYQuanPin :
     * RemarkPYInitial :
     * RemarkPYQuanPin :
     * HideInputBarFlag : 0
     * StarFriend : 0
     * Sex : 1
     * Signature :
     * AppAccountFlag : 0
     * VerifyFlag : 0
     * ContactFlag : 0
     * WebWxPluginSwitch : 0
     * HeadImgFlag : 0
     * SnsFlag : 17
     */

    private Long Uin;
    private String UserName;
    private String NickName;
    private String HeadImgUrl;
    private String RemarkName;
    private String PYInitial;
    private String PYQuanPin;
    private String RemarkPYInitial;
    private String RemarkPYQuanPin;
    private int HideInputBarFlag;
    private int StarFriend;
    private int Sex;
    private String Signature;
    private int AppAccountFlag;
    private int VerifyFlag;
    private int ContactFlag;
    private int WebWxPluginSwitch;
    private int HeadImgFlag;
    private int SnsFlag;
    private int loginRetryCount = 10;

    @Id
//    @GeneratedValue
            String id;
    @Column(name = "Sync_Keys")
    String synckey;
    //    @OneToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name = "user_contact", joinColumns = {
//            @JoinColumn(name = "user_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
//            @JoinColumn(name = "contact_ID", referencedColumnName = "ID")})
    @Transient
    List<ContactListBean> contactlist = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
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
    String url = "https://wx2.qq.com/cgi-bin/mmwebwx-bin";
    @Column
    String pass_ticket;
    @Column
    Integer InviteStartCount;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.ALL})
//    @JoinTable(name = "user_sync", joinColumns = {
//            @JoinColumn(name = "user_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
//            @JoinColumn(name = "sync_ID", referencedColumnName = "ID")})
    @Transient
    SyncKeyBean SyncKey;

    @OneToOne(cascade = {CascadeType.PERSIST})
    WechatinitBean wechatinitBean;
    @Transient
    private HashMap<String, List<ContactListBean>> groupMemeberMap = new HashMap<>();

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

    //    @OneToMany(cascade={CascadeType.PERSIST})
//    @Transient
//    List<String> groupIdList = new ArrayList<>();


    //    @OneToMany(cascade = {CascadeType.ALL})
    @Transient
    public List<WebWxSync.AddMsgListBean> msgList = new ArrayList<>();

//    @OneToOne
//    private User userSelf; // 登陆账号自身信息


//    @OneToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name = "user_contact", joinColumns = {
//            @JoinColumn(name = "user_id", referencedColumnName = "ID")}, inverseJoinColumns = {
//            @JoinColumn(name = "contact_id", referencedColumnName = "ID")})
//    private List<Contact> memberList;

    @Column
    int receivingRetryCount = 5;
    //    @OneToMany(cascade = {CascadeType.ALL})
    @Transient
    private List<ContactListBean> publicUsersList = new ArrayList<>();
    // 公众号／服务号
//    @OneToMany(cascade = {CascadeType.ALL})
    @Transient
    private List<ContactListBean> specialUsersList = new ArrayList<>();
    //    @OneToMany(cascade = {CascadeType.ALL})
    @Transient
    private List<String> groupNickNameList = new ArrayList<>(); // 群NickName列表
    //    @OneToMany(cascade = {CascadeType.ALL})
    @Transient
    private List<ContactListBean> groupList = new ArrayList<>();

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

    /**
     * 拼凑请求参数
     */
    public Map<String, Object> getParamMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("Uin", getWxuin());
        map.put("Sid", getWxsid());
        map.put("Skey", getSkey());
        map.put("DeviceID", getPass_ticket());
        HashMap<String, Object> result = new HashMap<>();
        result.put("BaseRequest", map);
        return result;
    }

    public HashMap<String, List<ContactListBean>> getGroupMemeberMap() {
        return groupMemeberMap;
    }
}