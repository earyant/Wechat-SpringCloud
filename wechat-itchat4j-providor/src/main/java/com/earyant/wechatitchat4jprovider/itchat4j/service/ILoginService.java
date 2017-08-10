package com.earyant.wechatitchat4jprovider.itchat4j.service;

import com.earyant.wechatitchat4jprovider.dao.User;

/**
 * 登陆服务接口
 *
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 创建时间：2017年5月13日 上午12:07:21
 */
public interface ILoginService {

    /**
     * 登陆
     *
     * @return
     * @author https://github.com/yaphone
     * @date 2017年5月13日 上午12:14:07
     * @param uuid
     */
    boolean login(User uuid);

    /**
     * 获取UUID
     *
     * @param qrPath
     * @return
     * @author https://github.com/yaphone
     * @date 2017年5月13日 上午12:21:40
     */
    String getUuid(String wechatId);

    /**
     * 获取二维码图片
     *
     * @param qrPath
     * @return
     * @author https://github.com/yaphone
     * @date 2017年5月13日 上午12:13:51
     */
    String getQR(String qrPath, String wechatId);

    /**
     * web初始化
     *
     * @return
     * @author https://github.com/yaphone
     * @date 2017年5月13日 上午12:14:13
     */
    boolean webWxInit(String wechatId);

    /**
     * 微信状态通知
     *
     * @author https://github.com/yaphone
     * @date 2017年5月13日 上午12:14:24
     */
    public void wxStatusNotify(String wechatId);

    /**
     * 接收消息
     *
     * @author https://github.com/yaphone
     * @date 2017年5月13日 上午12:14:37
     */
    public void startReceiving(String wechatId);

    /**
     * 获取微信联系人
     *
     * @author https://github.com/yaphone
     * @date 2017年5月13日 下午2:26:18
     */
    void webWxGetContact(String wechatId);

    /**
     * 批量获取联系人信息
     *
     * @date 2017年6月22日 下午11:24:35
     */
    void WebWxBatchGetContact(String wechatId);

}
