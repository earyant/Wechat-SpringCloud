package com.earyant.wechatitchat4jprovider.dao;

import com.earyant.wechatitchat4jprovider.itchat4j.beans.BaseMsg;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 20:34 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.dao
 */
@Entity
@Data
public class User  implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    @GeneratedValue
    Long id;
    @Column
    boolean alive = false;
    @Column
    private int memberCount = 0;
    @Column
    private String indexUrl;
    @Column
    private String userName;
    @Column
    private String nickName;
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
    @Column(name = "sync_key")
    String synckey;
    @Column
    Integer InviteStartCount;
    @Column(name = "syncKeys")
    String SyncKey;

    @OneToMany
    List<GroupName> groupIdList;


    @OneToMany(cascade = {CascadeType.ALL})
    public List<BaseMsg> msgList;

    @Column
    private String userSelf; // 登陆账号自身信息

//    private List<Contact> memberList = new ArrayList<>(); // 好友+群聊+公众号+特殊账号

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "user_contact", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "contact_id", referencedColumnName = "ID")})
    private List<Contact> memberList;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Contact> contactList;// 好友

    @Column
    int receivingRetryCount = 5;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Contact> publicUsersList;
    // 公众号／服务号
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Contact> specialUsersList;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<GroupName> groupNickNameList; // 群NickName列表
    @OneToMany(cascade = {CascadeType.ALL})
    private List<GroupName> groupList;

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


//    private List<Contact> groupList = new ArrayList<>();
//    ; // 群
//    private Map<String, Contact> groupMemeberMap = new HashMap<>(); // 群聊成员字典
//    private List<Contact> publicUsersList = new ArrayList<>();
//    ;// 公众号／服务号
//    private List<Contact> specialUsersList = new ArrayList<>();
//    ;// 特殊账号
//    private List<Contact> groupIdList = new ArrayList<>(); // 群ID列表
//    private List<Contact> groupNickNameList = new ArrayList<>(); // 群NickName列表

//    public Map<String, Object> getParamMap() {
//		return new HashMap<String, Object>(1) {
//			/**
//			 *
//			 */
//			private static final long serialVersionUID = 1L;
//
//			{
//				Map<String, String> map = new HashMap<String, String>();
//				for (BaseParaEnum baseRequest : BaseParaEnum.values()) {
//					map.put(baseRequest.para(), getLoginInfo().get(baseRequest.value()).toString());
//				}
//				put("BaseRequest", map);
//			}
//		};
//	}
}
