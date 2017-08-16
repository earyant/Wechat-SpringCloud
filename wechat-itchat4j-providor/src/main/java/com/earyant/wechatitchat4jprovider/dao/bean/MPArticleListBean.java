package com.earyant.wechatitchat4jprovider.dao.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by earyant on 2017 : 08 : 2017/8/15 : 14:09 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.bean
 */
@NoArgsConstructor
@Data
@Entity
public class MPArticleListBean {
    /**
     * Title : “未卜先知”、“自学成才”：GANs奇思妙想TOP10榜单
     * Digest : 还记得《射雕英雄传》中老顽童发明的“左右互搏术”吗？
     * Cover : http://mmbiz.qpic.cn/mmbiz_jpg/wc7YNPm3YxX0NveanCywhkNj2oVa6muIGobIKQic3EhUmx7pDtuHTH9x9GsrXHiadMVeSO21iaZZzS94dr7jaM9ZQ/640?wxtype=jpeg&wxfrom=0
     * Url : http://mp.weixin.qq.com/s?__biz=MjM5MTQzNzU2NA==&mid=2651652694&idx=1&sn=afd756b4cc3a6d6dd185847275c8fd7d&chksm=bd4c25c58a3bacd33de923eb7af01caabebf882681bc66de9d60a07a7a62089f7b52da93bb1a&scene=0#rd
     */

    @Id
    @GeneratedValue
    Long id;
    private String Title;
    private String Digest;
    private String Cover;
    private String Url;
    @ManyToOne
    MPSubscribeMsgListBean mpSubscribeMsgListBean;
}
