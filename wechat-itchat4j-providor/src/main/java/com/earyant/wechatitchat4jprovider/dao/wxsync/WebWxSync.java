/**
 * Copyright 2017 aTool.org
 */
package com.earyant.wechatitchat4jprovider.dao.wxsync;

import com.earyant.wechatitchat4jprovider.dao.bean.ContactListBean;
import com.earyant.wechatitchat4jprovider.dao.bean.SyncKeyBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * Auto-generated: 2017-08-13 20:23:58
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebWxSync {

    /**
     * BaseResponse : {"Ret":0,"ErrMsg":""}
     * AddMsgCount : 1
     * AddMsgList : [{"MsgId":"7961766576782185528","FromUserName":"@a6f7d7033da92b9906ee36c388967683","ToUserName":"@09b359486b2279d2d40d52cf9cad894c","MsgType":1,"Content":"123","Status":3,"ImgStatus":1,"CreateTime":1503367447,"VoiceLength":0,"PlayLength":0,"FileName":"","FileSize":"","MediaId":"","Url":"","AppMsgType":0,"StatusNotifyCode":0,"StatusNotifyUserName":"","RecommendInfo":{"UserName":"","NickName":"","QQNum":0,"Province":"","City":"","Content":"","Signature":"","Alias":"","Scene":0,"VerifyFlag":0,"AttrStatus":0,"Sex":0,"Ticket":"","OpCode":0},"ForwardFlag":0,"AppInfo":{"AppID":"","Type":0},"HasProductId":0,"Ticket":"","ImgHeight":0,"ImgWidth":0,"SubMsgType":0,"NewMsgId":7961766576782185528,"OriContent":""}]
     * ModContactCount : 0
     * ModContactList : []
     * DelContactCount : 0
     * DelContactList : []
     * ModChatRoomMemberCount : 0
     * ModChatRoomMemberList : []
     * Profile : {"BitFlag":0,"UserName":{"Buff":""},"NickName":{"Buff":""},"BindUin":0,"BindEmail":{"Buff":""},"BindMobile":{"Buff":""},"Status":0,"Sex":0,"PersonalCard":0,"Alias":"","HeadImgUpdateFlag":0,"HeadImgUrl":"","Signature":""}
     * ContinueFlag : 0
     * SyncKey : {"Count":9,"List":[{"Key":1,"Val":679457335},{"Key":2,"Val":679457347},{"Key":3,"Val":679456957},{"Key":11,"Val":679456645},{"Key":13,"Val":679450325},{"Key":201,"Val":1503367447},{"Key":1000,"Val":1503363242},{"Key":1001,"Val":1503363273},{"Key":1002,"Val":1503037832}]}
     * SKey :
     * SyncCheckKey : {"Count":9,"List":[{"Key":1,"Val":679457335},{"Key":2,"Val":679457347},{"Key":3,"Val":679456957},{"Key":11,"Val":679456645},{"Key":13,"Val":679450325},{"Key":201,"Val":1503367447},{"Key":1000,"Val":1503363242},{"Key":1001,"Val":1503363273},{"Key":1002,"Val":1503037832}]}
     */

    private BaseResponseBean BaseResponse;
    private int AddMsgCount;
    private int ModContactCount;
    private int DelContactCount;
    private int ModChatRoomMemberCount;
    private ProfileBean Profile;
    private int ContinueFlag;
    private SyncKeyBean SyncKey;
    private String SKey;
    private SyncKeyBean SyncCheckKey;
    private List<AddMsgListBean> AddMsgList;
    private List<ContactListBean> ModContactList;
    private List<?> DelContactList;
    private List<?> ModChatRoomMemberList;


    public void setModContactList(List<ContactListBean> modContactList) {
        ModContactList = modContactList;
    }

    public BaseResponseBean getBaseResponse() {
        return BaseResponse;
    }

    public void setBaseResponse(BaseResponseBean BaseResponse) {
        this.BaseResponse = BaseResponse;
    }

    public int getAddMsgCount() {
        return AddMsgCount;
    }

    public void setAddMsgCount(int AddMsgCount) {
        this.AddMsgCount = AddMsgCount;
    }

    public int getModContactCount() {
        return ModContactCount;
    }

    public void setModContactCount(int ModContactCount) {
        this.ModContactCount = ModContactCount;
    }

    public int getDelContactCount() {
        return DelContactCount;
    }

    public void setDelContactCount(int DelContactCount) {
        this.DelContactCount = DelContactCount;
    }

    public int getModChatRoomMemberCount() {
        return ModChatRoomMemberCount;
    }

    public void setModChatRoomMemberCount(int ModChatRoomMemberCount) {
        this.ModChatRoomMemberCount = ModChatRoomMemberCount;
    }

    public ProfileBean getProfile() {
        return Profile;
    }

    public void setProfile(ProfileBean Profile) {
        this.Profile = Profile;
    }

    public int getContinueFlag() {
        return ContinueFlag;
    }

    public void setContinueFlag(int ContinueFlag) {
        this.ContinueFlag = ContinueFlag;
    }

    public SyncKeyBean getSyncKey() {
        return SyncKey;
    }

    public void setSyncKey(SyncKeyBean SyncKey) {
        this.SyncKey = SyncKey;
    }

    public String getSKey() {
        return SKey;
    }

    public void setSKey(String SKey) {
        this.SKey = SKey;
    }

    public SyncKeyBean getSyncCheckKey() {
        return SyncCheckKey;
    }

    public void setSyncCheckKey(SyncKeyBean SyncCheckKey) {
        this.SyncCheckKey = SyncCheckKey;
    }

    public List<AddMsgListBean> getAddMsgList() {
        return AddMsgList;
    }

    public void setAddMsgList(List<AddMsgListBean> AddMsgList) {
        this.AddMsgList = AddMsgList;
    }

    public List<ContactListBean> getModContactList() {
        return ModContactList;
    }


    public List<?> getDelContactList() {
        return DelContactList;
    }

    public void setDelContactList(List<?> DelContactList) {
        this.DelContactList = DelContactList;
    }

    public List<?> getModChatRoomMemberList() {
        return ModChatRoomMemberList;
    }

    public void setModChatRoomMemberList(List<?> ModChatRoomMemberList) {
        this.ModChatRoomMemberList = ModChatRoomMemberList;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BaseResponseBean {
        /**
         * Ret : 0
         * ErrMsg :
         */

        private int Ret;
        private String ErrMsg;

        public int getRet() {
            return Ret;
        }

        public void setRet(int Ret) {
            this.Ret = Ret;
        }

        public String getErrMsg() {
            return ErrMsg;
        }

        public void setErrMsg(String ErrMsg) {
            this.ErrMsg = ErrMsg;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProfileBean {
        /**
         * BitFlag : 0
         * UserName : {"Buff":""}
         * NickName : {"Buff":""}
         * BindUin : 0
         * BindEmail : {"Buff":""}
         * BindMobile : {"Buff":""}
         * Status : 0
         * Sex : 0
         * PersonalCard : 0
         * Alias :
         * HeadImgUpdateFlag : 0
         * HeadImgUrl :
         * Signature :
         */

        private int BitFlag;
        private UserNameBean UserName;
        private NickNameBean NickName;
        private int BindUin;
        private BindEmailBean BindEmail;
        private BindMobileBean BindMobile;
        private int Status;
        private int Sex;
        private int PersonalCard;
        private String Alias;
        private int HeadImgUpdateFlag;
        private String HeadImgUrl;
        private String Signature;

        public int getBitFlag() {
            return BitFlag;
        }

        public void setBitFlag(int BitFlag) {
            this.BitFlag = BitFlag;
        }

        public UserNameBean getUserName() {
            return UserName;
        }

        public void setUserName(UserNameBean UserName) {
            this.UserName = UserName;
        }

        public NickNameBean getNickName() {
            return NickName;
        }

        public void setNickName(NickNameBean NickName) {
            this.NickName = NickName;
        }

        public int getBindUin() {
            return BindUin;
        }

        public void setBindUin(int BindUin) {
            this.BindUin = BindUin;
        }

        public BindEmailBean getBindEmail() {
            return BindEmail;
        }

        public void setBindEmail(BindEmailBean BindEmail) {
            this.BindEmail = BindEmail;
        }

        public BindMobileBean getBindMobile() {
            return BindMobile;
        }

        public void setBindMobile(BindMobileBean BindMobile) {
            this.BindMobile = BindMobile;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }

        public int getPersonalCard() {
            return PersonalCard;
        }

        public void setPersonalCard(int PersonalCard) {
            this.PersonalCard = PersonalCard;
        }

        public String getAlias() {
            return Alias;
        }

        public void setAlias(String Alias) {
            this.Alias = Alias;
        }

        public int getHeadImgUpdateFlag() {
            return HeadImgUpdateFlag;
        }

        public void setHeadImgUpdateFlag(int HeadImgUpdateFlag) {
            this.HeadImgUpdateFlag = HeadImgUpdateFlag;
        }

        public String getHeadImgUrl() {
            return HeadImgUrl;
        }

        public void setHeadImgUrl(String HeadImgUrl) {
            this.HeadImgUrl = HeadImgUrl;
        }

        public String getSignature() {
            return Signature;
        }

        public void setSignature(String Signature) {
            this.Signature = Signature;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class UserNameBean {
            /**
             * Buff :
             */

            private String Buff;

            public String getBuff() {
                return Buff;
            }

            public void setBuff(String Buff) {
                this.Buff = Buff;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class NickNameBean {
            /**
             * Buff :
             */

            private String Buff;

            public String getBuff() {
                return Buff;
            }

            public void setBuff(String Buff) {
                this.Buff = Buff;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class BindEmailBean {
            /**
             * Buff :
             */

            private String Buff;

            public String getBuff() {
                return Buff;
            }

            public void setBuff(String Buff) {
                this.Buff = Buff;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class BindMobileBean {
            /**
             * Buff :
             */

            private String Buff;

            public String getBuff() {
                return Buff;
            }

            public void setBuff(String Buff) {
                this.Buff = Buff;
            }
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SyncCheckKeyBean {
        /**
         * Count : 9
         * List : [{"Key":1,"Val":679457335},{"Key":2,"Val":679457347},{"Key":3,"Val":679456957},{"Key":11,"Val":679456645},{"Key":13,"Val":679450325},{"Key":201,"Val":1503367447},{"Key":1000,"Val":1503363242},{"Key":1001,"Val":1503363273},{"Key":1002,"Val":1503037832}]
         */

        private int Count;
        private java.util.List<ListBeanX> List;

        public int getCount() {
            return Count;
        }

        public void setCount(int Count) {
            this.Count = Count;
        }

        public List<ListBeanX> getList() {
            return List;
        }

        public void setList(List<ListBeanX> List) {
            this.List = List;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ListBeanX {
            /**
             * Key : 1
             * Val : 679457335
             */

            private int Key;
            private int Val;

            public int getKey() {
                return Key;
            }

            public void setKey(int Key) {
                this.Key = Key;
            }

            public int getVal() {
                return Val;
            }

            public void setVal(int Val) {
                this.Val = Val;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Entity
    @Data
    public static class AddMsgListBean {
        /**
         * MsgId : 7961766576782185528
         * FromUserName : @a6f7d7033da92b9906ee36c388967683
         * ToUserName : @09b359486b2279d2d40d52cf9cad894c
         * MsgType : 1
         * Content : 123
         * Status : 3
         * ImgStatus : 1
         * CreateTime : 1503367447
         * VoiceLength : 0
         * PlayLength : 0
         * FileName :
         * FileSize :
         * MediaId :
         * Url :
         * AppMsgType : 0
         * StatusNotifyCode : 0
         * StatusNotifyUserName :
         * RecommendInfo : {"UserName":"","NickName":"","QQNum":0,"Province":"","City":"","Content":"","Signature":"","Alias":"","Scene":0,"VerifyFlag":0,"AttrStatus":0,"Sex":0,"Ticket":"","OpCode":0}
         * ForwardFlag : 0
         * AppInfo : {"AppID":"","Type":0}
         * HasProductId : 0
         * Ticket :
         * ImgHeight : 0
         * ImgWidth : 0
         * SubMsgType : 0
         * NewMsgId : 7961766576782185528
         * OriContent :
         */
        @Id
        @GeneratedValue
        Long id;
        private String MsgId;
        private String FromUserName;
        private String ToUserName;
        private int MsgType;
        private String Content;
        private int Status;
        private int ImgStatus;
        private int CreateTime;
        private int VoiceLength;
        private int PlayLength;
        private String FileName;
        private String FileSize;
        private String MediaId;
        private String Url;
        private int AppMsgType;
        private int StatusNotifyCode;
        private String StatusNotifyUserName;
        @Transient
        private RecommendInfoBean RecommendInfo;
        private int ForwardFlag;
        @Transient
        private AppInfoBean AppInfo;
        private int HasProductId;
        private String Ticket;
        private int ImgHeight;
        private int ImgWidth;
        private int SubMsgType;
        private long NewMsgId;
        private String OriContent;
        private boolean groupMsg;
        private String text;
        private String Type;
        //        是否恢复过了。
        private boolean reply;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
        }

        public boolean isGroupMsg() {
            return groupMsg;
        }

        public void setGroupMsg(boolean groupMsg) {
            this.groupMsg = groupMsg;
        }

        public String getMsgId() {
            return MsgId;
        }

        public void setMsgId(String MsgId) {
            this.MsgId = MsgId;
        }

        public String getFromUserName() {
            return FromUserName;
        }

        public void setFromUserName(String FromUserName) {
            this.FromUserName = FromUserName;
        }

        public String getToUserName() {
            return ToUserName;
        }

        public void setToUserName(String ToUserName) {
            this.ToUserName = ToUserName;
        }

        public int getMsgType() {
            return MsgType;
        }

        public void setMsgType(int MsgType) {
            this.MsgType = MsgType;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getImgStatus() {
            return ImgStatus;
        }

        public void setImgStatus(int ImgStatus) {
            this.ImgStatus = ImgStatus;
        }

        public int getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(int CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getVoiceLength() {
            return VoiceLength;
        }

        public void setVoiceLength(int VoiceLength) {
            this.VoiceLength = VoiceLength;
        }

        public int getPlayLength() {
            return PlayLength;
        }

        public void setPlayLength(int PlayLength) {
            this.PlayLength = PlayLength;
        }

        public String getFileName() {
            return FileName;
        }

        public void setFileName(String FileName) {
            this.FileName = FileName;
        }

        public String getFileSize() {
            return FileSize;
        }

        public void setFileSize(String FileSize) {
            this.FileSize = FileSize;
        }

        public String getMediaId() {
            return MediaId;
        }

        public void setMediaId(String MediaId) {
            this.MediaId = MediaId;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public int getAppMsgType() {
            return AppMsgType;
        }

        public void setAppMsgType(int AppMsgType) {
            this.AppMsgType = AppMsgType;
        }

        public int getStatusNotifyCode() {
            return StatusNotifyCode;
        }

        public void setStatusNotifyCode(int StatusNotifyCode) {
            this.StatusNotifyCode = StatusNotifyCode;
        }

        public String getStatusNotifyUserName() {
            return StatusNotifyUserName;
        }

        public void setStatusNotifyUserName(String StatusNotifyUserName) {
            this.StatusNotifyUserName = StatusNotifyUserName;
        }

        public RecommendInfoBean getRecommendInfo() {
            return RecommendInfo;
        }

        public void setRecommendInfo(RecommendInfoBean RecommendInfo) {
            this.RecommendInfo = RecommendInfo;
        }

        public int getForwardFlag() {
            return ForwardFlag;
        }

        public void setForwardFlag(int ForwardFlag) {
            this.ForwardFlag = ForwardFlag;
        }

        public AppInfoBean getAppInfo() {
            return AppInfo;
        }

        public void setAppInfo(AppInfoBean AppInfo) {
            this.AppInfo = AppInfo;
        }

        public int getHasProductId() {
            return HasProductId;
        }

        public void setHasProductId(int HasProductId) {
            this.HasProductId = HasProductId;
        }

        public String getTicket() {
            return Ticket;
        }

        public void setTicket(String Ticket) {
            this.Ticket = Ticket;
        }

        public int getImgHeight() {
            return ImgHeight;
        }

        public void setImgHeight(int ImgHeight) {
            this.ImgHeight = ImgHeight;
        }

        public int getImgWidth() {
            return ImgWidth;
        }

        public void setImgWidth(int ImgWidth) {
            this.ImgWidth = ImgWidth;
        }

        public int getSubMsgType() {
            return SubMsgType;
        }

        public void setSubMsgType(int SubMsgType) {
            this.SubMsgType = SubMsgType;
        }

        public long getNewMsgId() {
            return NewMsgId;
        }

        public void setNewMsgId(long NewMsgId) {
            this.NewMsgId = NewMsgId;
        }

        public String getOriContent() {
            return OriContent;
        }

        public void setOriContent(String OriContent) {
            this.OriContent = OriContent;
        }

        @Entity
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class RecommendInfoBean {
            /**
             * UserName :
             * NickName :
             * QQNum : 0
             * Province :
             * City :
             * Content :
             * Signature :
             * Alias :
             * Scene : 0
             * VerifyFlag : 0
             * AttrStatus : 0
             * Sex : 0
             * Ticket :
             * OpCode : 0
             */

            @Id
            @GeneratedValue
            Long id;
            private String UserName;
            private String NickName;
            private int QQNum;
            private String Province;
            private String City;
            private String Content;
            private String Signature;
            private String Alias;
            private int Scene;
            private int VerifyFlag;
            private int AttrStatus;
            private int Sex;
            private String Ticket;
            private int OpCode;

            String msgId;

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getMsgId() {
                return msgId;
            }

            public void setMsgId(String msgId) {
                this.msgId = msgId;
            }

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getNickName() {
                return NickName;
            }

            public void setNickName(String NickName) {
                this.NickName = NickName;
            }

            public int getQQNum() {
                return QQNum;
            }

            public void setQQNum(int QQNum) {
                this.QQNum = QQNum;
            }

            public String getProvince() {
                return Province;
            }

            public void setProvince(String Province) {
                this.Province = Province;
            }

            public String getCity() {
                return City;
            }

            public void setCity(String City) {
                this.City = City;
            }

            public String getContent() {
                return Content;
            }

            public void setContent(String Content) {
                this.Content = Content;
            }

            public String getSignature() {
                return Signature;
            }

            public void setSignature(String Signature) {
                this.Signature = Signature;
            }

            public String getAlias() {
                return Alias;
            }

            public void setAlias(String Alias) {
                this.Alias = Alias;
            }

            public int getScene() {
                return Scene;
            }

            public void setScene(int Scene) {
                this.Scene = Scene;
            }

            public int getVerifyFlag() {
                return VerifyFlag;
            }

            public void setVerifyFlag(int VerifyFlag) {
                this.VerifyFlag = VerifyFlag;
            }

            public int getAttrStatus() {
                return AttrStatus;
            }

            public void setAttrStatus(int AttrStatus) {
                this.AttrStatus = AttrStatus;
            }

            public int getSex() {
                return Sex;
            }

            public void setSex(int Sex) {
                this.Sex = Sex;
            }

            public String getTicket() {
                return Ticket;
            }

            public void setTicket(String Ticket) {
                this.Ticket = Ticket;
            }

            public int getOpCode() {
                return OpCode;
            }

            public void setOpCode(int OpCode) {
                this.OpCode = OpCode;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AppInfoBean {
            /**
             * AppID :
             * Type : 0
             */

            private String AppID;
            private int Type;

            public String getAppID() {
                return AppID;
            }

            public void setAppID(String AppID) {
                this.AppID = AppID;
            }

            public int getType() {
                return Type;
            }

            public void setType(int Type) {
                this.Type = Type;
            }
        }
    }
}