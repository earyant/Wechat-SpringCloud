package com.earyant.wechatitchat4jprovider.dao;

import javax.persistence.*;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 21:01 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.dao
 */
@Entity()
public class Contact {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String ChatRoomId;
    @Column
    String Sex;
    @Column
    String AttrStatus;
    @Column
    String Statues;
    @Column
    String PYQuanPin;
    @Column
    String EncryChatRoomId;
    @Column
    String DisplayName;
    @Column
    String VerifyFlag;
    @Column
    String UniFriend;
    @Column
    String ContactFlag;
    @Column
    String UserName;
//    @Column
//    List<String> MemberList;
    @Column
    String StarFriend;
    @Column
    String HeadImgUrl;
    @Column
    String AppAccountFlag;
    @Column
    String MemberCount;
    @Column
    String RemarkPYInitial;
    @Column
    String City;
    @Column
    String NickName;
    @Column
    String Province;
    @Column
    String SnsFlag;
    @Column
    String Alias;
    @Column
    String KeyWord;
    @Column
    String HideInputBarFlag;
    @Column
    String Signature;
    @Column
    String RemarkName;
    @Column
    String RemarkPYQuanPin;
    @Column
    String Uin;
    @Column
    String OwnerUin;
    @Column
    String IsOwner;
    @Column
    String PYInitial;

    @ManyToOne(cascade = CascadeType.ALL)
    User user;
}
