package com.earyant.web.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口公用常量值
 */
public class InterConstants {

    //接口状态 提供数据的来源 1缓存，2数据库，3外部接口
    public static final String ws_type_cache = "1";
    public static final String ws_type_db = "2";
    public static final String ws_type_ws = "3";


    public static final int PAY_NOT = 0;
    public static final int PAY_YES = 1;
//	public static final int PAY_NOT = 0;

    public static final int MC_APK_ID = 1;
    public static final int MCS_APK_ID = 2;
    public static final int MCP_APK_ID = 3;


    //接口中分页的默认分页
    public static final String pagesize = "10";
    //返回值错误码
    public static final String CODE_OK = "200";
    public static final String CODE_PARAM_NULL = "100"; //参数为空
    public static final String CODE_PARAM_ERR = "101"; //参数错误
    public static final String CODE_BT_ERR = "102";//参数不能为空值
    public static final String OUT_NUMBER_ERR = "103";//用户数量超出上限
    public static final String ADMINSTATUS_3 = "104";//用户数量超出上限


    public static final String CODE_USER_ERR = "301";
    public static final String CODE_USER_EXIST = "302";
    public static final String CODE_OVERDUE = "303";
    public static final String CODE_REQ_ERR = "500"; //系统错误
    public static final String CODE_UPDATE_ERR = "50001";//数据库操作错误，请联系数据库管理员
    public static final String CODE_SAVE_ICON_ERR = "50002";//图片保存出错，请联系系统管理员
    //不存在
    public static final String CODE_MAIL_NOT_EXISiT = "40001";//邮箱不存在;
    public static final String CODE_MAILORPASSWORD_NOT_EXISiT = "40003";//邮箱或密码不正确;
    public static final String CODE_NOT_DATA_QUERY = "40002";//没有日志记录;
    //非法
    public static final String CODE_MAIL_ERR = "41002";//邮箱参数错误;
    public static final String CODE_APP_ICONS_NUM_ERROR = "41003";//app数量与图标数量不一致
    //已经存在
    public static final String CODE_MAIL_REGISTERED = "42002";//邮箱已经注册;

    //返回值KEY
    public static final String result = "data";
    public static final String page_result = "pageInfo";
    public static final String resultcode = "status";
    public static final String reason = "msg";
    public static final String DETAIL = "detail";

    //缓存名称 settingParam系统参数缓存  outdate数据缓存
    public static final String CACHENAMEINITPARAM = "settingParam"; //setting表  dict表使用
    public static final String CACHENAMEOUTDATE = "outdate";    //所有的数据使用
    public static final String CACHENAME_VECLDRVDATA = "vecldrvdata";    //车辆行驶数据缓存


    public static final String hpzl = "02";

    //数据库表名
    public static final String T_VERSION_LIST = "t_version_list";//版本管理清单表

    public static final String APP_KEY = "APP_KEY";//

    //时间格式
    public static final String WS_MON_FMT = "yyyy-MM"; //精确到月
    public static final String WS_DAY_FMT = "yyyy-MM-dd"; //精确到日
    public static final String WS_DAY_HMS_FMT = "yyyy-MM-dd HH:mm:ss";//时分秒
    public static final String WS_DAY_HM_FMT = "yyyy-MM-dd HH:mm";//时分


    public static void getCodeMapOK(Map<String, Object> map) {
        Map<String, Object> codeMap = new HashMap<String, Object>();
        codeMap.put("errcode", 0);
        codeMap.put("detail", "操作成功");

    }


}
