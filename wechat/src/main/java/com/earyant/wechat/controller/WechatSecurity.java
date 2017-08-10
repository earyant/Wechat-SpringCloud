package com.earyant.wechat.controller;

import com.earyant.wechat.dao.WechatMsg;
import com.earyant.wechat.service.EventService;
import com.earyant.wechat.service.MsgService;
import com.earyant.wechat.util.MessageUtil;
import com.earyant.wechat.util.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@Controller
@RequestMapping("/wechat")
public class WechatSecurity {
    private static Logger logger = Logger.getLogger(WechatSecurity.class);

    @Resource
    private EventService eventService;
    @Resource
    private MsgService msgService;

    /**
     * @param @param request
     * @param @param response
     * @param @param signature
     * @param @param timestamp
     * @param @param nonce
     * @param @param echostr
     * @Description: 用于接收get参数，返回验证参数
     * @author dapengniao
     * @date 2016年3月4日 下午6:20:00
     */
    @RequestMapping(value = "security.action", method = RequestMethod.GET)
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "signature", required = true) String signature,
            @RequestParam(value = "timestamp", required = true) String timestamp,
            @RequestParam(value = "nonce", required = true) String nonce,
            @RequestParam(value = "echostr", required = true) String echostr) {
        try {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            } else {
                logger.info("here这里存在非法请求！");
            }
        } catch (Exception e) {
            logger.error(e, e);
        }
    }

    /**
     * @param @param request
     * @param @param response
     * @Description: 接收微信端消息处理并做分发
     * @author dapengniao
     * @date 2016年3月7日 下午4:06:47
     */
    @RequestMapping(value = "security.action", method = RequestMethod.POST)
    public void DoPost(HttpServletRequest request, HttpServletResponse response, @RequestBody @ModelAttribute WechatMsg wechatMsg,
                         String  Content,
                                     String  CreateTime,
                                     String  ToUserName,
                                     String  FromUserName,
                                     String  MsgType,
                                     String  MsgId) {
        String appid = "wxa4b4b009a3f33643";
        response.setCharacterEncoding("utf-8");
        try {
            Map<String, String> map = MessageUtil.parseXml(request);
            System.out.println(map);
            String msgtype = map.get("MsgType");
            map.put("appid",appid);
            if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)) {
                String msgrsp = eventService.processEvent(map); //进入事件处理
                PrintWriter out = response.getWriter();
                out.print(msgrsp);
                out.close();
            } else {
                String msgrsp = msgService.processMessage(map); //进入消息处理
                PrintWriter out = response.getWriter();
                out.print(msgrsp);
                out.close();
            }
        } catch (Exception e) {
            logger.error(e, e);
        }
    }



    /**
     * @param @param request
     * @param @param response
     * @param @param signature
     * @param @param timestamp
     * @param @param nonce
     * @param @param echostr
     * @Description: 用于接收get参数，返回验证参数
     * @author dapengniao
     * @date 2016年3月4日 下午6:20:00
     */
    @RequestMapping(value = "ceshi.action", method = RequestMethod.GET)
    public void ceshi(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "signature", required = true) String signature,
            @RequestParam(value = "timestamp", required = true) String timestamp,
            @RequestParam(value = "nonce", required = true) String nonce,
            @RequestParam(value = "echostr", required = true) String echostr) {
        try {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            } else {
                logger.info("here这里存在非法请求！");
            }
        } catch (Exception e) {
            logger.error(e, e);
        }
    }

    /**
     * @param @param request
     * @param @param response
     * @Description: 接收微信端消息处理并做分发
     * @author dapengniao
     * @date 2016年3月7日 下午4:06:47
     */
    @RequestMapping(value = "ceshi.action", method = RequestMethod.POST)
    public void ceshi(HttpServletRequest request, HttpServletResponse response, @RequestBody @ModelAttribute WechatMsg wechatMsg,
                       String  Content,
                       String  CreateTime,
                       String  ToUserName,
                       String  FromUserName,
                       String  MsgType,
                       String  MsgId) {
        String appid = "wx26d5f45da3c878fb";
        response.setCharacterEncoding("utf-8");
        try {
            Map<String, String> map = MessageUtil.parseXml(request);
            System.out.println(map);
            String msgtype = map.get("MsgType");
            map.put("appid",appid);
            if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)) {
                String msgrsp = eventService.processEvent(map); //进入事件处理
                PrintWriter out = response.getWriter();
                out.print(msgrsp);
                out.close();
            } else {
                String msgrsp = msgService.processMessage(map); //进入消息处理
                PrintWriter out = response.getWriter();
                out.print(msgrsp);
                out.close();
            }
        } catch (Exception e) {
            logger.error(e, e);
        }
    }
}
