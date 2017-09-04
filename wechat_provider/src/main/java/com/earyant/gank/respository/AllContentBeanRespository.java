package com.earyant.gank.respository;

import com.earyant.gank.dao.AllContentBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by earyant on 2017 : 09 : 2017/9/3 0003 : 21:41 : .
 * WechatCloud  com.earyant.gank.respository
 */
public interface AllContentBeanRespository extends JpaRepository<AllContentBean,Long> {
    List<AllContentBean> findByTType(String type);

    List<AllContentBean> findByTCreatedatLike(String s);
}
