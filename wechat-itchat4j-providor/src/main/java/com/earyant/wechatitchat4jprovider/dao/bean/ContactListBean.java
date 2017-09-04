package com.earyant.wechatitchat4jprovider.dao.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by earyant on 2017 : 08 : 2017/8/15 : 14:09 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.bean
 */
@NoArgsConstructor
@Data
@Entity
public class ContactListBean {
    /**
     * Uin : 0
     * UserName : filehelper
     * NickName : 文件传输助手
     * HeadImgUrl : /cgi-bin/mmwebwx-bin/webwxgeticon?seq=679598517&username=filehelper&skey=@crypt_6bfb774e_3d63d5d93c37dbc0f8b828453e67aab8
     * ContactFlag : 1
     * MemberCount : 0
     * MemberList : []
     * RemarkName :
     * HideInputBarFlag : 0
     * Sex : 0
     * Signature :
     * VerifyFlag : 0
     * OwnerUin : 0
     * PYInitial : WJCSZS
     * PYQuanPin : wenjianchuanshuzhushou
     * RemarkPYInitial :
     * RemarkPYQuanPin :
     * StarFriend : 0
     * AppAccountFlag : 0
     * Statues : 0
     * AttrStatus : 0
     * Province :
     * City :
     * Alias :
     * SnsFlag : 0
     * UniFriend : 0
     * DisplayName :
     * ChatRoomId : 0
     * KeyWord : fil
     * EncryChatRoomId :
     * IsOwner : 0
     */

    @Id
    @GeneratedValue
    Long id;
    private int Uin;
    private String UserName;
    private String NickName;
    private String HeadImgUrl;
    private int ContactFlag;
    private int MemberCount;
    private String RemarkName;
    private int HideInputBarFlag;
    private int Sex;
    private String Signature;
    private int VerifyFlag;
    private int OwnerUin;
    private String PYInitial;
    private String PYQuanPin;
    private String RemarkPYInitial;
    private String RemarkPYQuanPin;
    private int StarFriend;
    private int AppAccountFlag;
    private int Statues;
    private Long AttrStatus;
    private String Province;
    private String City;
    private String Alias;
    private int SnsFlag;
    private int UniFriend;
    private String DisplayName;
    private int ChatRoomId;
    private String KeyWord;
    private String EncryChatRoomId;
    private int IsOwner;
    @Transient
    private List<ContactListBean> MemberList;
    String userId;
    String groupName;
//    @OneToMany
//    User user;
}

