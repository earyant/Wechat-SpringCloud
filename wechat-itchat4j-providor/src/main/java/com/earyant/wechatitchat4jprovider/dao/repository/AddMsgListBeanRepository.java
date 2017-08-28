package com.earyant.wechatitchat4jprovider.dao.repository;

import com.earyant.wechatitchat4jprovider.dao.wxsync.WebWxSync;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by earyant on 2017 : 08 : 2017/8/22 : 10:39 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.repository
 */
public interface AddMsgListBeanRepository extends JpaRepository<WebWxSync.AddMsgListBean, Long> {
}
