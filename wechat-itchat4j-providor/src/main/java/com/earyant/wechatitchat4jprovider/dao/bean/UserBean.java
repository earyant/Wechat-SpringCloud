//package com.earyant.wechatitchat4jprovider.dao.bean;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//
///**
// * Created by earyant on 2017 : 08 : 2017/8/15 : 14:09 : .
// * WechatCloud  com.earyant.wechatitchat4jprovider.dao.bean
// */
//@NoArgsConstructor
//@Data
//@Entity
//public class UserBean {
//    /**
//     * Uin : 359347155
//     * UserName : @6afd04fba6eec68c526a255e5d6ed3bd
//     * NickName : Earyant
//     * HeadImgUrl : /cgi-bin/mmwebwx-bin/webwxgeticon?seq=381335081&username=@6afd04fba6eec68c526a255e5d6ed3bd&skey=@crypt_6bfb774e_3d63d5d93c37dbc0f8b828453e67aab8
//     * RemarkName :
//     * PYInitial :
//     * PYQuanPin :
//     * RemarkPYInitial :
//     * RemarkPYQuanPin :
//     * HideInputBarFlag : 0
//     * StarFriend : 0
//     * Sex : 1
//     * Signature : 心有猛虎，细嗅蔷薇。
//     * AppAccountFlag : 0
//     * VerifyFlag : 0
//     * ContactFlag : 0
//     * WebWxPluginSwitch : 2
//     * HeadImgFlag : 1
//     * SnsFlag : 17
//     */
//
//    @Id
//    @GeneratedValue
//    Long id;
//    private int Uin;
//    private String UserName;
//    private String NickName;
//    private String HeadImgUrl;
//    private String RemarkName;
//    private String PYInitial;
//    private String PYQuanPin;
//    private String RemarkPYInitial;
//    private String RemarkPYQuanPin;
//    private int HideInputBarFlag;
//    private int StarFriend;
//    private int Sex;
//    private String Signature;
//    private int AppAccountFlag;
//    private int VerifyFlag;
//    private int ContactFlag;
//    private int WebWxPluginSwitch;
//    private int HeadImgFlag;
//    private int SnsFlag;
//    @OneToOne
//    WechatinitBean wechatinitBean;
//}
//
