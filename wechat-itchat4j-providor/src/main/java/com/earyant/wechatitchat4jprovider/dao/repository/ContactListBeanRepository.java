package com.earyant.wechatitchat4jprovider.dao.repository;

import com.earyant.wechatitchat4jprovider.dao.bean.ContactListBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by earyant on 2017 : 08 : 2017/8/15 : 14:51 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.repository
 */
public interface ContactListBeanRepository extends JpaRepository<ContactListBean, String> {
    @Query("SELECT c FROM ContactListBean c WHERE user_name =?1")
    ContactListBean findOneByUserName(String userName);
}
