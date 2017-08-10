//package com.earyant.wechat.quartz;
//
//import com.earyant.sys.wechat.service.WeChatTaskService;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//
//public class QuartzJob {
//    private static Logger logger = Logger.getLogger(QuartzJob.class);
//    @Autowired
//    private WeChatTaskService weChatTaskService;
//
//    /**
//     * @param
//     * @Description: 任务执行获取token
//     * @author dapengniao
//     * @date 2016年3月10日 下午4:34:26
//     */
//    @Scheduled(cron = "0 0 0/1  * * ?")
//    public void workForToken() {
//        try {
////            WeChatTaskImpl timer = new WeChatTaskImpl();
//            weChatTaskService.getToken_getTicket();
//        } catch (Exception e) {
//            logger.error(e, e);
//        }
//    }
//}
