package com.earyant.wechatitchat4jprovider.dao.repository;

import com.earyant.wechatitchat4jprovider.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by earyant on 2017 : 08 : 2017/8/13 : 18:06 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.dao.repository
 */
public interface UserInfoRepository extends JpaRepository<User, Long> {
    User findTop1ByWechatIdOrderByCreateTimeDesc(String wechatId);
}
