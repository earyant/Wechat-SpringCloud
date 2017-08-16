package com.earyant.wechatitchat4jprovider.itchat4j.utils.enums;

public enum RetCodeEnum {

    NORMAL("0", "comment"),
    LOGIN_OUT("1102", "quit"),
    LOGIN_OTHERWHERE("1101", "orther login"),
    MOBILE_LOGIN_OUT("1102", "phone exit"),
    UNKOWN("9999", "unkown");


    private String code;
    private String type;

    RetCodeEnum(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

}
