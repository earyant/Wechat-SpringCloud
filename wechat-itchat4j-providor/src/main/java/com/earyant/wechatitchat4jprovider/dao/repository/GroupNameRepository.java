package com.earyant.wechatitchat4jprovider.dao.repository;

import com.earyant.wechatitchat4jprovider.dao.GroupName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by earyant on 2017 : 09 : 2017/9/5 0005 : 18:26 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.repository
 */
public interface GroupNameRepository extends JpaRepository<GroupName, String> {

    List<GroupName> findAllById(String userId);
}
