package com.earyant.wechat.controller;

import com.earyant.wechat.service.EventDisPatcherService;
import com.earyant.wechat.service.MsgDisPatcherService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/wechat")
public class WechatProviderController {
    private static Logger logger = Logger.getLogger(WechatProviderController.class);

    @Resource
    private EventDisPatcherService eventDisPatcherService;
    @Resource
    private MsgDisPatcherService msgDisPatcherService;

//    /**
//     * @param @param request
//     * @param @param response
//     * @param @param signature
//     * @param @param timestamp
//     * @param @param nonce
//     * @param @param echostr
//     * @Description: 用于接收get参数，返回验证参数
//     * @author dapengniao
//     * @date 2016年3月4日 下午6:20:00
//     */
//    @RequestMapping(value = "security.action", method = RequestMethod.GET)
//    public void doGet(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            @RequestParam(value = "signature", required = true) String signature,
//            @RequestParam(value = "timestamp", required = true) String timestamp,
//            @RequestParam(value = "nonce", required = true) String nonce,
//            @RequestParam(value = "echostr", required = true) String echostr) {
//        try {
//            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
//                PrintWriter out = response.getWriter();
//                out.print(echostr);
//                out.close();
//            } else {
//                logger.info("here这里存在非法请求！");
//            }
//        } catch (Exception e) {
//            logger.error(e, e);
//        }
//    }
//
//    /**
//     * @param @param request
//     * @param @param response
//     * @Description: 接收微信端消息处理并做分发
//     * @author dapengniao
//     * @date 2016年3月7日 下午4:06:47
//     */
//    @RequestMapping(value = "security.action", method = RequestMethod.POST)
//    public void DoPost(HttpServletRequest request, HttpServletResponse response) {
//        String appid = "wx26d5f45da3c878fb";
//        response.setCharacterEncoding("utf-8");
//        try {
//            Map<String, String> map = MessageUtil.parseXml(request);
//            String msgtype = map.get("MsgType");
//            if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)) {
//                String msgrsp = eventDisPatcherService.processEvent(map); //进入事件处理
//                PrintWriter out = response.getWriter();
//                out.print(msgrsp);
//                out.close();
//            } else {
//                String msgrsp = msgDisPatcherService.processMessage(map); //进入消息处理
//                PrintWriter out = response.getWriter();
//                out.print(msgrsp);
//                out.close();
//            }
//        } catch (Exception e) {
//            logger.error(e, e);
//        }
//    }


    @PostMapping("/processEvent")
    public String processEvent(@RequestBody HashMap<String, String> map) throws Exception {
        return eventDisPatcherService.processEvent(map); //进入事件处理
    }

    @PostMapping("/processMessage")
    public String processMessage(@RequestBody HashMap<String, String> map) throws Exception {
        String resultMsg = msgDisPatcherService.processMessage(map); //进入消息处理
//        System.out.println("resultMsg   " + resultMsg);
        return resultMsg;
    }

}
