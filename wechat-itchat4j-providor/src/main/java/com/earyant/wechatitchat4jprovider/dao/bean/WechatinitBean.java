package com.earyant.wechatitchat4jprovider.dao.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by earyant on 2017 : 08 : 2017/8/15 : 13:56 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.bean
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
@Entity
public class WechatinitBean {
    @Id
    @GeneratedValue
    Long id;
    @Transient
    private BaseResponseBean BaseResponse;
    private int Count;
    @Transient
    private SyncKeyBean SyncKey;
    @Transient
    @JsonProperty(value = "User")
    private com.earyant.wechatitchat4jprovider.dao.User User;
    private String ChatSet;
    private String SKey;
    private int ClientVersion;
    private int SystemTime;
    private int GrayScale;
    private int InviteStartCount;
    private int MPSubscribeMsgCount;
    private int ClickReportInterval;
    @Transient
    private List<ContactListBean> ContactList;
    @Transient
    private List<MPSubscribeMsgListBean> MPSubscribeMsgList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaseResponseBean getBaseResponse() {
        return BaseResponse;
    }

    public void setBaseResponse(BaseResponseBean baseResponse) {
        BaseResponse = baseResponse;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public SyncKeyBean getSyncKey() {
        return SyncKey;
    }

    public void setSyncKey(SyncKeyBean syncKey) {
        SyncKey = syncKey;
    }

    public com.earyant.wechatitchat4jprovider.dao.User getUser() {
        return User;
    }

    public void setUser(com.earyant.wechatitchat4jprovider.dao.User user) {
        User = user;
    }

    public String getChatSet() {
        return ChatSet;
    }

    public void setChatSet(String chatSet) {
        ChatSet = chatSet;
    }

    public String getSKey() {
        return SKey;
    }

    public void setSKey(String SKey) {
        this.SKey = SKey;
    }

    public int getClientVersion() {
        return ClientVersion;
    }

    public void setClientVersion(int clientVersion) {
        ClientVersion = clientVersion;
    }

    public int getSystemTime() {
        return SystemTime;
    }

    public void setSystemTime(int systemTime) {
        SystemTime = systemTime;
    }

    public int getGrayScale() {
        return GrayScale;
    }

    public void setGrayScale(int grayScale) {
        GrayScale = grayScale;
    }

    public int getInviteStartCount() {
        return InviteStartCount;
    }

    public void setInviteStartCount(int inviteStartCount) {
        InviteStartCount = inviteStartCount;
    }

    public int getMPSubscribeMsgCount() {
        return MPSubscribeMsgCount;
    }

    public void setMPSubscribeMsgCount(int MPSubscribeMsgCount) {
        this.MPSubscribeMsgCount = MPSubscribeMsgCount;
    }

    public int getClickReportInterval() {
        return ClickReportInterval;
    }

    public void setClickReportInterval(int clickReportInterval) {
        ClickReportInterval = clickReportInterval;
    }

    public List<ContactListBean> getContactList() {
        return ContactList;
    }

    public void setContactList(List<ContactListBean> contactList) {
        ContactList = contactList;
    }

    public List<MPSubscribeMsgListBean> getMPSubscribeMsgList() {
        return MPSubscribeMsgList;
    }

    public void setMPSubscribeMsgList(List<MPSubscribeMsgListBean> MPSubscribeMsgList) {
        this.MPSubscribeMsgList = MPSubscribeMsgList;
    }
}
