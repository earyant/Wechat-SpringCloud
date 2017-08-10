package com.earyant.wechatitchat4jprovider.itchat4j.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.earyant.wechatitchat4jprovider.dao.User;
import com.earyant.wechatitchat4jprovider.dao.repository.UserRepository;
import com.earyant.wechatitchat4jprovider.itchat4j.beans.BaseMsg;
import com.earyant.wechatitchat4jprovider.itchat4j.core.MsgCenter;
import com.earyant.wechatitchat4jprovider.itchat4j.service.ILoginService;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.MyHttpClient;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.SleepUtils;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.ResultEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.RetCodeEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.StorageLoginInfoEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.URLEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.parameters.LoginParaEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.parameters.StatusNotifyParaEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.enums.parameters.UUIDParaEnum;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.tools.CommonTools;
import com.earyant.wechatitchat4jprovider.utils.JedisUtil;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;

/**
 * 登陆服务实现类
 *
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 创建时间：2017年5月13日 上午12:09:35
 */
@Service
public class LoginServiceImpl implements ILoginService {
    private static Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;
    //    @Autowired
//    RedisServiceImpl<List<User>> userRedisService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public LoginServiceImpl() {

    }

    @Override
    public boolean login(User user) {
        boolean isLogin = false;
        // 组装参数和URL
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair(LoginParaEnum.LOGIN_ICON.para(), LoginParaEnum.LOGIN_ICON.value()));
        params.add(new BasicNameValuePair(LoginParaEnum.UUID.para(), user.getUuid()));
        params.add(new BasicNameValuePair(LoginParaEnum.TIP.para(), LoginParaEnum.TIP.value()));

        // long time = 4000;
        while (!isLogin) {
            // SleepUtils.sleep(time += 1000);
            long millis = System.currentTimeMillis();
            params.add(new BasicNameValuePair(LoginParaEnum.R.para(), String.valueOf(millis / 1579L)));
            params.add(new BasicNameValuePair(LoginParaEnum._.para(), String.valueOf(millis)));

            try {
                String result = restTemplate.getForObject(URLEnum.LOGIN_URL.getUrl(), String.class, params);
                LOG.info("login result : "+result);
                String status = checklogin(result);
                if (ResultEnum.SUCCESS.getCode().equals(status)) {
                    processLoginInfo(result, user.getWechatId()); // 处理结果
                    isLogin = true;
                    user.setAlive(isLogin);
                    userRepository.save(user);
                    JedisUtil je =JedisUtil.getRu();
                    je.lpush("user",user.toString());
                    System.out.println("登录成功！！！！");
                    break;
                }
                if (ResultEnum.WAIT_CONFIRM.getCode().equals(status)) {
                    LOG.info("请点击微信确认按钮，进行登陆");
                }

            } catch (Exception e) {
                LOG.error("微信登陆异常！", e);
            }
        }
        return isLogin;
    }

    @Override
    public String getUuid(String wechatId) {
        User user = new User();
        // 组装参数和URL
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair(UUIDParaEnum.APP_ID.para(), UUIDParaEnum.APP_ID.value()));
        params.add(new BasicNameValuePair(UUIDParaEnum.FUN.para(), UUIDParaEnum.FUN.value()));
        params.add(new BasicNameValuePair(UUIDParaEnum.LANG.para(), UUIDParaEnum.LANG.value()));
        params.add(new BasicNameValuePair(UUIDParaEnum._.para(), String.valueOf(System.currentTimeMillis())));

