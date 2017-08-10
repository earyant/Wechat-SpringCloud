package com.earyant.web.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommMethod {
    public static final String NULL = "null";
    public static final String BLANK = "";
    private static CommMethod inst;
    DecimalFormat df;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public CommMethod() {
        df = new DecimalFormat("0.00");
    }


    /**
     * 对inst变量进行实例化
     */
    public synchronized static CommMethod getInstance() {
        if (inst == null) {
            inst = new CommMethod();
        }
        return inst;
    }


    // 保留两位小数， 输入double返回String
    public String fmDoubleToStr(double dl, int flag) {
        return df.format(dl);
    }

    // 保留 flag位小数， 输入String返回double str必须是double格式
    public static String fmStrTo(String str, int flag) {
        if (str == null || "".equals(str))
            return "";

        String fmStr = "0.";
        for (int i = 0; i < flag; i++) {
            fmStr += "0";
        }
        double dl = Double.parseDouble(str);
        DecimalFormat dff = new DecimalFormat(fmStr);

        return dff.format(dl);
    }

    // 保留 flag位小数， 输入String返回double str必须是double格式
    public static String fmStrToDecimal(String str, int flag) {
        if (str == null || "".equals(str))
            return "";

        String fmStr = "0.";
        for (int i = 0; i < flag; i++) {
            fmStr += "#";
        }
        double dl = Double.parseDouble(str);
        DecimalFormat dff = new DecimalFormat(fmStr);

        return dff.format(dl);
    }

	/*
     * 从request对象获取参数map对象
	 */

    @SuppressWarnings("unchecked")
    public static Map getRequestMap(HttpServletRequest request) {

        // 参数Map
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String, String[]> properties = request.getParameterMap();

        // 返回值Map

        Map returnMap = new HashMap();

        Iterator entries = properties.entrySet().iterator();

        Map.Entry entry;

        String name = "";

        String value = "";

        while (entries.hasNext()) {

            entry = (Map.Entry) entries.next();

            name = (String) entry.getKey();

            Object valueObj = entry.getValue();
            value = "";

            if (null == valueObj) {

                value = "";

            } else if (valueObj instanceof String[]) {

                String[] values = (String[]) valueObj;
                value = StringUtils.join(values, ',');

            } else {

                value = valueObj.toString();

            }

            returnMap.put(name, value);

        }
        returnMap.put("request007", CommMethod.nvl(request.getRequestURI()));
        //如果客户端传了src_ip，需要替换  remoteaddr007   2014-12-12 xuhm h5的服务器直接调用的server，所以需要增加该处理
        String src_ip = CommMethod.nvl(returnMap.get("src_ip"));
        if (CommMethod.isNotEmpty(src_ip)) {
            returnMap.put("remoteaddr007", src_ip);
        } else {
//			returnMap.put("remoteaddr007",CommMethod.nvl(com.common.tools.utils.StringUtils.getIpAddr(request)));
        }
        //如果传protectUserId和protectUserType，改成inspectorId和adminId
        String weProtectUserId = CommMethod.nvl(returnMap.get("weProtectUserId"));
        String weProtectUserType = CommMethod.nvl(returnMap.get("weProtectUserType"));
        if (CommMethod.isNotEmpty(weProtectUserId) && CommMethod.isNotEmpty(weProtectUserType)) {
            if ("inspector".equals(weProtectUserType)) {
                returnMap.put("inspectorId", weProtectUserId);
            } else if ("administrator".equals(weProtectUserType)) {
                returnMap.put("adminId", weProtectUserId);
            }
        }
        return returnMap;
    }

    /*
     * 从request对象获取参数map对象  不附加ip
     */
    @SuppressWarnings("unchecked")
    public static Map getOrigReqstMap(HttpServletRequest request) {

        // 参数Map
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        Map<String, String[]> properties = request.getParameterMap();

        // 返回值Map

        Map returnMap = new HashMap();

        Iterator entries = properties.entrySet().iterator();

        Map.Entry entry;

        String name = "";

        String value = "";

        while (entries.hasNext()) {

            entry = (Map.Entry) entries.next();

            name = (String) entry.getKey();

            Object valueObj = entry.getValue();
            value = "";

            if (null == valueObj) {

                value = "";

            } else if (valueObj instanceof String[]) {

                String[] values = (String[]) valueObj;
                value = StringUtils.join(values, ',');

            } else {

                value = valueObj.toString();

            }

            returnMap.put(name, value);

        }
        return returnMap;

    }

    public static String getValThenOpMap(Map map, String key, String op_type) {
        String ret = CommMethod.nvl(map.get(key));
        if ("del_key".equals(op_type)) {
            map.remove(key);
        }
        return ret;
    }

    //
    public static String getObject2Str(Object str) {
        String ret = "";
        if (str == null)
            ret = "";
        else
            ret = String.valueOf(str);
        return ret;
    }

    /*
     * 判断是否是 数字
     */
    public static boolean isNum(String str) {
        if (CommMethod.isEmpty(str)) return false;
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }

    public static boolean isInteger(String str) {
        if (CommMethod.isEmpty(str)) return false;
        return str.matches("^[1-9]\\d*$");
    }


    /**
     * 将特殊字符分隔的字符串分解为数组，如"1^2233^23^22"或者"1^2233^23^22^"
     * <p>
     * 特殊字符
     *
     * @return 转换后的字符串数组
     */
    public static String[] strToArray(String strSource, String strSpecial) {
        if (strSource == null || strSource.equalsIgnoreCase("")) {
            return null;
        }
        // 确定符号strSpecial在strSource中最后出现的位置，第一个字符为零
        int iLastIndex = strSource.lastIndexOf(strSpecial);
        // 如果符号strSpecial不在strSource的最后，则将其加在最后
        if (iLastIndex != (strSource.length() - strSpecial.length())) {
            strSource = strSource + strSpecial;
        }

        String[] ReturnArray;
        int Counter = 0;
        int StartPos = 0, EndPos = 0;
        // 确定 strSpecial在strSource中出现的开始位置。
        StartPos = strSource.indexOf(strSpecial);
        // 确定strSpecial在strSource中出现的个数
        while (StartPos != -1) {
            Counter++;
            StartPos = strSource.indexOf(strSpecial, StartPos + 1);
        }

        if (Counter == 0) {
            return null;
        } else { // 根据strSpecial在strSource中出现的个数确定数组的维数
            ReturnArray = new String[Counter];
            StartPos = 0;
            // strSpecial在strSource中出现的开始位置
            EndPos = strSource.indexOf(strSpecial);
            Counter = 0;

            while (EndPos != -1) {
                // 截取0--符号之间的字符串，并付给个个维变量,完成字符串到数组的转换。
                ReturnArray[Counter] = strSource.substring(StartPos, EndPos);
                Counter++;
                StartPos = EndPos + strSpecial.length();
                EndPos = strSource.indexOf(strSpecial, StartPos);
            }
        }

        return ReturnArray;
    }


    public static boolean flagMatchInRules(String flag, String[] rules) {
        if (rules == null || rules.length == 0)
            return false;

        flag = flag.trim();
        for (int i = 0; i < rules.length; i++) {
            if (flag.equals(rules[i].trim()))
                return true;
        }
        return false;
    }

    // public String getXmlProp(String fDir, String name) {
    // String prop = "";
    // try {
    // // 创建读入对象
    // SAXReader reader = new SAXReader();
    // // 创建document实例
    // Document doc = reader.read(fDir);
    // // 查找节点emp下的id属性
    // List listAttr = doc.selectNodes(name); //
    // /Server/Service/Engine/Host/Context/@docBase"
    // Iterator itAttr = listAttr.iterator();
    // while (itAttr.hasNext()) {
    // Attribute attr = (Attribute) itAttr.next();
    // prop = attr.getValue();
    // }
    // return prop;
    //
    // } catch (Exception ez) {
    // // TODO Auto-generated catch block
    // ez.printStackTrace();
    // return "";
    // }
    // }


    // 字符拼串， spe为间隔符
    public static String getS(String msg, String str, String spe) {
        if (CommMethod.isEmpty(msg))
            return str;
        else if (CommMethod.isEmpty(str))
            return msg;
        else
            return msg + spe + str;
    }

    // 字符拼串， spe为间隔符
    public static String getS(Object o_msg, Object o_str, String spe) {
        String msg = CommMethod.nvl(o_msg);
        String str = CommMethod.nvl(o_str);
        if (CommMethod.isEmpty(msg))
            return str;
        else if (CommMethod.isEmpty(str))
            return msg;
        else
            return msg + spe + str;
    }

    // 字符拼串， spe为间隔符
    public static String getS(Object o_msg, Object o_str, String spe, String ifnull) {
        String msg = CommMethod.nvl(o_msg);
        String str = CommMethod.nvl(o_str, ifnull);
        if (CommMethod.isEmpty(msg))
            return str;
        else if (CommMethod.isEmpty(str))
            return msg;
        else
            return msg + spe + str;
    }


    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    public static String getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

    public static void delCookieByName(HttpServletRequest request,
                                       HttpServletResponse response, String name) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            try {
                for (Cookie cookie : cookies) {
                    if (name.equals(cookie.getName())) {
                        Cookie cookie_del = new Cookie(cookie.getName(), null);
                        cookie_del.setMaxAge(0);
                        cookie_del.setPath("/");// 根据你创建cookie的路径进行填写
                        response.addCookie(cookie_del);

                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("清空Cookies发生异常！");
            }

        }

    }

    /**
     * 设置cookie
     *
     * @param response
     * @param name     cookie名字
     * @param value    cookie值
     * @param maxAge   cookie生命周期 以秒为单位
     */
    public static void addCookie(HttpServletResponse response, String name,
                                 String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0)
            cookie.setMaxAge(maxAge);

        response.addCookie(cookie);

    }

	/*
	 * 对数据进行大小排序、大-->小 mapKey 按照哪个字段排序 keyType排序字段的类型 sortType :ASC还是desc
	 */
