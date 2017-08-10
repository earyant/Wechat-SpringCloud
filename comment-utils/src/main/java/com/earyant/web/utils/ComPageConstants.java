package com.earyant.web.utils;

/**
 * 页面后台公用常量值
 */
public class ComPageConstants {

    //车辆状态
    public static final String VECL_TYPE_0 = "0";//有效
    public static final String VECL_TYPE_1 = "1"; //不存在车主
    public static final String VECL_TYPE_2 = "2"; //无效

    //车主类型 0默认 1车主 2 二手车 3 无效
    public static final String OWNER_TYPE_0 = "0";
    public static final String OWNER_TYPE_1 = "1";
    public static final String OWNER_TYPE_2 = "2";
    public static final String OWNER_TYPE_3 = "3";

    //身份类型 1身份证 2其他
    public static final String ID_TYPE_SFZ = "1";
    public static final String ID_TYPE_QT = "2";

    //新闻 活动的有效状态
    public static final String STATUS_PASS = "3";

    //DICT类型
    public static final String DICT_TYPE_30 = "30";//预约驾驶时间
    public static final String DICT_TYPE_32 = "32";//首页配置
    public static final String DICT_TYPE_31 = "31";//证件类型
    public static final String DICT_TYPE_20 = "20";//归属模块类型
    public static final String DICT_TYPE_40 = "40";//版本类型


    //活动相册类型 1 图片 2 视频
    public static final String club_tp = "1";//图片
    public static final String club_sp = "2";//视频

    //活动参与表状态
    public static final String club_status_join_submit = "0";//活动状态 提交
    public static final String club_status_join_dd = "1";//审批通过

    //预约试驾表状态
    public static final String book_status_join_submit = "0";//活动状态 提交
    public static final String book_status_join_dd = "1";//审批通过

    //新闻，活动，问题，经销商 用户关系表状态 1 收藏 2分享转发
    public static final String shoucang = "1";
    public static final String fengxiang = "2";

    //首页表的状态 后续可能新增
    public static final String T_ACTIVITIES = "1";//活动
    public static final String T_CONTENT = "2";//内容

    //首页表状态
    public static final String disp_type_top = "1";//轮播
    public static final String disp_type_button = "2";//网格

    //版本表 状态 1-app版本 2-使用条款 3-隐私及政策  4-区域数据 5接机服务条款 其他类型待添加
    public static String version_type_app = "1";
    public static String version_type_tk = "2";
    public static String version_type_zc = "3";
    public static String version_type_regn = "4";
    public static String version_type_air = "5";

    //图片路径  跟目录DATA
    public static final String RES_PATH_AVATAR = "data/avatar";//用户添加头像时候路径
    public static final String RES_PATH_MANUAL = "data/manual";//手册路径
    public static final String RES_PATH_VEDIO = "data/video";//视频路径
    public static final String RES_PATH_PIC = "data/pic";//图片保存路径
    public static final String RES_PATH_APK = "data/apk";//apk 路径
    public static final String MAIL_PATH = "data/mail/send";//邮件生成Excel路径
    public static final String ICON_PATH = "/data/icon/";//邮件生成Excel路径

    //图片类的具体子路径
    public static final String PIC_PATH_ORIG = "orig";//原始目录
    public static final String PIC_PATH_THUMB = "thumb";//缩略图目录
    public static final String PIC_PATH_MID = "mid";//中图
    public static final String PIC_PATH_TX = "tx";//孩子家长的头像信息封面图
    //视频默认图片
    public static final String PIC_PATH_VIDEO = "data/pic/default.png";
    //背景图片
    public static final String PIC_PATH_BG = "data/pic/bg.png";
    public static final int PIC_THUMB_IMG_HEIGHT1 = 195;
    public static final int PIC_THUMB_IMG_WIDTH1 = 110;

    //缩略图尺寸

    public static final int PIC_THUMB_IMG_WIDTH = 210;//缩略图 w
    public static final int PIC_THUMB_IMG_HEIGHT = 210;//缩略图h
    public static final int PIC_MID_IMG_WIDTH = 350;//中图w
    public static final int PIC_MID_IMG_HEIGHT = -1;//中图w   -1表示自适应

}