//        try {
//            String result = restTemplate.getForObject(URLEnum.UUID_URL.getUrl(), String.class, params);
        MyHttpClient myHttpClient = MyHttpClient.getInstance();
        HttpEntity entity = myHttpClient.doGet(URLEnum.UUID_URL.getUrl(), params, true, null);

        try {
            String result = EntityUtils.toString(entity);
            System.out.println("get qr result   " + result);
            String regEx = "window.QRLogin.code = (\\d+); window.QRLogin.uuid = \"(\\S+?)\";";
            Matcher matcher = CommonTools.getMatcher(regEx, result);
            if (matcher.find()) {
                if ((ResultEnum.SUCCESS.getCode().equals(matcher.group(1)))) {
                    user.setUuid(matcher.group(2));
                    user.setWechatId(wechatId);
                    user.setCreateTime(LocalDateTime.now().toString());
                    userRepository.save(user);
//                    redisTemplate.opsForList().rightPush("user", user);
                    JedisUtil je = JedisUtil.getRu();
                    je.lpush("user", JSON.toJSONString(user));
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        return user.getUuid();
    }

    @Override
    public String getQR(String qrPath, String wechatId) {
        User user = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(wechatId);
        qrPath = qrPath + File.separator + "QR.jpg";
        String qrUrl = URLEnum.QRCODE_URL.getUrl() + user.getUuid();
        MyHttpClient myHttpClient = MyHttpClient.getInstance();
        HttpEntity entity = myHttpClient.doGet(qrUrl, null, true, null);
        try {
            OutputStream out = new FileOutputStream(qrPath);
            byte[] bytes = EntityUtils.toByteArray(entity);
            out.write(bytes);
            out.flush();
            out.close();
            try {
//				CommonTools.printQr(qrPath); // 打开登陆二维码图片
            } catch (Exception e) {
                LOG.info(e.getMessage());
            }

        } catch (Exception e) {
            LOG.info(e.getMessage());
            return qrPath;
        }

        return qrPath;
    }

    @Override
    public boolean webWxInit(String wechatId) {
//        User core = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(wechatId);
//        core.setAlive(true);
//        core.setLastNormalRetcodeTime(System.currentTimeMillis());
//        // 组装请求URL和参数
//        String url = String.format(URLEnum.INIT_URL.getUrl(),
//                core.getUrl(),
//                String.valueOf(System.currentTimeMillis() / 3158L),
//                core.getPass_ticket());
//
//        Map<String, Object> paramMap = getParamMap();
//
//        // 请求初始化接口
//        MyHttpClient myHttpClient = MyHttpClient.getInstance();
//        HttpEntity entity = myHttpClient.doPost(url, JSON.toJSONString(paramMap));
//        try {
//            String result = EntityUtils.toString(entity, Consts.UTF_8);
//            JSONObject obj = JSON.parseObject(result);
//
//            JSONObject user = obj.getJSONObject(StorageLoginInfoEnum.User.getKey());
//            JSONObject syncKey = obj.getJSONObject(StorageLoginInfoEnum.SyncKey.getKey());
//
//            core.setInviteStartCount(obj.getInteger(StorageLoginInfoEnum.InviteStartCount.getKey()));
//            core.setSyncKey(String.valueOf(syncKey));
//
//            JSONArray syncArray = syncKey.getJSONArray("List");
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < syncArray.size(); i++) {
//                sb.append(syncArray.getJSONObject(i).getString("Key") + "_"
//                        + syncArray.getJSONObject(i).getString("Val") + "|");
//            }
//            // 1_661706053|2_661706420|3_661706415|1000_1494151022|
//            String synckey = sb.toString();
//
//            // 1_661706053|2_661706420|3_661706415|1000_1494151022
//            core.setSynckey(synckey.substring(0, synckey.length() - 1));// 1_656161336|2_656161626|3_656161313|11_656159955|13_656120033|201_1492273724|1000_1492265953|1001_1492250432|1004_1491805192
//            core.setUserName(user.getString("UserName"));
//            core.setNickName(user.getString("NickName"));
//            core.setUserSelf(String.valueOf(obj.getJSONObject("User")));
//
//            String chatSet = obj.getString("ChatSet");
//            String[] chatSetArray = chatSet.split(",");
//            List<GroupName> groupNames = new ArrayList<>();
//            for (int i = 0; i < chatSetArray.length; i++) {
//                if (chatSetArray[i].indexOf("@@") != -1) {
//                    // 更新GroupIdList
//                    groupNames.add(new GroupName(chatSetArray[i]));
//
//                }
//            }
//            core.getGroupIdList().addAll(groupNames);
//            userRepository.save(core);
//            // JSONArray contactListArray = obj.getJSONArray("ContactList");
//            // for (int i = 0; i < contactListArray.size(); i++) {
//            // JSONObject o = contactListArray.getJSONObject(i);
//            // if (o.getString("UserName").indexOf("@@") != -1) {
//            // core.getGroupIdList().add(o.getString("UserName")); //
//            // // 更新GroupIdList
//            // core.getGroupList().add(o); // 更新GroupList
//            // core.getGroupNickNameList().add(o.getString("NickName"));
//            // }
//            // }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        return true;
    }

    @Override
    public void wxStatusNotify(String wechatId) {
        User u = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(wechatId);
        // 组装请求URL和参数
        String url = String.format(URLEnum.STATUS_NOTIFY_URL.getUrl(),
                u.getPass_ticket());

        Map<String, Object> paramMap = getParamMap();
        paramMap.put(StatusNotifyParaEnum.CODE.para(), StatusNotifyParaEnum.CODE.value());
        paramMap.put(StatusNotifyParaEnum.FROM_USERNAME.para(), u.getUserName());
        paramMap.put(StatusNotifyParaEnum.TO_USERNAME.para(), u.getUserName());
        paramMap.put(StatusNotifyParaEnum.CLIENT_MSG_ID.para(), System.currentTimeMillis());
        String paramStr = JSON.toJSONString(paramMap);

        try {
            String entity = restTemplate.postForObject(url, paramMap, String.class, paramMap);

        } catch (Exception e) {
            LOG.error("微信状态通知接口失败！", e);
        }

    }

    @Override
    public void startReceiving(String wechatId) {
        User core = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(wechatId);
        core.setAlive(true);
        new Thread(new Runnable() {
            int retryCount = 0;

            @Override
            public void run() {
                while (core.isAlive()) {
                    try {
                        Map<String, String> resultMap = syncCheck(wechatId);
                        LOG.info(JSONObject.toJSONString(resultMap));
                        String retcode = resultMap.get("retcode");
                        String selector = resultMap.get("selector");
                        if (retcode.equals(RetCodeEnum.UNKOWN.getCode())) {
                            LOG.info(RetCodeEnum.UNKOWN.getType());
                            continue;
                        } else if (retcode.equals(RetCodeEnum.LOGIN_OUT.getCode())) { // 退出
                            LOG.info(RetCodeEnum.LOGIN_OUT.getType());
                            break;
                        } else if (retcode.equals(RetCodeEnum.LOGIN_OTHERWHERE.getCode())) { // 其它地方登陆
                            LOG.info(RetCodeEnum.LOGIN_OTHERWHERE.getType());
                            break;
                        } else if (retcode.equals(RetCodeEnum.MOBILE_LOGIN_OUT.getCode())) { // 移动端退出
                            LOG.info(RetCodeEnum.MOBILE_LOGIN_OUT.getType());
                            break;
                        } else if (retcode.equals(RetCodeEnum.NORMAL.getCode())) {
                            core.setLastNormalRetcodeTime(System.currentTimeMillis()); // 最后收到正常报文时间
                            JSONObject msgObj = webWxSync(wechatId);
                            if (selector.equals("2")) {
                                if (msgObj != null) {
                                    try {
                                        JSONArray msgList = new JSONArray();
                                        msgList = msgObj.getJSONArray("AddMsgList");
                                        msgList = MsgCenter.produceMsg(msgList);
                                        for (int j = 0; j < msgList.size(); j++) {
                                            BaseMsg baseMsg = JSON.toJavaObject(msgList.getJSONObject(j),
                                                    BaseMsg.class);
                                            core.getMsgList().add(baseMsg);
                                        }
                                    } catch (Exception e) {
                                        LOG.info(e.getMessage());
                                    }
                                }
                            } else if (selector.equals("7")) {
                                webWxSync(wechatId);
                            } else if (selector.equals("4")) {
                                continue;
                            } else if (selector.equals("3")) {
                                continue;
                            } else if (selector.equals("6")) {
                                if (msgObj != null) {
                                    try {
                                        JSONArray msgList = new JSONArray();
                                        msgList = msgObj.getJSONArray("AddMsgList");
                                        JSONArray modContactList = msgObj.getJSONArray("ModContactList"); // 存在删除或者新增的好友信息
                                        msgList = MsgCenter.produceMsg(msgList);
                                        for (int j = 0; j < msgList.size(); j++) {
                                            JSONObject userInfo = modContactList.getJSONObject(j);
                                            // 存在主动加好友之后的同步联系人到本地
                                            System.out.println("    这里没写！！！！！！！！！！！！！" +
                                                    "1！！！！！！！！！！     " + userInfo);
                                            //TODO
//                                            core.getContactList().add(userInfo);
                                        }
                                    } catch (Exception e) {
                                        LOG.info(e.getMessage());
                                    }
                                }

                            }
                        } else {
                            JSONObject obj = webWxSync(wechatId);
                        }
                    } catch (Exception e) {
                        LOG.info(e.getMessage());
                        retryCount += 1;
                        if (core.getReceivingRetryCount() < retryCount) {
                            core.setAlive(false);
                        } else {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e1) {
                                LOG.info(e.getMessage());
                            }
                        }
                    }

                }
            }
        }).start();

    }

    @Override
    public void webWxGetContact(String wechatId) {
        User core = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(wechatId);
        String url = String.format(URLEnum.WEB_WX_GET_CONTACT.getUrl(),
                core.getUrl());
        Map<String, Object> paramMap = getParamMap();

        try {
            String result = restTemplate.postForObject(url, paramMap, String.class, paramMap);
            JSONObject fullFriendsJsonList = JSON.parseObject(result);
            // 查看seq是否为0，0表示好友列表已全部获取完毕，若大于0，则表示好友列表未获取完毕，当前的字节数（断点续传）
            long seq = 0;
            long currentTime = 0L;
            List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
            if (fullFriendsJsonList.get("Seq") != null) {
                seq = fullFriendsJsonList.getLong("Seq");
                currentTime = new Date().getTime();
            }
            core.setMemberCount(fullFriendsJsonList.getInteger(StorageLoginInfoEnum.MemberCount.getKey()));
            JSONArray member = fullFriendsJsonList.getJSONArray(StorageLoginInfoEnum.MemberList.getKey());
            // 循环获取seq直到为0，即获取全部好友列表 ==0：好友获取完毕 >0：好友未获取完毕，此时seq为已获取的字节数
            while (seq > 0) {
                // 设置seq传参
                params.add(new BasicNameValuePair("r", String.valueOf(currentTime)));
                params.add(new BasicNameValuePair("seq", String.valueOf(seq)));
                params.remove(new BasicNameValuePair("r", String.valueOf(currentTime)));
                params.remove(new BasicNameValuePair("seq", String.valueOf(seq)));

                result = restTemplate.getForObject(url, String.class, params);
                fullFriendsJsonList = JSON.parseObject(result);

                if (fullFriendsJsonList.get("Seq") != null) {
                    seq = fullFriendsJsonList.getLong("Seq");
                    currentTime = new Date().getTime();
                }

                // 累加好友列表
                member.addAll(fullFriendsJsonList.getJSONArray(StorageLoginInfoEnum.MemberList.getKey()));
            }
            core.setMemberCount(member.size());
//            for (Iterator<?> iterator = member.iterator(); iterator.hasNext(); ) {
//                JSONObject o = (JSONObject) iterator.next();
//                if ((o.getInteger("VerifyFlag") & 8) != 0) { // 公众号/服务号
//                    core.getPublicUsersList().add(o);
//                } else if (Config.API_SPECIAL_USER.contains(o.getString("UserName"))) { // 特殊账号
//                    core.getSpecialUsersList().add(o);
//                } else if (o.getString("UserName").indexOf("@@") != -1) { // 群聊
//                    if (!core.getGroupIdList().contains(o.getString("UserName"))) {
//                        //TODO 这里比较乱，到时候再改。
//                        core.getGroupNickNameList().add(new GroupName(o.getString("NickName")));
//                        core.getGroupIdList().add(new GroupName(o.getString("UserName")));
//                        core.getGroupList().add(o);
//                    }
//                } else if (o.getString("UserName").equals(core.getUserSelf().getString("UserName"))) { // 自己
//                    core.getContactList().remove(o);
//                } else { // 普通联系人
//                    core.getContactList().add(o);
//                }
//            }
            return;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return;
    }

    @Override
    public void WebWxBatchGetContact(String wechatId) {
        User core = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(wechatId);

        String url = String.format(URLEnum.WEB_WX_BATCH_GET_CONTACT.getUrl(),
                core.getUrl(), new Date().getTime(),
                core.getPass_ticket());
        Map<String, Object> paramMap = getParamMap();
        paramMap.put("Count", core.getGroupIdList().size());
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (int i = 0; i < core.getGroupIdList().size(); i++) {
            HashMap<String, String> map = new HashMap<String, String>();
//            map.put("UserName", core.getGroupIdList().get(i)); //TODO 以后再改
            map.put("EncryChatRoomId", "");
            list.add(map);
        }
        paramMap.put("List", list);
        try {
            String text = restTemplate.postForObject(url, paramMap, String.class, paramMap);
            JSONObject obj = JSON.parseObject(text);
            JSONArray contactList = obj.getJSONArray("ContactList");
            for (int i = 0; i < contactList.size(); i++) { // 群好友
                if (contactList.getJSONObject(i).getString("UserName").indexOf("@@") > -1) { // 群
//                    core.getGroupNickNameList().add(contactList.getJSONObject(i).getString("NickName")); // 更新群昵称列表
//                    core.getGroupList().add(contactList.getJSONObject(i)); // 更新群信息（所有）列表
//                    core.getGroupMemeberMap().put(contactList.getJSONObject(i).getString("UserName"),
//                            contactList.getJSONObject(i).getJSONArray("MemberList")); // 更新群成员Map
                }
            }
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }
    }

    /**
     * 检查登陆状态
     *
     * @param result
     * @return
     */
    public String checklogin(String result) {
        String regEx = "window.code=(\\d+)";
        Matcher matcher = CommonTools.getMatcher(regEx, result);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /**
     * 处理登陆信息
     *
     * @param result
     * @author https://github.com/yaphone
     * @date 2017年4月9日 下午12:16:26
     */
    private void processLoginInfo(String loginContent, String wechatId) {
        User core = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(wechatId);

        String regEx = "window.redirect_uri=\"(\\S+)\";";
        Matcher matcher = CommonTools.getMatcher(regEx, loginContent);
        if (matcher.find()) {
            String originalUrl = matcher.group(1);
            String url = originalUrl.substring(0, originalUrl.lastIndexOf('/')); // https://wx2.qq.com/cgi-bin/mmwebwx-bin
            core.setUrl(url);
            Map<String, List<String>> possibleUrlMap = this.getPossibleUrlMap();
            Iterator<Entry<String, List<String>>> iterator = possibleUrlMap.entrySet().iterator();
            Entry<String, List<String>> entry;
            String fileUrl;
            String syncUrl;
            while (iterator.hasNext()) {
                entry = iterator.next();
                String indexUrl = entry.getKey();
                fileUrl = "https://" + entry.getValue().get(0) + "/cgi-bin/mmwebwx-bin";
                syncUrl = "https://" + entry.getValue().get(1) + "/cgi-bin/mmwebwx-bin";
                if (core.getUrl().contains(indexUrl)) {
                    core.setIndexUrl(indexUrl);
                    core.setFileUrl(fileUrl);
                    core.setSyncUrl(syncUrl);
                    break;
                }
            }
            if (core.getFileUrl() == null && core.getSyncUrl() == null) {
                core.setFileUrl(url);
                core.setSyncUrl(url);
            }
            core.setDeviceid("e" + String.valueOf(new Random().nextLong()).substring(1, 16)); // 生成15位随机数
            core.setBaseRequest("");
//            core.setBaseRequest(new ArrayList<String>());
            String text = "";

            try {
                text = restTemplate.getForObject(originalUrl, String.class);
            } catch (Exception e) {
                LOG.info(e.getMessage());
                return;
            }
            Document doc = CommonTools.xmlParser(text);
            if (doc != null) {
                core.setSkey(
                        doc.getElementsByTagName(StorageLoginInfoEnum.skey.getKey()).item(0).getFirstChild()
                                .getNodeValue());
                core.setWxsid(
                        doc.getElementsByTagName(StorageLoginInfoEnum.wxsid.getKey()).item(0).getFirstChild()
                                .getNodeValue());
                core.setWxuin(
                        doc.getElementsByTagName(StorageLoginInfoEnum.wxuin.getKey()).item(0).getFirstChild()
                                .getNodeValue());
                core.setPass_ticket(
                        doc.getElementsByTagName(StorageLoginInfoEnum.pass_ticket.getKey()).item(0).getFirstChild()
                                .getNodeValue());
            }

        }
    }

    private Map<String, List<String>> getPossibleUrlMap() {
        Map<String, List<String>> possibleUrlMap = new HashMap<String, List<String>>();
        possibleUrlMap.put("wx.qq.com", new ArrayList<String>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            {
                add("file.wx.qq.com");
                add("webpush.wx.qq.com");
            }
        });

        possibleUrlMap.put("wx2.qq.com", new ArrayList<String>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            {
                add("file.wx2.qq.com");
                add("webpush.wx2.qq.com");
            }
        });
        possibleUrlMap.put("wx8.qq.com", new ArrayList<String>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            {
                add("file.wx8.qq.com");
                add("webpush.wx8.qq.com");
            }
        });

        possibleUrlMap.put("web2.wechat.com", new ArrayList<String>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            {
                add("file.web2.wechat.com");
                add("webpush.web2.wechat.com");
            }
        });
        possibleUrlMap.put("wechat.com", new ArrayList<String>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            {
                add("file.web.wechat.com");
                add("webpush.web.wechat.com");
            }
        });
        return possibleUrlMap;
    }

    /**
     * 同步消息 sync the messages
     *
     * @return
     * @author https://github.com/yaphone
     * @date 2017年5月12日 上午12:24:55
     */
    private JSONObject webWxSync(String wechatId) {
//        User core = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(wechatId);
//        JSONObject result = null;
//        String url = String.format(URLEnum.WEB_WX_SYNC_URL.getUrl(),
//                core.getUrl(),
//                core.getWxsid(),
//                core.getSkey(),
//                core.getPass_ticket());
//        Map<String, Object> paramMap = getParamMap();
//        paramMap.put(StorageLoginInfoEnum.SyncKey.getKey(),
//                core.getSyncKey());
//        paramMap.put("rr", -new Date().getTime() / 1000);
//        String paramStr = JSON.toJSONString(paramMap);
//        try {
//            String text = restTemplate.postForObject(url, paramStr, String.class, paramStr);
//            JSONObject obj = JSON.parseObject(text);
//            if (obj.getJSONObject("BaseResponse").getInteger("Ret") != 0) {
//                result = null;
//            } else {
//                result = obj;
//                core.setSyncKey(String.valueOf(obj.getJSONObject("SyncCheckKey")));
//                JSONArray syncArray = obj.getJSONObject(StorageLoginInfoEnum.SyncKey.getKey()).getJSONArray("List");
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i < syncArray.size(); i++) {
//                    sb.append(syncArray.getJSONObject(i).getString("Key") + "_"
//                            + syncArray.getJSONObject(i).getString("Val") + "|");
//                }
//                String synckey = sb.toString();
//                core.setSynckey(
//                        synckey.substring(0, synckey.length() - 1));// 1_656161336|2_656161626|3_656161313|11_656159955|13_656120033|201_1492273724|1000_1492265953|1001_1492250432|1004_1491805192
//            }
//        } catch (Exception e) {
//            LOG.info(e.getMessage());
//        }
//        return result;

        return null;
    }

    /**
     * 检查是否有新消息 check whether there's a message
     *
     * @return
     * @author https://github.com/yaphone
     * @date 2017年4月16日 上午11:11:34
     */
    private Map<String, String> syncCheck(String wechatId) {
        User core = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(wechatId);
        Map<String, String> resultMap = new HashMap<String, String>();
        // 组装请求URL和参数
        String url = core.getSyncUrl() + URLEnum.SYNC_CHECK_URL.getUrl();
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        /**
         *  Uin("Uin", "wxuin"),
         Sid("Sid", "wxsid"),
         Skey("Skey", "skey"),
         DeviceID("DeviceID", "pass_ticket");
         */
//        for (BaseParaEnum baseRequest : BaseParaEnum.values()) {
        params.add(new BasicNameValuePair("uin", core.getWxuin()));
        params.add(new BasicNameValuePair("sid", core.getWxsid()));
        params.add(new BasicNameValuePair("skey", core.getSkey()));
        params.add(new BasicNameValuePair("seviceid", core.getPass_ticket()));
//        }
        params.add(new BasicNameValuePair("r", String.valueOf(new Date().getTime())));
        params.add(new BasicNameValuePair("synckey", (String) core.getSynckey()));
        params.add(new BasicNameValuePair("_", String.valueOf(new Date().getTime())));
        SleepUtils.sleep(7);
        try {
            String text = restTemplate.getForObject(url, String.class, params);
            if (text == null) {
                resultMap.put("retcode", "9999");
                resultMap.put("selector", "9999");
                return resultMap;
            }
            String regEx = "window.synccheck=\\{retcode:\"(\\d+)\",selector:\"(\\d+)\"\\}";
            Matcher matcher = CommonTools.getMatcher(regEx, text);
            if (!matcher.find() || matcher.group(1).equals("2")) {
                LOG.info(String.format("Unexpected sync check result: %s", text));
            } else {
                resultMap.put("retcode", matcher.group(1));
                resultMap.put("selector", matcher.group(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }


    /**
     * 请求参数
     */
    public Map<String, Object> getParamMap() {

        Map<String, Object> map = new HashMap<>();

        /**
         *  Uin("Uin", "wxuin"),
         Sid("Sid", "wxsid"),
         Skey("Skey", "skey"),
         DeviceID("DeviceID", "pass_ticket");

         */
        map.put("Uin", "wxuin");
        map.put("Sid", "wxsid");
        map.put("Skey", "skey");
        map.put("DeviceID", "pass_ticket");
        return map;
    }
}