//	private String mapKey = "";
//	private String __keyType = "";
//	private String sortType = "";

    public List<Map<String, String>> sortListData(
            List<Map<String, String>> list, final String mapKey, final String keyType,
            final String sortType) {
//		System.out.println("对数据进行排序");
        if (list != null && list.size() > 0) {
            String key = mapKey;
            Comparator<Map<String, String>> mapComprator = new Comparator<Map<String, String>>() {
                @Override
                public int compare(Map<String, String> o1,
                                   Map<String, String> o2) {
                    // do compare.
                    int yesVal = 1;
                    int noVal = -1;
                    if ("desc".equals(StringUtils.lowerCase(sortType))) {
                        yesVal = 1;
                        noVal = -1;
                    } else {
                        yesVal = -1;
                        noVal = 1;
                    }

                    int retVal = noVal;
                    String o1_key = String.valueOf(o1.get(mapKey));
                    String o2_key = String.valueOf(o2.get(mapKey));
                    if ("int".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "0");
                        o2_key = CommMethod.nvl(o2_key, "0");
                        if (Integer.valueOf(o1_key) < Integer.valueOf(o2_key)) {
                            retVal = yesVal;
                        }
                    } else if ("String".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "");
                        o2_key = CommMethod.nvl(o2_key, "");
                        if (o1_key.compareTo(o2_key) < 0) {
                            retVal = yesVal;
                        }
                    } else if ("float".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "0");
                        o2_key = CommMethod.nvl(o2_key, "0");
                        if (Float.valueOf(o1_key) < Float.valueOf(o2_key)) {
                            retVal = yesVal;
                        }
                    } else if ("long".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "0");
                        o2_key = CommMethod.nvl(o2_key, "0");
                        if (Long.valueOf(o1_key) < Long.valueOf(o2_key)) {
                            retVal = yesVal;
                        }
                    }
                    return retVal;
                }
            };
            Collections.sort(list, mapComprator);
        } else {
            new Exception("排序没有取到数据");
        }
        return list;
    }
	
	
	/*
	 * 对数据进行大小排序、大-->小 mapKey 按照哪个字段排序 keyType排序字段的类型 sortType :ASC还是desc
	 */

    public List<Map<String, Object>> sortList(
            List<Map<String, Object>> list, final String mapKey, final String keyType,
            final String sortType) {
//		System.out.println("对数据进行排序");
        if (list != null && list.size() > 0) {
            String key = mapKey;
            Comparator<Map<String, Object>> mapComprator = new Comparator<Map<String, Object>>() {
                @Override
                public int compare(Map<String, Object> o1,
                                   Map<String, Object> o2) {
                    // do compare.
                    int yesVal = 1;
                    int noVal = -1;
                    if ("desc".equals(StringUtils.lowerCase(sortType))) {
                        yesVal = 1;
                        noVal = -1;
                    } else {
                        yesVal = -1;
                        noVal = 1;
                    }

                    int retVal = noVal;
                    String o1_key = String.valueOf(o1.get(mapKey));
                    String o2_key = String.valueOf(o2.get(mapKey));
                    if ("int".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "0");
                        o2_key = CommMethod.nvl(o2_key, "0");
                        if (Integer.valueOf(o1_key) < Integer.valueOf(o2_key)) {
                            retVal = yesVal;
                        }
                    } else if ("String".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "");
                        o2_key = CommMethod.nvl(o2_key, "");
                        if (o1_key.compareTo(o2_key) < 0) {
                            retVal = yesVal;
                        }
                    } else if ("float".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "0");
                        o2_key = CommMethod.nvl(o2_key, "0");
                        if (Float.valueOf(o1_key) < Float.valueOf(o2_key)) {
                            retVal = yesVal;
                        }
                    } else if ("long".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "0");
                        o2_key = CommMethod.nvl(o2_key, "0");
                        if (Long.valueOf(o1_key) < Long.valueOf(o2_key)) {
                            retVal = yesVal;
                        }
                    }
                    return retVal;
                }
            };
            Collections.sort(list, mapComprator);
        } else {
            new Exception("排序没有取到数据");
        }
        return list;
    }

	/*
	 * 对数据进行大小排序、大-->小 mapKey 按照哪个字段排序 keyType排序字段的类型 sortType :ASC还是desc
	 */

    public List<Map> sortTheListData(List<Map> list, final String mapKey,
                                     final String keyType, final String sortType) {
//		System.out.println("对数据进行排序");
        if (list != null && list.size() > 0) {
            String key = mapKey;
            Comparator<Map> mapComprator = new Comparator<Map>() {
                @Override
                public int compare(Map o1, Map o2) {
                    // do compare.
                    int yesVal = 1;
                    int noVal = -1;
                    if ("desc".equals(StringUtils.lowerCase(sortType))) {
                        yesVal = 1;
                        noVal = -1;
                    } else {
                        yesVal = -1;
                        noVal = 1;
                    }

                    int retVal = noVal;
                    String o1_key = String.valueOf(o1.get(mapKey));
                    String o2_key = String.valueOf(o2.get(mapKey));
                    if ("int".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "0");
                        o2_key = CommMethod.nvl(o2_key, "0");
                        if (Integer.valueOf(o1_key) < Integer.valueOf(o2_key)) {
                            retVal = yesVal;
                        }
                    } else if ("String".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "");
                        o2_key = CommMethod.nvl(o2_key, "");
                        if (o1_key.compareTo(o2_key) < 0) {
                            retVal = yesVal;
                        }
                    } else if ("float".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "0");
                        o2_key = CommMethod.nvl(o2_key, "0");
                        if (Float.valueOf(o1_key) < Float.valueOf(o2_key)) {
                            retVal = yesVal;
                        }
                    } else if ("long".equals(keyType)) {
                        o1_key = CommMethod.nvl(o1_key, "0");
                        o2_key = CommMethod.nvl(o2_key, "0");
                        if (Long.valueOf(o1_key) < Long.valueOf(o2_key)) {
                            retVal = yesVal;
                        }
                    }
                    return retVal;
                }
            };
            Collections.sort(list, mapComprator);
        } else {
            new Exception("排序没有取到数据");
        }
        return list;
    }


    public static void putMap(Map map) {
        map.put("test", "test_val");
    }

    // list排序测试
    public static void main(String[] args) {


        String ttt = "2014-09-09";
        ttt = CommMethod.strDate2fmt(ttt, "yyyy-MM-dd", "yyyyMMdd");


        System.out.println(ttt + "---------" + ttt);


        if (1 == 1) return;
        String atc_id = "CE_10001";
        atc_id = atc_id.substring(atc_id.indexOf("_") + 1);
        System.out.println("---------" + atc_id);

        List list = new ArrayList();

        CommMethod comm = new CommMethod();
        for (int i = 0; i < 5; i++) {
            Map map = new HashMap();
            String val = String.valueOf(i);
            // list2.add(Integer.parseInt(val));
            map.put("name", val);
            list.add(map);
        }
        //Map map = new HashMap();


        list = comm.sortTheListData(list, "name", "int", "desc");
        // map.put("data", list2);
        // List list = (List)map.get("data");

        // 创建一个逆序的比较器
        Comparator r = Collections.reverseOrder();
        // 通过逆序的比较器进行排序
        // Collections.sort(list,r);
        //
        // for(int i = 0; i<list.size(); i++){
        // System.out.println(list.get(i));
        // }
        //
        // //打乱顺序
        // Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 输出最大和最小的数
        System.out.println(Collections.max(list) + ":" + Collections.min(list));
    }

    public static boolean isNotBlank(String str) {
        if (str == null)
            return false;
        if ("".equals(str.trim()))
            return false;
        if ("null".equalsIgnoreCase(str))
            return false;
        return true;
    }

    public static boolean isNotEmpty(String str) {
        if (str == null || "".equals(str.trim()) || "null".equalsIgnoreCase(str))
            return false;

        return true;
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null)
            return true;
        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        if (obj == null)
            return false;
        return true;
    }

    public static boolean isEmpty(Map map) {
        if (map == null || map.size() == 0)
            return true;
        return false;
    }

    public static boolean isNotEmpty(Map map) {
        if (map == null || map.size() == 0)
            return false;
        return true;
    }


    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim()) || "null".equalsIgnoreCase(str))
            return true;

        return false;
    }


    public static boolean isEmpty(List list) {
        if (list == null || list.size() == 0) return true;

        return false;
    }

    public static boolean isNotEmpty(List list) {
        if (list == null) return false;
        if (list.size() == 0) return false;

        return true;
    }


    public static Date str2Date(String date, String format) {
        if (CommMethod.isEmpty(date)) return null;
        format = CommMethod.nvl(format, "yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf;
        if (CommMethod.isNotEmpty(format)) sdf = new SimpleDateFormat(format);
        else sdf = new SimpleDateFormat();

        Date new_date = null;
        try {
            new_date = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new_date;
    }

    public static Long strDate2Long(String date, String format) {
        if (CommMethod.isEmpty(date)) return null;
        format = CommMethod.nvl(format, "yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf;
        if (CommMethod.isNotEmpty(format)) sdf = new SimpleDateFormat(format);
        else sdf = new SimpleDateFormat();

        Date new_date = null;
        try {
            new_date = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (new_date != null) return new_date.getTime();
        else return null;
    }

    public static String strDate2fmt(String date, String infmt, String outfmt) {
        if (CommMethod.isEmpty(date)) return "";
        outfmt = CommMethod.nvl(outfmt, "yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat(infmt);

        Date new_date = null;
        try {
            new_date = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        sdf = new SimpleDateFormat(outfmt);
        if (new_date != null) return sdf.format(new_date);
        else return "";
    }

    /*获得当前时间格式 */
    public static String getCurrDateFmt(String format) {
        return (new SimpleDateFormat(format)).format(new
                Date());
    }

    /*获得和目标时间对比的某一天   减天数， 用负数 */
    public static Date getDateFromFixDate(Date fixDate, int days) {
        return new Date(fixDate.getTime() + days * 24 * 3600 * 1000l);
    }

    /*获得和目标时间对比的某一天   减天数， 用负数 */
    public static String getDateFromFixDate(String fixDatestr, int days, String out_datefmt) {
        Date fixDate = str2Date(fixDatestr, out_datefmt);
        Date date = new Date(fixDate.getTime() + days * 24 * 3600 * 1000l);
        String ret_date = dateObj2Str(date, out_datefmt);
        return ret_date;
    }

    /*
     * 获取输入日期所在月的最后一天    mon   1-下月最后1天    0-本月最后1天   -1上月最后一天
     */
    public static Date lastDayOfMonth(Date date, int mon) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
//	        cal.set(Calendar.DAY_OF_MONTH, 1);
        //获取上月：
        cal.add(Calendar.MONTH, mon);
//	        cal.add(Calendar.DATE, mon);
        //得到一个月最后一天日期(31/30/29/28)
        int MaxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //按你的要求设置时间
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), MaxDay, 23, 59, 59);
//	        //按格式输出
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	        String gtime = sdf.format(c.getTime()); //上月最后一天
        return cal.getTime();
    }

    public static String lastDayOfMonth(String datestr, int mon, String infmt, String outfmt) {
        Date date = str2Date(datestr, infmt);
        date = lastDayOfMonth(date, mon);

        datestr = dateObj2Str(date, outfmt);
        return datestr;
    }

    /*获得和目标时间对比的某一秒   减秒数， 用负数 */
    public static Date getSecFromFixDate(Date fixDate, int sec) {
        return new Date(fixDate.getTime() + sec * 1000l);
    }

    /* 时间转换成规定STRING格式 */
    public static String getStrOnDateFormat(String str, String fomart) {

        SimpleDateFormat df = new SimpleDateFormat(fomart);
        if (CommMethod.isEmpty(str)) return "";
        try {
            str = String.valueOf(df.format(df.parse(str)));

        } catch (Exception ex) {
            ex.printStackTrace();
//			  System.out.println("***** CommFun Dateformat str Exception");
        }
        return str;

    }


    public static String dateObj2Str(Object dateObj, String datefmt) {

        if (dateObj == null) {
            return "";
        }
        if (dateObj instanceof Date) {
            SimpleDateFormat df = new SimpleDateFormat(datefmt);
            return df.format(dateObj);
        } else {
            return CommMethod.nvl(dateObj);
        }
    }


    /**
     * <p>类似oracle  nvl函数 Object转String ,空字符串返回 ifNull, 非空返回自己</p>	.
     *
     * @throws Exception
     * @returnS
     */
    public static String nvl(Object obj, String ifNull) {
        String str = String.valueOf(obj);
        if (str == null) return ifNull;
        str = str.trim();
        if (str.equals("") || "null".equals(str)) {
            return ifNull;
        } else {
            return str;
        }
    }


    /**
     * <p>Object转String ,空字符串返回ifNull, 非空返回自己</p>	.
     *
     * @throws Exception
     * @returnS
     */
    public static String nvl(String str, String ifNull) {
        if (str == null) return ifNull;
        str = str.trim();
        if (str.equals("") || "null".equals(str)) {
            return ifNull;
        } else {
            return str;
        }
    }

    /**
     * <p>Object转String ,空字符串返回"", 非空返回自己</p>	.
     *
     * @throws Exception
     * @returnS
     */
    public static String nvl(Object obj) {
        String ifNull = "";
        String str = String.valueOf(obj);
        if (str == null) return ifNull;
        str = str.trim();
        if (str.equals("") || "null".equals(str)) {
            return ifNull;
        } else {
            return str;
        }
    }

    /**
     * <p>空字符串返回"", 非空返回自己</p>	.
     *
     * @throws Exception
     * @returnS
     */
    public static String nvl(String str) {
        String ifNull = "";
        if (str == null) return ifNull;
        str = str.trim();
        if (str.equals("") || "null".equals(str)) {
            return ifNull;
        } else {
            return str;
        }
    }


    /**
     * <p>类似oracle  nvl2函数 Object转String ,空字符串返回 ifNull, 非空返回notNull</p>	.
     *
     * @throws Exception
     * @returnS
     */
    public static String nvl2(Object obj, String ifNull, String notNull) {
        String str = String.valueOf(obj);
        if (str == null) return ifNull;
        str = str.trim();
        if (str.equals("") || "null".equals(str)) {
            return ifNull;
        } else {
            return notNull;
        }
    }

    /**
     * <p>Object转String ,空字符串返回ifNull, 非空返回自己</p>	.
     *
     * @throws Exception
     * @returnS
     */
    public static String nvl2(String str, String ifNull, String notNull) {
        if (str == null) return ifNull;
        str = str.trim();
        if (str.equals("") || "null".equals(str)) {
            return ifNull;
        } else {
            return notNull;
        }
    }

    public static String decode(String str, String ifval, String thenval, String elseval) {
        String ret = "";
        if (str.equals(ifval)) {
            return thenval;
        } else {
            return elseval;
        }
    }

    /**
     * 返回指定长度字符串
     *
     * @param str
     * @param fixlen
     * @return
     */
    public static String getStringByFixLen(String str, int fixlen) {
        if (CommMethod.isEmpty(str)) return "";
        if (str.length() > fixlen) {
            return str.substring(0, fixlen);
        } else {
            return str;
        }
    }

    public static String trim(String str) {
        if (str == null) return "";
        return str.trim();
    }

    /**
     * <p>根据健值数据生成map.
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getMapByArr(String[] keyArr, Object[] valArr) {
        Map<String, Object> kvMap = new HashMap<String, Object>();
        if (keyArr != null && valArr != null) {
            int row = 0;
            for (String key : keyArr) {
                kvMap.put(key, valArr[row]);
                row++;
            }
        }

        return kvMap;
    }

    /**
     * <p>根据健值数据生成map.
     *
     * @return
     * @throws Exception
     */
    public static List<Object> getFmtArrByKV(String[] keyArr, Object[] valArr, Map<String, String> colFmtMap) {
        List<Object> ls = new ArrayList<Object>();
        try {
            if (keyArr != null && valArr != null) {
                int row = 0;
                String fmval = "";
                String colValStr = "";
                Object colValObj = null;
                for (String key : keyArr) {
                    fmval = colFmtMap.get(key);
                    colValStr = CommMethod.nvl(valArr[row]);
                    colValObj = colValStr;
//					if ( "null".equals(String.valueOf(colValObj)) ) {//导出文本的空值为 null 字符串，处理为空对象
//						colValObj = null;
//					}

                    if (CommMethod.isNotEmpty(colValStr) && CommMethod.isNotEmpty(fmval)) {
                        if ("str2date".equals(fmval)) { //to_date('29-09-2013 15:41:43.0', 'dd-mm-yyyy hh24:mi:ss'), oracle un do
                            colValObj = colValStr.substring(0, colValStr.lastIndexOf("."));
                        } else {
                            // to do in future
                        }
                    }
                    ls.add(colValObj);
                    row++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ls;
    }

    /**
     * <p>Object数组针对指定值替换.
     *
     * @return
     * @throws Exception
     */
    public static void mapValFmtBy(Map<String, Object> colMap, Map<String, String> colFmtMap) {
//		List<Object> ls = new ArrayList<Object>();
        if (colMap != null && colFmtMap != null) {
            //根据规则格式化map
            Iterator iter = colFmtMap.entrySet().iterator();
            String fmkey = "";
            String fmval = "";
            Object colValObj = "";
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                fmkey = CommMethod.nvl(entry.getKey());
                fmval = CommMethod.nvl(entry.getValue());
                colValObj = colMap.get(fmkey);
                if (colValObj != null && CommMethod.isNotEmpty(fmval)) {
                    if ("str2date".equals(fmval)) {
                        colValObj = CommMethod.strDate2Long(CommMethod.nvl(colValObj), "");
                        colMap.put(fmkey, colValObj);
                    } else {
                        // to do in future
                    }
                }
            }

        }
//		return ls;
    }

    public static List<Object> map2ObjectArr(Map<String, Object> colMap) {
        List<Object> ls = new ArrayList<Object>();
        if (colMap != null) {
            Iterator iter = colMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                ls.add(entry.getValue());
            }

        }
        return ls;
    }

    /**
     * <p>针对 insert into ?,?,?
     *
     * @return
     * @throws Exception
     */
    public static String arrReplace2DbStr(Object[] objArr, Map<String, String> fmtMap) {
        StringBuffer ret = new StringBuffer();
        if (objArr != null) {
            int row = 0;
            for (Object obj : objArr) {
                String replace = fmtMap.get(obj);
                obj = CommMethod.nvl2(replace, "?", replace);


                if (row == 0) ret.append(obj);
                else ret.append(",").append(obj);
                row++;
            }
        }
        return ret.toString();
    }


    /**
     * <p>Object数组针对指定值替换.
     *
     * @return
     * @throws Exception
     */
    public static Map<String, String> getColIdxMapBy(Object[] objArr) {
        Map<String, String> colIdxMap = new HashMap<String, String>();
        if (objArr != null) {
            int row = 0;
            for (Object obj : objArr) {
                colIdxMap.put(row + "", CommMethod.nvl(obj));
                row++;
            }
        }
        return colIdxMap;
    }


    //支持大小写
    public static String getColsByList(List<Map<String, Object>> list, String colName, String spe, String ifnull) {
        String cols = "";

        if (CommMethod.isNotEmpty(list)) {
            String dbVal = "";
            for (Map<String, Object> dbMap : list) {
                dbVal = CommMethod.nvl(dbMap.get(colName.toUpperCase()), CommMethod.nvl(dbMap.get(colName.toLowerCase())));
                dbVal = CommMethod.nvl(dbVal, ifnull);

                cols = CommMethod.getS(cols, dbVal, spe);
//				if ( CommMethod.isEmpty(cols)) cols = dbVal;
//				else cols += spe + dbVal;
            }
        }

        return cols;
    }

    //支持大小写    '', '', '' 的格式
    public static String getDbInColsByList(List<Map<String, Object>> list, String colName, String ifnull) {
        String cols = "";

        if (CommMethod.isNotEmpty(list)) {
            String dbVal = "";
            for (Map<String, Object> dbMap : list) {
                dbVal = CommMethod.nvl(dbMap.get(colName.toUpperCase()), CommMethod.nvl(dbMap.get(colName.toLowerCase())));
                dbVal = CommMethod.nvl(dbVal, ifnull);

                if (CommMethod.isEmpty(cols)) cols = "'" + dbVal + "'";
                else cols += ",'" + dbVal + "'";
            }
        }

        return cols;
    }


    /*
     * Map<String, String> ==> Map<String, Object> map
     */
    public static Map<String, Object> mapFormat2Obj(Map<String, String> map) {
        Map<String, Object> retMap = new HashMap<String, Object>();

        if (map != null) {
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                retMap.put(key.toString(), entry.getValue());
            }
        }
        return retMap;
    }

    public static List<Map<String, Object>> listStringMap2ObjectMap(List<Map<String, String>> listStringMap) {
        if (listStringMap == null) return null;
        List<Map<String, Object>> listObjectMap = new ArrayList<Map<String, Object>>();
        for (Iterator<Map<String, String>> iter = listStringMap.iterator(); iter.hasNext(); ) {
            listObjectMap.add(mapFormat2Obj(iter.next()));
        }
        return listObjectMap;
    }

    /**
     * 验证map的key对应的值是否为空，输入一个字符串数组，判断只要1个为空，则返回该key，
     * 都不为空返回  0
     * 输入参数keys ，逗号分隔
     */
    public static String chkMapFixsKeyIsEmpty(Map<String, Object> map, String keys) {
        List<String> keyList = CommMethod.str2List(keys, ",");
        String objval = "";
        for (String key : keyList) {
            objval = CommMethod.nvl(map.get(key));
            if (CommMethod.isEmpty(objval)) {
                return key;
            }
        }
        return "0";
    }

    /**
     * 往map写入值，如果未空则不写入
     *
     * @return
     */
    public static Map<String, Object> map4putObj(Map<String, Object> output_map, String key, String val) {
        if (CommMethod.isNotEmpty(val)) {
            output_map.put(key, val);
        }
        return output_map;
    }

    /*
     * Map<String, Object> ==> Map<String, String> map
     */
    public static Map<String, String> mapFormat2Str(Map<String, Object> map) {
        Map<String, String> retMap = new HashMap<String, String>();

        if (map != null) {
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                retMap.put(key.toString(), CommMethod.nvl(entry.getValue()));
            }
        }
        return retMap;
    }

    /*
     * Map<String, Object> ==> Map key to lowerCase
     */
    public static Map<String, Object> mapKeyToLower(Map<String, Object> map) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        if (map != null) {
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                if (CommMethod.nvl(key).equals("")) continue;
                retMap.put(key.toString().toLowerCase(), entry.getValue());
            }
            //map = retMap;
        }
        return retMap;
    }

    /*
     * Map<String, Object> ==> Map key to lowerCase
     */
    public static Map mapKeyToUpper(Map map) {
        Map retMap = new HashMap();
        if (map != null) {
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                if (CommMethod.nvl(key).equals("")) continue;
                retMap.put(key.toString().toUpperCase(), entry.getValue());
            }
            //map = retMap;
        }
        return retMap;
    }

    /*
     * Map<String, Object> ==> easyui prop_grid
     * Map<String, Object> matchNameMap (name, value, group , editor)
     */
    public static List<Map<String, Object>> mapToPropGrid(Map<String, Object> map, Map<String, Object> matchMap) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (map != null) {
            Iterator iter = map.entrySet().iterator();
            Map<String, Object> propMap = null;
            while (iter.hasNext()) {
                propMap = new HashMap<String, Object>();
                Map.Entry entry = (Map.Entry) iter.next();
                String key = entry.getKey().toString();
                Object valueObj = entry.getValue();

                Object matchObj = matchMap.get(key);
                if (CommMethod.isNotEmpty(matchObj)) {
                    Map<String, Object> matchObjMap = (Map<String, Object>) matchObj;
                    propMap.put("name", matchObjMap.get("name"));
                    propMap.put("value", valueObj);
                    propMap.put("group", matchObjMap.get("group"));
                    propMap.put("editor", matchObjMap.get("editor"));
                    list.add(propMap);
                }
                // prop
            }
            //map = retMap;
        }
        return list;
    }

    public static List<Map<String, Object>> listMapKeyToLower(List<Map<String, Object>> list) {
        List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
        if (CommMethod.isNotEmpty(list)) {
            for (Map<String, Object> map : list) {
                map = CommMethod.mapKeyToLower(map);
                retList.add(map);
            }
        }
        return retList;
    }

    /**
     * 连接字符串转为 list
     *
     * @param str
     * @param spt_c 分割符号
     * @return list
     * @throws Exception
     */
    public static List<String> str2List(String str, String spt_c) {
        List<String> retList = new ArrayList<String>();
        String[] arr = str.split(spt_c);
        for (String code : arr) {
            code = CommMethod.nvl(code);
            if (CommMethod.isNotEmpty(code)) retList.add(code);
        }
        return retList;
    }

    /**
     * 连接字符串转为 list
     *
     * @param str
     * @param spt_c 分割符号
     * @return list
     * @throws Exception
     */
    public static List<String> str2ListNoRepeat(String str, String spt_c) {
        List<String> retList = new ArrayList<String>();
        String[] arr = str.split(spt_c);
        for (String code : arr) {
            code = CommMethod.nvl(code);
            if (CommMethod.isNotEmpty(code)) {
                if (!retList.contains(code)) {
                    retList.add(code);
                }
            }
        }
        return retList;
    }


    public static String list2Str(List<String> stringList, String spt_c) {
        if (stringList == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList) {
            if (flag) {
                result.append(spt_c);
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }


    public static boolean strsContains(String strs, String str, String spt_c) {
        boolean has = false;
        if (CommMethod.isEmpty(strs) || CommMethod.isEmpty(str)) {
            return false;
        }
        strs = strs.toUpperCase();
        str = str.toUpperCase();
        List<String> retList = str2List(strs, spt_c);
        if (CommMethod.isNotEmpty(retList) && retList.contains(str)) {
            has = true;
        }
        return has;
    }

    /**
     * 取出匹配到的 片段
     *
     * @param str
     * @return String
     * @throws Exception
     */
    public static String getRegExStrBy(String regEx, String str) {
        String ret = "";
//		String regEx =  "(B09.9AA)"; 
//        String str = "B09.9AA,M09.9AA,A09.9AA";//M09.9AA
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(str);
        boolean rs = mat.find();
        if (rs) {
            ret = mat.group();
        }
        return ret;
    }


    public static String replace(String s, char oldSub, char newSub) {
        return replace(s, oldSub, new Character(newSub).toString());
    }

    public static String replace(String s, char oldSub, String newSub) {
        if ((s == null) || (newSub == null)) {
            return null;
        }

        char[] c = s.toCharArray();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == oldSub) {
                sb.append(newSub);
            } else {
                sb.append(c[i]);
            }
        }

        return sb.toString();
    }

    public static String replace(String s, String oldSub, String newSub) {
        if ((s == null) || (oldSub == null) || (newSub == null)) {
            return null;
        }

        int y = s.indexOf(oldSub);

        if (y >= 0) {
            StringBuffer sb = new StringBuffer();

            int length = oldSub.length();
            int x = 0;

            while (x <= y) {
                sb.append(s.substring(x, y));
                sb.append(newSub);
                x = y + length;
                y = s.indexOf(oldSub, x);
            }

            sb.append(s.substring(x));
            s = sb.toString();
            return s;
        } else {
            return s;
        }
    }

    public static String replace(String s, String[] oldSubs, String newSub) {
        if ((s == null) || (oldSubs == null) || (newSub == null)) {
            return null;
        }
        for (int i = 0; i < oldSubs.length; i++) {
            String oldSub = oldSubs[i];
            int y = s.indexOf(oldSub);

            if (y >= 0) {
                StringBuffer sb = new StringBuffer();

                int length = oldSub.length();
                int x = 0;

                while (x <= y) {
                    sb.append(s.substring(x, y));
                    sb.append(newSub);
                    x = y + length;
                    y = s.indexOf(oldSub, x);
                }

                sb.append(s.substring(x));
                s = sb.toString();
            } else {
                continue;
            }
        }
        return s;
    }

    public static String replaceFirst(String s, String oldSub, String newSub) {
        if ((s == null) || (oldSub == null) || (newSub == null)) {
            return null;
        }

        int y = s.indexOf(oldSub);

        if (y >= 0) {
            StringBuffer sb = new StringBuffer();
            int length = oldSub.length();
            int x = 0;

            if (x <= y) {
                sb.append(s.substring(x, y));
                sb.append(newSub);
                x = y + length;
            }

            sb.append(s.substring(x));
            s = sb.toString();
            return s;
        } else {
            return s;
        }
    }

    /**
     * 返回当前日期的字符串
     *
     * @param format 日期格式
     * @return
     */
    public static String getCurrDateByFormat(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 过滤回车换行等特殊字符  替换为空格，AI问题单数据的过滤
     *
     * @param str
     * @return
     */
    public static String cleanNonChar(String str) {
        str = CommMethod.nvl(str);
        str = str.replaceAll("(\r\n|\r|\n|\n\r)", " ");
        return str;
    }


    /**
     * 过滤回车换行等特殊字符  替换为空
     *
     * @param str
     * @return
     */
    public static String cleanNonChar2Trim(String str) {
        str = CommMethod.nvl(str);
        str = str.replaceAll("(\r\n|\r|\n|\n\r|\t)", "");
        return str;
    }


    public static String getTreeId(String tree_id) {
        if (tree_id == null) return null;
        String[] treeArr = tree_id.split("_");
        if (treeArr.length > 1) {
            return treeArr[1];
        }
        return tree_id;
    }

    public static String TimeStamp2Date(String timestampString, String formats) {
        Long timestamp = Long.parseLong(timestampString);
        String date = new SimpleDateFormat(formats).format(new Date(timestamp));
        return date;
    }
}
