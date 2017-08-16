package com.earyant.wechatitchat4jprovider.dao.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by earyant on 2017 : 08 : 2017/8/15 : 14:09 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.bean
 */
@NoArgsConstructor
@Data
@Entity
public class MPSubscribeMsgListBean {
    /**
     * UserName : @50eb8f63d8e1882a7d8a92a0b2115424
     * MPArticleCount : 4
     * MPArticleList : [{"Title":"\u201c未卜先知\u201d、\u201c自学成才\u201d：GANs奇思妙想TOP10榜单","Digest":"还记得《射雕英雄传》中老顽童发明的\u201c左右互搏术\u201d吗？","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/wc7YNPm3YxX0NveanCywhkNj2oVa6muIGobIKQic3EhUmx7pDtuHTH9x9GsrXHiadMVeSO21iaZZzS94dr7jaM9ZQ/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MTQzNzU2NA==&mid=2651652694&idx=1&sn=afd756b4cc3a6d6dd185847275c8fd7d&chksm=bd4c25c58a3bacd33de923eb7af01caabebf882681bc66de9d60a07a7a62089f7b52da93bb1a&scene=0#rd"},{"Title":"学界 | 视频卡到天荒地老？MIT最新算法Pensieve让你观影畅通无阻","Digest":"美好的一天，和工作说拜拜，打开电脑开始刷剧吧！","Cover":"http://mmbiz.qpic.cn/mmbiz_png/wc7YNPm3YxX0NveanCywhkNj2oVa6muIjoqjdvrKNefxoyesCJwK5pjxrkc9bZ0TgmRuBT6rhKZ3KEpkxGNhHg/300?wxtype=png&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MTQzNzU2NA==&mid=2651652694&idx=2&sn=ce56c7eedc49b9d263346a4012061210&chksm=bd4c25c58a3bacd367575cf7b3ddce8d834a8dd0f09354b23eac7c2311731d51485c533098ed&scene=0#rd"},{"Title":"资源 | 全机器学习和Python的27个速查表（完整版）","Digest":"有不少有用的流程图和机器学习算法表。 这里只包括所发现的最全面的速查表。这里仅列出了需要知道的给定主题的所有要点。","Cover":"http://mmbiz.qpic.cn/mmbiz_png/wc7YNPm3YxWWOA9LZe63WxWnsD68v5OgYut16PGO3MqcgBerplLhibdutx53gKdF2A1F50tGR10ut0AibNuvRMWg/300?wxtype=png&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MTQzNzU2NA==&mid=2651652694&idx=3&sn=0f9fb00aadb1c1ebb3e1311e778930fe&chksm=bd4c25c58a3bacd3e1c14cd425f3497a4f1fff92712ba2f74c4c13c070b14c7e4cb456cec198&scene=0#rd"},{"Title":"报名 | 大数据基础设施认知RONG论坛暨大数据基础设施研究中心成立仪式","Digest":"信息技术与经济社会的交汇融合引发了数据迅猛增长，数据已成为国家基础性战略资源。","Cover":"http://mmbiz.qpic.cn/mmbiz_png/wc7YNPm3YxWWOA9LZe63WxWnsD68v5Ogg5iacaOAXsv68vKeVEoBuDTuibaA14AoRQPicIlfZNWQ2rhPApeyl4xhQ/300?wxtype=png&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MTQzNzU2NA==&mid=2651652694&idx=4&sn=b66d7458ca5c7614e5f960ef3e4f87ff&chksm=bd4c25c58a3bacd317d4c897f5692def65b954fce98edea18ba0e6a0d786da1e2f46fbece5e2&scene=0#rd"}]
     * Time : 1502772922
     * NickName : 大数据文摘
     */
    @Id
    @GeneratedValue
    Long id;

    private String UserName;
    private int MPArticleCount;
    private int Time;
    private String NickName;
    @OneToMany
    private List<MPArticleListBean> MPArticleList;

    @ManyToOne
    WechatinitBean wechatinitBean;

}
