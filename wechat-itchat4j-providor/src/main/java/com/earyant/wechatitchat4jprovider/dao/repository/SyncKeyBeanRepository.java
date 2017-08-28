package com.earyant.wechatitchat4jprovider.dao.repository;

import com.earyant.wechatitchat4jprovider.dao.bean.SyncKeyBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by earyant on 2017 : 08 : 2017/8/15 : 14:51 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.repository
 */
public interface SyncKeyBeanRepository extends JpaRepository<SyncKeyBean, Long> {
    SyncKeyBean findOneByUserId(String userId);
}
