package com.earyant.wechatitchat4jprovider.dao.repository;

import com.earyant.wechatitchat4jprovider.dao.bean.ListBean;
import com.earyant.wechatitchat4jprovider.dao.bean.SyncKeyBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by earyant on 2017 : 08 : 2017/8/15 : 14:51 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.repository
 */
public interface ListBeanRepository extends JpaRepository<ListBean, Long> {
    List<ListBean> findAllBySyncKeyBeanId(String SyncIs);
}
