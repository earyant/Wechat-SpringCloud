package com.earyant.wechatitchat4jprovider.service.impl;

import com.earyant.wechat.message.resp.Image;
import com.earyant.wechat.message.resp.ImageMessage;
import com.earyant.wechat.util.HttpPostUploadUtil;
import com.earyant.wechat.util.MessageUtil;
import com.earyant.wechatitchat4jprovider.dao.repository.UserRepository;
import com.earyant.wechatitchat4jprovider.handler.WechatHandler;
import com.earyant.wechatitchat4jprovider.itchat4j.face.IMsgHandlerFace;
import com.earyant.wechatitchat4jprovider.itchat4j.service.ILoginService;
import com.earyant.wechatitchat4jprovider.itchat4j.utils.SleepUtils;
import com.earyant.wechatitchat4jprovider.service.ChatService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 17:17 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.service.impl
 */
@Service
public class ChatServiceImpl implements ChatService {
    private Logger LOG = LoggerFactory.getLogger(ChatServiceImpl.class);
    @Autowired
    private ILoginService loginService;
    @Autowired
    UserRepository userRepository;

    @Override
    public String chat(Map<String, String> map, String path) {
        String openid = map.get("FromUserName"); // 用户openid
        String mpid = map.get("ToUserName"); // 公众号原始ID
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setToUserName(openid);
        imageMessage.setFromUserName(mpid);
        imageMessage.setCreateTime(new Date().getTime());
        imageMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);

        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        String qrPath = path; // 保存登陆二维码图片的路径，这里需要在本地新建目录
        IMsgHandlerFace msgHandler = new WechatHandler(); // 实现IMsgHandlerFace接口的类
        LOG.info("Start handler message!");
        String qr_path = "";

        for (int count = 0; count < 10; count++) {
            LOG.info("get UUID");
            String uuid = "";
            while (loginService.getUuid(openid) == null) {
                LOG.info("1. get wechat UUID");
                while (loginService.getUuid(openid) == null) {
                    LOG.warn("1.1. get wechat UUID失败，2 second retry");
                    SleepUtils.sleep(2000);
                }
            }
            LOG.info("2. get login qr img");
            qr_path = loginService.getQR(qrPath, openid);
            if (!ObjectUtils.isEmpty(qr_path)) {
                break;
            } else if (count == 10) {
                LOG.error("2.2.  get login qr img, system out");
                qr_path = "出现错误，请重试";
            }
        }
        String token = map.get("access_token");
        imageMessage.setImage(new Image());
        Image img = new Image();
        HttpPostUploadUtil util = new HttpPostUploadUtil(token);
        String filepath = qr_path;
        Map<String, String> textMap = new HashMap<String, String>();
        textMap.put("name", "testname");
        Map<String, String> fileMap = new HashMap<String, String>();
        fileMap.put("userfile", filepath);
        String mediaidrs = util.formUpload(textMap, fileMap);
        String mediaid = JSONObject.fromObject(mediaidrs).getString("media_id");
        img.setMediaId(mediaid);
        imageMessage.setImage(img);
//        User user = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(openid);

//        开启线程检查是否登录
//        ExecutorService service = Executors.newFixedThreadPool(4);
//        service.submit(new Runnable() {
//            @Override
//            public void run() {
//                User u = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(openid);
//                while (!u.isAlive()) {
//                    loginService.login(u);
//                    u = userRepository.findTop1ByWechatIdOrderByCreateTimeDesc(openid);
//                }
//            }
//        });


        return MessageUtil.imageMessageToXml(imageMessage);
    }

    @Override
    public String login(HashMap<String, String> map) {

//        Core core = new Core();
//        MyHttpClient httpClient = core.getMyHttpClient();
//        boolean isLogin = false;
//        // 组装参数和URL
//        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
//        params.add(new BasicNameValuePair(LoginParaEnum.LOGIN_ICON.para(), LoginParaEnum.LOGIN_ICON.value()));
//        params.add(new BasicNameValuePair(LoginParaEnum.UUID.para(), core.getUuid()));
//        params.add(new BasicNameValuePair(LoginParaEnum.TIP.para(), LoginParaEnum.TIP.value()));
//
//        // long time = 4000;
//        while (!isLogin) {
//            long millis = System.currentTimeMillis();
//            params.add(new BasicNameValuePair(LoginParaEnum.R.para(), String.valueOf(millis / 1579L)));
//            params.add(new BasicNameValuePair(LoginParaEnum._.para(), String.valueOf(millis)));
//            HttpEntity entity = httpClient.doGet(URLEnum.LOGIN_URL.getUrl(), params, true, null);
//
//            try {
//                String result = EntityUtils.toString(entity);
//                String status = checklogin(result);
//
//                if (ResultEnum.SUCCESS.getCode().equals(status)) {
//                    processLoginInfo(result); // 处理结果
//                    isLogin = true;
//                    core.setAlive(isLogin);
//                    break;
//                }
//                if (ResultEnum.WAIT_CONFIRM.getCode().equals(status)) {
//                    LOG.info("请点击微信确认按钮，进行登陆");
//                }
//
//            } catch (Exception e) {
//                LOG.error("微信登陆异常！", e);
//            }
//        }

        return null;
    }
}
