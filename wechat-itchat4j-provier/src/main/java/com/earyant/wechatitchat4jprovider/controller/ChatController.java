package com.earyant.wechatitchat4jprovider.controller;

import com.earyant.wechatitchat4jprovider.itchat4j.core.Core;
import com.earyant.wechatitchat4jprovider.itchat4j.service.ILoginService;
import com.earyant.wechatitchat4jprovider.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 16:17 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.controller
 */
@RestController
public class ChatController {
    private Logger LOG = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private ILoginService loginService;
    private static Core core = new Core();

    @Autowired
    ChatService chatService;

    @PostMapping("/getQrImg")
    String beginChat(HttpServletRequest request, String userId, @RequestBody HashMap<String, String> map) {
        System.setProperty("jsse.enableSNIExtension", "false"); // 防止SSL错误
        String path = request.getServletContext().getRealPath("") + "loginQrImg";


        return chatService.chat(map, path);
    }

    @PostMapping("/login")
    String login(HttpServletRequest request, String userId, @RequestBody HashMap<String, String> map) {

        return chatService.login(map);
    }


}
