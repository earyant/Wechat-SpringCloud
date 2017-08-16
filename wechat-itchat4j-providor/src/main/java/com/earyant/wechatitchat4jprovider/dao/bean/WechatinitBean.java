package com.earyant.wechatitchat4jprovider.dao.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by earyant on 2017 : 08 : 2017/8/15 : 13:56 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.bean
 */
@NoArgsConstructor
@Data
@Entity
public class WechatinitBean {
    @Id
    @GeneratedValue
    Long id;
    @OneToOne
    private BaseResponseBean BaseResponse;
    private int Count;
    @OneToOne
    private SyncKeyBean SyncKey;
    @OneToOne
    private com.earyant.wechatitchat4jprovider.dao.User User;
    private String ChatSet;
    private String SKey;
    private int ClientVersion;
    private int SystemTime;
    private int GrayScale;
    private int InviteStartCount;
    private int MPSubscribeMsgCount;
    private int ClickReportInterval;
    @OneToMany
    private List<ContactListBean> ContactList;
    @OneToMany
    private List<MPSubscribeMsgListBean> MPSubscribeMsgList;

}
