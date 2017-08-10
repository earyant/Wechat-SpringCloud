package com.earyant.web.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目公用常量值
 */
public class ComConstants {

    //项目中默认状态 0是， 1否
    public static final String STATUS_OK = "0";
    public static final String STATUS_NO = "1";
    public static final String STATUS_QT = "2";

    //邮件类型  1发送类型 2接收类型
    public static final String MAIL_TYPE_SEND = "1";

    //默认数据库链接 mysql orcale sqlser
    public static final String DBCODE = "mysql";

    //系统默认开始路径  spring初始化
    public static String SYSTEMPATH = "";

    //系统默认开始路径  读取数据库setting配置表
    public static String WEBPATH = "";//外网
    public static String WEBPATH_OUT = "";//内网
    public static String WEBURL = "";//外网
    public static String APP_KEY_WEPROTECT_IPAD = "";//A用户pad端appkey
    public static String APP_KEY_WEPROTECT_IPONE = "";//A用户ipone端appkey
    public static String APP_KEY_WEPROTECT_ANDROID = "";//A用户android端appkey
    public static String APP_KEY_MOBILECONTROL = "";//手机控制端appkey
    public static String CACHE_SERVERS = "";//memcached缓存地址
    public static String SERVERHOST = "";//邮箱服务器
    public static String SERVERPORT = "";//系统发送邮箱端口
    public static String PASSWORD = "";//系统发送邮箱密码
    public static String ADDRESS = "";//系统发送邮箱地址
    public static String USER_NAME = "";//系统发送邮箱用户名

    //session KEY
    public static final String SESSION_KEY = "SYSSESSIONKEY";

    //数据返回格式
    public static final String FWD_JSON = "json";

    public static final String WEB_URL = "www.Fortune-info.com";


    //统一页面跳转路径
    public static final String PAGE_LOGING_ACTION = "/sys/login/userLoad.htm";
    public static String PAGE_LONGIN_URL = "/login.jsp";
    public static String PAGE_MAIN_URL = "/sys/login/toIdx.action";// "/login/main.htm";
    public static String PAGE_SYSMAIN_URL = "/login/adminmain.htm";

    //session超时 登录时候设定
    public static int SC_SESSION_TIMEOUT = 10001;

    //时间格式
    public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";

    //返回值状态
    public static String YES = "Y";//YES
    public static String NO = "N";//NO

    //获取当前时间 MySQL函数
    public static String DB_SYS_DATE_FINAL = "NOW()";

    //树的分隔符
    public static final String TREE_PATH_END = "##";
    public static final String TREE_PATH_CENTRE = "->";

    //定时任务状态
    public static final Map<String, String> status = new HashMap<String, String>();

    static {
        status.put("ACQUIRED", "运行中");
        status.put("PAUSED", "暂停中");
        status.put("WAITING", "等待中");
    }

    public static String getPAGE_LONGIN_URL() {
        return PAGE_LONGIN_URL;
    }

    public static void setPAGE_LONGIN_URL(String pAGE_LONGIN_URL) {
        PAGE_LONGIN_URL = pAGE_LONGIN_URL;
    }

    //客户证件类型
    public static final String ID_TYPE = "31";
}