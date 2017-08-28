package com.earyant.wechatitchat4jprovider.dao.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by earyant on 2017 : 08 : 2017/8/22 : 15:07 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.bean
 */
@NoArgsConstructor
@Data
public class WxInitBean {

    /**
     * BaseResponse : {"Ret":0,"ErrMsg":""}
     * Count : 11
     * ContactList : [{"Uin":0,"UserName":"filehelper","NickName":"文件传输助手","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=860850&username=filehelper&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"","VerifyFlag":0,"OwnerUin":0,"PYInitial":"WJCSZS","PYQuanPin":"wenjianchuanshuzhushou","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"","City":"","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"fil","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@bb99ccd93cd75683722260d200340611","NickName":"谷歌开发者","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450715&username=@bb99ccd93cd75683722260d200340611&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"Google中国官方账号。汇集Android, Chrome, Angular等移动和网络开发技术、Google Play和AdMob等开发者成长、优化和变现平台。","VerifyFlag":24,"OwnerUin":0,"PYInitial":"GGKFZ","PYQuanPin":"gugekaifazhe","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"上海","City":"浦东新区","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@4234fe7ca02bd0d0faeec72675279d95","NickName":"小道消息","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450697&username=@4234fe7ca02bd0d0faeec72675279d95&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"在这里，我想为你呈现一幅中国互联网的清明上河图。","VerifyFlag":24,"OwnerUin":0,"PYInitial":"XDXX","PYQuanPin":"xiaodaoxiaoxi","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"浙江","City":"杭州","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@3bf0245f333b5d37359333adaaab3b06","NickName":"ImportNew","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450649&username=@3bf0245f333b5d37359333adaaab3b06&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"伯乐在线旗下账号，专注Java技术分享，包括Java基础技术、进阶技能、架构设计和Java技术领域动态等。","VerifyFlag":8,"OwnerUin":0,"PYInitial":"IMPORTNEW","PYQuanPin":"ImportNew","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"北京","City":"朝阳","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@2eb5efe37676661b222df7d0cf4eb0a0","NickName":"技术最前线","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450637&username=@2eb5efe37676661b222df7d0cf4eb0a0&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"最新技术和业界动态，就在技术最前线","VerifyFlag":24,"OwnerUin":0,"PYInitial":"JSZQX","PYQuanPin":"jishuzuiqianxian","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"上海","City":"嘉定","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@5ab8a7cf01981c474e441b6835960c5c","NickName":"UI设计达人","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450664&username=@5ab8a7cf01981c474e441b6835960c5c&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"分享 UI 设计精选文章、案例、行业趋势、课程和书籍。","VerifyFlag":8,"OwnerUin":0,"PYInitial":"UISJDR","PYQuanPin":"UIshejidaren","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"上海","City":"徐汇","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@70ad98df5134cf1c17f7dd6058620402","NickName":"极客范","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450670&username=@70ad98df5134cf1c17f7dd6058620402&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"极客范聚焦极客主题，分享各种新、奇、酷的东西。","VerifyFlag":8,"OwnerUin":0,"PYInitial":"JKF","PYQuanPin":"jikefan","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"北京","City":"","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@45b3d002b40c6e1860e40da0d2a0fa6d","NickName":"网页设计精选","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450667&username=@45b3d002b40c6e1860e40da0d2a0fa6d&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"分享网页设计精选文章、案例、行业趋势、课程和书籍。","VerifyFlag":8,"OwnerUin":0,"PYInitial":"WXSJJX","PYQuanPin":"wangxieshejijingxuan","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"上海","City":"普陀","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@5c2f5ad57594e1e931793541ba6d8765","NickName":"Python开发者","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450646&username=@5c2f5ad57594e1e931793541ba6d8765&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"人生苦短，我用 Python。伯乐在线旗下账号「Python开发者」分享 Python 相关的技术文章、工具资源、精选课程、热点资讯等。","VerifyFlag":8,"OwnerUin":0,"PYInitial":"PYTHONKFZ","PYQuanPin":"Pythonkaifazhe","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"上海","City":"普陀","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@4bece24a3eae093d3470c4672e69cd28","NickName":"Java团长","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450794&username=@4bece24a3eae093d3470c4672e69cd28&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"分享Java学习方法，提供Java免费学习资源！","VerifyFlag":8,"OwnerUin":0,"PYInitial":"JAVATC","PYQuanPin":"Javatuanchang","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"北京","City":"东城","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@862f52f9239d8dd3cb728baf610e5234","NickName":"程序员的那些事","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450631&username=@862f52f9239d8dd3cb728baf610e5234&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"最有影响力的程序员自媒体，关注程序员相关话题：IT技术、IT职场、在线课程、学习资源等。","VerifyFlag":24,"OwnerUin":0,"PYInitial":"CXYDNXS","PYQuanPin":"chengxuyuandenaxieshi","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"北京","City":"东城","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0}]
     * SyncKey : {"Count":4,"List":[{"Key":1,"Val":679457335},{"Key":2,"Val":679457384},{"Key":3,"Val":679456957},{"Key":1000,"Val":1503363242}]}
     * User : {"Uin":445565535,"UserName":"@911ceb61491ba62a71f34ce7900df3fe","NickName":"李睿","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=2014782132&username=@911ceb61491ba62a71f34ce7900df3fe&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1","RemarkName":"","PYInitial":"","PYQuanPin":"","RemarkPYInitial":"","RemarkPYQuanPin":"","HideInputBarFlag":0,"StarFriend":0,"Sex":1,"Signature":"","AppAccountFlag":0,"VerifyFlag":0,"ContactFlag":0,"WebWxPluginSwitch":0,"HeadImgFlag":0,"SnsFlag":17}
     * ChatSet : filehelper,@bb99ccd93cd75683722260d200340611,@4234fe7ca02bd0d0faeec72675279d95,@3bf0245f333b5d37359333adaaab3b06,@2eb5efe37676661b222df7d0cf4eb0a0,@5ab8a7cf01981c474e441b6835960c5c,@70ad98df5134cf1c17f7dd6058620402,@45b3d002b40c6e1860e40da0d2a0fa6d,@5c2f5ad57594e1e931793541ba6d8765,@4bece24a3eae093d3470c4672e69cd28,@862f52f9239d8dd3cb728baf610e5234,@1c78c4f6e133daa0d17624b2dfc01b64,@39e43743b3fde97619788ca757741828,@cc1c8068400301428cb61a269e044a82,@808bb70c5fd34ff0d1fad22c94b32e02,@3ad5e0ec27c19318ca46aad6079bf278,@08f6f8e4a8339a011765637375d25245,@c3d0a08f455197e0a086df7268b71982,@46fbb1074fc1684ece3a38de54f8a0f5dddc982831b298223223e3e42b5bfd54,@dca0e60a4af9a4cc7055dbff2029bc61,@dd3f22d30d23a745e8c1d8f4e5565c52,@426242098d5507efce5d2f24b8d2a3bee51853c003944efd6f57210d3f27d09c,@eb3a3df086070d72392682d784c328f3,@5ac67db79da1f1f7201d178a11a148ac,
     * SKey : @crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1
     * ClientVersion : 637864496
     * SystemTime : 1503385614
     * GrayScale : 1
     * InviteStartCount : 40
     * MPSubscribeMsgCount : 25
     * MPSubscribeMsgList : [{"UserName":"@bb99ccd93cd75683722260d200340611","MPArticleCount":2,"MPArticleList":[{"Title":"Android 8.0 Oreo 现已推出！","Digest":"新一代 Android 正式命名为 Oreo！","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/rFWVXwibLGtwn5Ohic5dbz2QNaxKXIQ34jhSyDzpGlyFz1tibQwGXJGo2o17YmjFrsld8dkf8Q1OvRL3YlmpVLiaDA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652044487&idx=1&sn=ce2de5e0f31ffe526667156f2ac26ce9&chksm=808d5c82b7fad594d5d5ab0e4e387fa53b6519e945755fcca740c8a01a50ea6b23328c80aa64&scene=0#rd"},{"Title":"Android O 行为变更官方指南","Digest":"Android O 除了提供诸多新特性和功能外，还对系统和 API 行为做出了各种变更。本文重点介绍您应该了","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/rFWVXwibLGtwCVLOuXt2dKIqBpw7p1go7UmSwuqs8q0q0tCtx3cTccFChxACrMsZojV680p9FKIt5nm6icViaRjcg/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652044487&idx=2&sn=1de1a01840c74b6e8b3bcbdb1fccc81c&chksm=808d5c82b7fad594dabddeec10378d417c4684634943ed106900be59f506ce51afa1f679ddb5&scene=0#rd"}],"Time":1503378056,"NickName":"谷歌开发者"},{"UserName":"@4234fe7ca02bd0d0faeec72675279d95","MPArticleCount":1,"MPArticleList":[{"Title":"我为什么放弃炒股转而投资指数","Digest":"这个工程师说，「希望能够打造一套量化的投资策略，让我真正放心的托付我的钱 」，他找到了。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/ow5rEn8QGlETvqTpWmdYghAen3eIicoOmwziaiawRRD3XrTRCz90cgRam8m6bL6CeBn3OQjiacgHz4SuJtg483datA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5ODIyMTE0MA==&mid=2650969897&idx=1&sn=a0af05ae33a7a8c640a2c9bb598ae264&chksm=bd3833128a4fba0466ea0dcfdb70b3805a898855644750e7e7252d26cb0a553f100a830d84b4&scene=0#rd"}],"Time":1503375248,"NickName":"小道消息"},{"UserName":"@3bf0245f333b5d37359333adaaab3b06","MPArticleCount":3,"MPArticleList":[{"Title":"开放 Java EE ？甲骨文考虑将 Java EE 移至开源社区","Digest":"随着 Java EE 8 平台的确定，甲骨文在周四表示，目前正在考虑将 Java Enterprise Edition 技术转移到开源社区。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/eZzl4LXykQz81fSVAEicPkfia8BsTDtE1xYSnFNeu4sW8Dku4vcNqElH45K23TnzGVF0h3syicfANFGFHIeJCmkicw/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651478904&idx=1&sn=156c283d942448c8b405f9adaa842200&chksm=bd2537078a52be1130519236215dde54bb5e60f88102e8988b4716321e4b669e71f8770acc11&scene=0#rd"},{"Title":"Maven 中 jar 包冲突的排查经验谈","Digest":"在一次项目启动中，遇到了一个报错。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/eZzl4LXykQz81fSVAEicPkfia8BsTDtE1xwhLDVPc3R9yicgs2qdn7wcVia3fxBcNoNDUL9WvwJKYN90iazxnUynePQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651478904&idx=2&sn=0a21fc3764df91c1376c20c9dc535430&chksm=bd2537078a52be11f541c12ec77c883071061e3a7e1df189ed522e87adbd454a15ce9c9bccd1&scene=0#rd"},{"Title":"AbstractQueuedSynchronizer 的独占模式","Digest":"JDK1.5之后引入了并发包java.util.concurrent，大大提高了Java程序的并发性能。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/eZzl4LXykQz81fSVAEicPkfia8BsTDtE1xJA1BruKvucZK9SjzT2ic3UDnUxVmafZvRzBCTQjJY9G3K1N9IxvicqzA/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651478904&idx=3&sn=48fa4ebd3f48745660643f7552124f1f&chksm=bd2537078a52be110c1f5bbc27321cd19734eb3dcc9f954e5e07f813470290132b72a25b2e6b&scene=0#rd"}],"Time":1503374447,"NickName":"ImportNew"},{"UserName":"@2eb5efe37676661b222df7d0cf4eb0a0","MPArticleCount":3,"MPArticleList":[{"Title":"想当苹果工程师？水平不够连招聘页面都看不到","Digest":"苹果网站利用一个隐藏的页面招募一名从事\u201c关键基础设施组件\u201d的工程师。该页面的网址是 us-east-1.blobstore.apple.com，目前已经失效。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/gDmjibFWrFyPQBE6j4wsyZMtIJsm2TeA2nWT61jkvkHXZ80fQM7DFOCbWVic93cLkFPWjU22Lrhy4KnC8x5yicDvw/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA3MDMyMzk0NA==&mid=2650814963&idx=1&sn=1994fa13b1b1a5f486a97d784bfecbe8&chksm=84ca0274b3bd8b62ce99492d9765a0d5fb51f528a27c4a222a6a1ca4a69e270c7aab13f484df&scene=0#rd"},{"Title":"Zephyr \u2013适用于设计开发可穿戴设备的操作系统","Digest":"Zephyr \u2013适用于设计开发可穿戴设备的操作系统","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/gDmjibFWrFyPQBE6j4wsyZMtIJsm2TeA2uBV8ib6glkWDegg1ByKrNT12QRorNhmJPNe9Nzov6cq0DiaQZZanskMw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA3MDMyMzk0NA==&mid=2650814963&idx=2&sn=648feb1354d5ef1839aee9f83ecc0c3a&chksm=84ca0274b3bd8b6213d44681738c9d8a43bdf4d894eff4cdb6eb144d5c9acd35e51322b44135&scene=0#rd"},{"Title":"Android 8.0 正式发布，新特性和系统镜像都在这了！微软宣布其语音识别系统错误率仅为 5.1%","Digest":"Android 8.0 正式发布，新特性和系统镜像都在这了！\n微软宣布其语音识别系统错误率仅为 5.1%","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/gDmjibFWrFyPQBE6j4wsyZMtIJsm2TeA2LcO3kgictmuk2MrAFScnU4XoTcEibazAjFI06VGwic1IstViaTgPvVatDw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA3MDMyMzk0NA==&mid=2650814963&idx=3&sn=d9c508686aee31f99cdf7c11e46305a0&chksm=84ca0274b3bd8b6262ee20e0b9a6537b5f47889948395bd1c72e06c0e6a1e2877658a56c6e56&scene=0#rd"}],"Time":1503373757,"NickName":"技术最前线"},{"UserName":"@5ab8a7cf01981c474e441b6835960c5c","MPArticleCount":1,"MPArticleList":[{"Title":"UI的骨骼\u2022盒式模型 (优化版)","Digest":"要探讨组成界面的基本单位--盒子。先来看一下盒式模型可以解决哪些问题。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/YQDs5PiaZZUvTZxcFWl7LOkicRADibOC9EfK5A7AOkM0S1eYuAcu92eQtQRLFFvIk7R14HDoV1RicJOMxhGd0XITzQ/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAwNjM0MzIzNA==&mid=2650320017&idx=1&sn=2ee70a25a7ea69c2af406eeeb204b121&chksm=8302d3bcb4755aaa5bb39b936ec1deb2f1f597952dc0d5870fd8d8bebce4e6b3e83f317cf60c&scene=0#rd"}],"Time":1503373264,"NickName":"UI设计达人"},{"UserName":"@70ad98df5134cf1c17f7dd6058620402","MPArticleCount":1,"MPArticleList":[{"Title":"牛人打造双引擎无人战机竟然还能这么玩！","Digest":"这技术厉害了~","Cover":"http://mmbiz.qpic.cn/mmbiz_png/75TZzMDzrH8bhyc9wcxVTmaZ8fo9vrdReNEibHxkq6V1C8qwnY1tl9FUya5TwpTMVyvSDiaZ6BxPEMqORtcIeJcw/640?wxtype=png&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5OTY0NTY1Mg==&mid=2650175681&idx=1&sn=870bcbdfed4c2ecb4b5e2ccd6325c611&chksm=bf3a807a884d096cd92d3c97f9cb03b6ae2f55f57efda6f086a8e3c8ab327ae8b5daf512b405&scene=0#rd"}],"Time":1503372953,"NickName":"极客范"},{"UserName":"@45b3d002b40c6e1860e40da0d2a0fa6d","MPArticleCount":2,"MPArticleList":[{"Title":"UI设计真的没有什么PY交易","Digest":"最近，一张吐槽甲方最狠的图在不断刷屏，这简直说出了无数人的心声~~","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/CiboI7J6KQxCaibg3LBficEOEudyEmkKSzPMzWvsia7IZPgiaVfF9KzU7c0us4cybnv5w2FERJpSyba1KtJlI4psfBA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA3NDQ1Mjc5OQ==&mid=2654018784&idx=1&sn=6f02c9f246d74dc033d53342faa76404&chksm=84ba26b0b3cdafa664ada7b2b80dbbf11648bfc7f6e94615288d1578367c48c9f2b73427dc5f&scene=0#rd"},{"Title":"设计表单的时候，为什么悬浮式标签体验更好？","Digest":"表单设计中，各种设计模式和技巧已经越来越成熟了。在诸多设计技巧当中，悬浮标签这一设计手法，应该是对于用户体验提升最明显的一种。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/CiboI7J6KQxD42AOhsG8NRxYfIcLn5icAeibvFFP0XeMPg9GzhZMyRF3IMWibgxTG3Ah220ibEMJjiaRAkibLKGW4uVMQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA3NDQ1Mjc5OQ==&mid=2654018784&idx=2&sn=71948be8cf461e639ccd4e11e5ed1913&chksm=84ba26b0b3cdafa6fbbd96060b9bc4eecd04f95ce632ce087c3d0d7d87c3b139436b871a2645&scene=0#rd"}],"Time":1503372686,"NickName":"网页设计精选"},{"UserName":"@5c2f5ad57594e1e931793541ba6d8765","MPArticleCount":1,"MPArticleList":[{"Title":"Python 爬虫实战：股票数据定向爬虫","Digest":"本文爬虫实战目标是运用python3.5， 获取上交所和深交所所有股票的名称和交易信息，输出到保存文件中。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/fhujzoQe7Tp0wp638IlkrK2IjFAhw8StfUXKS7xaf3KcQylk89DvHgu151nsGsCBWd5oPeeEsFV4TWzV3pFYSw/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA4MjEyNTA5Mw==&mid=2652566008&idx=1&sn=1079fd477c5b1292f20847622abbc898&chksm=8464d9b2b31350a428a1e753fe5c4a02ccdfef867f1a7b3d0bb2f8f8c5931c8b949dc26c423c&scene=0#rd"}],"Time":1503316884,"NickName":"Python开发者"},{"UserName":"@4bece24a3eae093d3470c4672e69cd28","MPArticleCount":1,"MPArticleList":[{"Title":"成为优秀Java程序员的10个要点","Digest":"如果你是一个热衷于技术的Java程序员， 那么下面的10个要点可以让你在众多Java开发人员中脱颖而出。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/QCu849YTaIOksxegF2A7j0SMTU6c5n3xy62KqtgDjDiaoKjW2p8nFXRzDE2pTuvViahq1K6qGvibzL91fb6IiciamMA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIwMTY0NDU3Nw==&mid=2651934504&idx=1&sn=ebabf704c52ca68ddf0cb365c57d8b39&chksm=8d0f2066ba78a9705d015ed4f4030b471fc6398cf2df2ebb2a25c4f22ec5f0c939873c4cc4ae&scene=0#rd"}],"Time":1503316817,"NickName":"Java团长"},{"UserName":"@862f52f9239d8dd3cb728baf610e5234","MPArticleCount":3,"MPArticleList":[{"Title":"零基础成为 Google 官方认证机器学习工程师，只需要2步?","Digest":"零基础成为 Google 官方认证机器学习工程师，只需要2步?","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/2A8tXicCG8ym5stX53dFuphk61Bmy6w0tdh0g6f9rTJdXepu13CL6b0yBkIm3VTXLsANOW03oibvGoicQ3WvZjlwQ/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5OTA1MDUyMA==&mid=2655438941&idx=1&sn=e2bfbda43ebcad8002a2527137622f32&chksm=bd73042a8a048d3cb5a9d9eaefc9d6cdb3e0ac40ba042697da39ee83087724573d3ddd0009a9&scene=0#rd"},{"Title":"开放 Java EE？甲骨文考虑将 Java EE 移至开源社区","Digest":"甲骨文表示，目前正在与可能的几个候选基金会，以及许可证持有者和社区在进行谈判。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/2A8tXicCG8ynkn5wYMB4D9HVWO3sC015b8RKjBQpiaYqrqyibCVgzJ3aCPYJA9DVuTxkG2ozDa69gaxUTrtxvwETQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5OTA1MDUyMA==&mid=2655438941&idx=2&sn=d6bc38e4085e1e05218c3ea5742846ac&chksm=bd73042a8a048d3cf0c8720b78c3f59d7c479ff89018fe32fe964943af417a62cdb0176d0e98&scene=0#rd"},{"Title":"趣图：在新接手的代码库上 debug","Digest":"在新接手的代码库上 debug","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/2A8tXicCG8ynkn5wYMB4D9HVWO3sC015bXpbyicRpf1op3CibzkbjlCNWZA90vtGNRbVPBsQgrw01WTvfGtRWx5zQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5OTA1MDUyMA==&mid=2655438941&idx=3&sn=0c9345e438a98fe6d0c07413be6e9a87&chksm=bd73042a8a048d3c89a3157a80a5c2402e7516e24b61451797e1bc1a0857ba1b26b936791516&scene=0#rd"}],"Time":1503316534,"NickName":"程序员的那些事"},{"UserName":"@1c78c4f6e133daa0d17624b2dfc01b64","MPArticleCount":1,"MPArticleList":[{"Title":"Python 爬虫实践：《战狼2》豆瓣影评分析","Digest":"用 Python 实现了简单的爬虫爬取了豆瓣的最新电影的影评。\n\n主要分为三部分：抓取网页数据、清理数据、用词云进行展示。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/fhujzoQe7Tqk3cpicUVyvEOoCFl8GpoMzN8d1T4rNmG8iajv7fuHSpYqOYd6fmahfpWWoAuicHDU5EWvFre26tSlA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIwMDU3MDkzNg==&mid=2651304988&idx=1&sn=324639f423814bf38d1f5d7d63af2b96&chksm=8d08354bba7fbc5d2ffa9890f1fbcf43e740c315015d02e6caca78bc196a6d09c207436f1fcd&scene=0#rd"}],"Time":1503313303,"NickName":"Python开发"},{"UserName":"@39e43743b3fde97619788ca757741828","MPArticleCount":1,"MPArticleList":[{"Title":"为何放弃MVC使用MVVM","Digest":"全称是 Model View Controller，是模型 (model)－视图 (view)－控制器 (controller) 的缩写。它表示的是一种常见的客户端软件开发框架。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/foPACGrddJ0uKBYrxk48YhtFgjXSC6cAKviciafFgpgghwUjVYz3Op2sVsf0zGcZCJl5yztiaSuhEeSiaA6HViaGHtA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA3NzM0NzkxMQ==&mid=2655358939&idx=1&sn=d03c18b085ef5bcdb0c0ef243525fd78&chksm=84e242f3b395cbe530a62ee4d96b8a807e87812cd45ac4ced02e4d8448566afceeb0d72137ff&scene=0#rd"}],"Time":1503313296,"NickName":"iOS开发"},{"UserName":"@cc1c8068400301428cb61a269e044a82","MPArticleCount":1,"MPArticleList":[{"Title":"分布式机器学习平台大比拼：Spark、PMLS、TensorFlow、MXNet","Digest":"分布式机器学习平台Spark、PMLS、TensorFlow、MXNet到底哪家强？本文从分布式系统的角度展开对几个主流机器学习平台的研究，对这些平台的性能、容错性和开发难度进行了分析和对比。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/cokWkYcF4Dc9MlTbV8fHNr7fe1zNbT3fUDWVSJVYYz53FTEu8wKII6uzUiaTPyAjibRkRraCzRfATXAzX55TkKHQ/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA5NzkxMzg1Nw==&mid=2653162826&idx=1&sn=c3faeb97640aff247a6ca8a5ff1bc4f2&chksm=8b493024bc3eb932a773017f326891951ce0d91a7ee18a47def0190b4412245e44a8be71df03&scene=0#rd"}],"Time":1503312421,"NickName":"大数据杂谈"},{"UserName":"@808bb70c5fd34ff0d1fad22c94b32e02","MPArticleCount":1,"MPArticleList":[{"Title":"如何成为一位卓越的技术经理？","Digest":"管理一支技术团队可能是世界上最难的事情之一。如果你是一个经理，你需要和很多方面的专家合作，和你的上级协调产品需求，和负责协调产品交付件的同级合作，和将产品功能转化成技术需求的同级合作，带领直接汇报给你的团队等等。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/KovAgJ2aWyY5UYS4GWnTWw7fMc8zxpseP6gxbLOzD97o5MiaPHeHlrMEicDrkcRxWB4YGgaKGBndE5Sxiavshaj4Q/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MzA0OTkwMA==&mid=2651196095&idx=1&sn=2dfa045c5591e83d6a196135abd40e84&chksm=bd6e56fc8a19dfeaf4d080f542fa963348f7cc9bba10b12f7c48df0ee259f9a49b5e4bc3dfba&scene=0#rd"}],"Time":1503229844,"NickName":"伯乐在线"},{"UserName":"@3ad5e0ec27c19318ca46aad6079bf278","MPArticleCount":1,"MPArticleList":[{"Title":"Redis 主从配置心得及其高可用方案","Digest":"如果master发现故障了，还得手动将slave切换成master继续服务。那Redis有没有一种机制可以在master和slave进行监控，并在master发送故障的时候，能自动将slave切换成master呢？有的，那就是哨兵。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/DmibiaFiaAI4B3d84Gz3BKiasnUibeLMd5oAWMOI2clBnyDTXzseNicwkIACiaHIiaiaCYJefJH1P4bsu9uTCSvQXsdTLSw/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA5ODM5MDU3MA==&mid=2650862974&idx=1&sn=3270b83e4e71c236569f9f954749dae4&chksm=8b66123bbc119b2d1dc1e32db5d2d8e935ba86591118474dcc33cdda14f22edd5bf9a76e6519&scene=0#rd"}],"Time":1503229815,"NickName":"数据库开发"},{"UserName":"@08f6f8e4a8339a011765637375d25245","MPArticleCount":2,"MPArticleList":[{"Title":"关系型数据库成功分片的3个关键原则","Digest":"分片的原理很简单，就是通过一个键（或者说列）来均匀地分布数据。不过理论虽简单，在真正遇到要对数据库进行分片时，很可能会陷入一团手忙脚乱之中。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/FE4VibF0SjfMJkqsWQRHuyGo8ez96Ksr2BvysUslfeZxlLYMXsVlibwTqoDoUs7AQj2AwR7Jic3LeDYWQ9TyPNhKQ/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIzNjUxMzk2NQ==&mid=2247485627&idx=1&sn=03bbf7f8e05622a7f6b755214ab9c27c&chksm=e8d7f779dfa07e6f3f3425e5d0448b7f5dfb3e2900c1fb79d6b2b089c75f78ad39e9444d24d9&scene=0#rd"},{"Title":"可能是技术圈最值得关注的十一个公众号","Digest":"你一定知道 InfoQ，却不一定知道极客邦科技；你可能知道 QCon、AS，却不一定知道 CNUTCon、G","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/FE4VibF0SjfMJkqsWQRHuyGo8ez96Ksr2VC91wpal9gTxRPVIJzXRMLP8a5X1eCqgfv9ThDWcytJzDvlBpygl5A/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIzNjUxMzk2NQ==&mid=2247485627&idx=2&sn=8b1003a72947dad6bb927c4d8f6e9ecb&chksm=e8d7f779dfa07e6fdb8af4fd0a8e7cd5ee86c01a7977ce50ea6435787ce55091495c7886f5ec&scene=0#rd"}],"Time":1503215738,"NickName":"高效开发运维"},{"UserName":"@3bf0245f333b5d37359333adaaab3b06","MPArticleCount":3,"MPArticleList":[{"Title":"ClassLoader 揭秘（ 上 ）","Digest":"一个Java程序要想运行起来，首先需要经过编译生成 .class文件，然后创建一个运行环境（jvm）来加载字节码文件到内存运行，而.class 文件是怎样被加载中jvm 中的就是Java Classloader所做的事情。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/eZzl4LXykQxPWia8k3oE93TJB97ibYR3RgvWhwHNkTqXWu1FNmY9TcOUeIdXRWcMjS5xVnLyyyicm3VRcQK5HbVow/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651478897&idx=1&sn=c123d85a70a0e805626f3b37c0a646f5&chksm=bd25370e8a52be1872b3e9fbbcc1785a169903d4666c3f47ba2f0c919d41eff90ba5cb771fb1&scene=0#rd"},{"Title":"全栈开发者都应该关注这些","Digest":"\u200b这篇文章推荐了包括技术、设计、极客和创业相关的公众号。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/eZzl4LXykQxPWia8k3oE93TJB97ibYR3RgwlmjZGyol3tz04ccfmPibopm58ohvE0tbkTfuzLsmvF8pDNwomibt9nw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651478897&idx=2&sn=4de30f2474270fcde001ebc197f14cc4&chksm=bd25370e8a52be1828c0f2bdc6952eac4bab1d6f87aad296f1603fe8765ddedc099c615f3929&scene=0#rd"},{"Title":"ClassLoader 揭秘（ 下 ）","Digest":"一个Java程序要想运行起来，首先需要经过编译生成 .class文件，然后创建一个运行环境（jvm）来加载字节码文件到内存运行，而.class 文件是怎样被加载中jvm 中的就是Java Classloader所做的事情。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/eZzl4LXykQxPWia8k3oE93TJB97ibYR3Rg7RfejQ5cYnSBgjDs3XAYWbYMBickUqiaMz9MiaJN1hZInpvX6pwQmBO6Q/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651478897&idx=3&sn=34b455989ec3091647230b4dbe971e65&chksm=bd25370e8a52be182a59210a4e031368e497ac1bac477828496435e1f8a7d703e4bdd96d2651&scene=0#rd"}],"Time":1503202747,"NickName":"ImportNew"},{"UserName":"@c3d0a08f455197e0a086df7268b71982","MPArticleCount":1,"MPArticleList":[{"Title":"iOS 11封杀32位应用，不少开发者宁愿放弃","Digest":"随着iOS 11的发布，苹果将要求所有的应用程序支持64位架构，这一架构于2013年底在iPhone 5S、iPad Air和iPad Mini 2上首次亮相。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/k0UVxv3BTLJ9e7iccgocsFyzZKyyDS303fbib031rbktlicTuQRbgQibhnoj45pMKHByETiaFU63cgQvhh4KNt4wn2w/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAxMzE2Mjc2Ng==&mid=2652156195&idx=1&sn=712962334ad1b13dfbeb98d09067cd85&chksm=8046d142b73158546a8558bd88ab9bb35b11af74ce80d3d8c540aadff8f7a0cdab6d07167368&scene=0#rd"}],"Time":1503201879,"NickName":"iOS大全"},{"UserName":"@46fbb1074fc1684ece3a38de54f8a0f5dddc982831b298223223e3e42b5bfd54","MPArticleCount":3,"MPArticleList":[{"Title":"你以为摄像头是用来拍照的？那是下一代交互平台","Digest":"摄像头的进化不仅让电子设备能够感知环境，而且将改变人机交互模式。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/8cu01Kavc5bAEwNrST5rpVrWKPSXZllWusGl3f9J8ShUibaFDRI8dOF6ngA1ibwicmQiaRbcicKysfKatdr5aTbKuxw/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MTMwNDMwODQ0MQ==&mid=2652848456&idx=1&sn=621fac14b9f52af16499ce570505fb5e&chksm=7e6a3cfe491db5e8aafefa6156d3a362e537bf732aa6460f2c295495f3a23a918e306b23e66e&scene=0#rd"},{"Title":"Vision fund，孙正义的一场豪赌","Digest":"下一场科技产业革命的浪潮要来了吗？反正孙正义在拿 Vision fund 抢先下注。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/8cu01Kavc5bAEwNrST5rpVrWKPSXZllWhGaJ1P0tp4ObH6u1DR7ckTkIqeRBjObXemN92BHuMPUC5ibRJHyOZEw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MTMwNDMwODQ0MQ==&mid=2652848456&idx=2&sn=5a2fabcfeb0e76bd7a6905c93acd8136&chksm=7e6a3cfe491db5e8556981ab9cd3ded5b5cf372f3ab4d81fce6e89c21885c06c7080cfec5015&scene=0#rd"},{"Title":"推广 | MINI 做了一个全新媒体，想让你生活的城市少一些乏味","Digest":"你愿意与 MINI 一起试着改变未来吗？","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/8cu01Kavc5bA9LZvnE8fXdFnBEXexeia9YLgY5ImwStbs3ia5dOTNjqo9Em2WDw0ZNx5rK5KWfPGsFTicZyq2lrjw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MTMwNDMwODQ0MQ==&mid=2652848456&idx=3&sn=fe848ba089fa01d00b9c24b5dba7a8cd&chksm=7e6a3cfe491db5e8ef664da11a8b08c64efb2a374b60a7dee73760073f7360cf4fb87f8592af&scene=0#rd"}],"Time":1503201604,"NickName":"极客公园"},{"UserName":"@dca0e60a4af9a4cc7055dbff2029bc61","MPArticleCount":4,"MPArticleList":[{"Title":"创始人周航复盘易到危机：谁做股东都比乐视好","Digest":"\u201c我从来没想过要收回易到，也根本没有这样的兴趣。\u201d","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/ow6przZuPIEcw6h6Y5bqZibIp1XQjQHZERWSsLicfbzovs0dlQ9A4kQtwkWtUX6zyVG1UHTeJVic4N9k4EkxiccKWA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=Mjc1NjM3MjY2MA==&mid=2691323875&idx=1&sn=6eb70b53d393a9fa9b87b762746457e9&chksm=a9ebe8389e9c612e8c492e244c7a50001ff73857e5018c89a58beb8c1154e474927aafd2a0c8&scene=0#rd"},{"Title":"在中东创业，是一种什么体验？","Digest":"宗教与商业的界限非常严格。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/ow6przZuPIEcw6h6Y5bqZibIp1XQjQHZEp74picPIeg74ibN31uMK70l2ibx1UAiaY4ib6R2kfNjZ4fq6OghYQibWgSSw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=Mjc1NjM3MjY2MA==&mid=2691323875&idx=2&sn=092fac8488095ed3cb91bc6e7164ce47&chksm=a9ebe8389e9c612ebf1ae67fd97cd155f3240face149da0617eaf504d9607a8e89c8bd117dbb&scene=0#rd"},{"Title":"马云说新制造要来了，结果中国连造伞都还没自动化","Digest":"对制造业来说，可能一念天堂，一念地狱。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/ow6przZuPIEcw6h6Y5bqZibIp1XQjQHZEocyM6MaEBUoF7TTibl1ibmQ8n1bMXciaXfWXLIwGRJ8bW5iaQMQtXQdaJQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=Mjc1NjM3MjY2MA==&mid=2691323875&idx=3&sn=c6c0b4b985dfd4b8dfe839b9d7d36ac9&chksm=a9ebe8389e9c612e8f425a17b3d59b236ea788289e1d9894cbc76746e39b6f78f657b4085e44&scene=0#rd"},{"Title":"\u201c刷脸\u201d坐飞机这件事，还是要悠着点儿？","Digest":"\u201c刷脸\u201d可能会变成强制措施。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/ow6przZuPIEcw6h6Y5bqZibIp1XQjQHZEZ0Vx52y82e249OoWVJuQ0YUk1e0Fd7QNS8hYFX7zrvu4d9QARmykwQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=Mjc1NjM3MjY2MA==&mid=2691323875&idx=4&sn=602edf8c44d27283df6132f67912e94d&chksm=a9ebe8389e9c612e2ea646d7f04c96e0609ab95a033b6b31e0642f327adcd874c79ae70fa927&scene=0#rd"}],"Time":1503196681,"NickName":"腾讯科技"},{"UserName":"@dd3f22d30d23a745e8c1d8f4e5565c52","MPArticleCount":5,"MPArticleList":[{"Title":"支付宝Copy 微信代码被扒","Digest":"支付宝小程序为抄袭微信代码致歉","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/XUfq62QbuNhk50s5kRdczlAnnl69HxD0Ks6Fkpm2PKT60xcaX5P47XXaUDFjYE5JDG2OnfdRQAFE8Nk3EJ9cXg/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAxMzQ3NzQ3Nw==&mid=2654250605&idx=1&sn=0af36ec4c1360353d301c09d85a7b4a0&chksm=8061f567b7167c71c41c7de73a238293f8b1403b6e16c4cf304d548aaba11f286e93f91270d4&scene=0#rd"},{"Title":"不是生活所迫，是万万不会在北京写代码的","Digest":"以秦岭淮河为界，把中国的互联网版图画分为南北二派，目前，北派压倒性的优势领先南派，这优势主要在码农的数量。","Cover":"http://mmbiz.qpic.cn/mmbiz_png/foPACGrddJ3w7licXPmzIAsOtd68h75Slc958Mk7Q3qFYricIRZ9m1G0CuxcFhLu8Z7rkL3Y1I4n5hjyW4V4hYicA/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAxMzQ3NzQ3Nw==&mid=2654250605&idx=2&sn=dc76982d93e7f40aaae7e57e1e5b4bcb&chksm=8061f567b7167c71836cc14ec19647534cedde5b46d0d8d7d70b218b166b0197eda07d627bad&scene=0#rd"},{"Title":"老外的iPhone又双叕爆炸了！苹果：正在调查","Digest":"又双叕爆炸了！","Cover":"http://mmbiz.qpic.cn/mmbiz_png/V7gVhwXqzkIPLOdjuzB8CAmZsgU1SaNuhw5fZJ7HAGSs7Y8mvVB3JyjxicJ3qWGh6sh0C2nq3bFWqDkH6hrHZBw/300?wxtype=png&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAxMzQ3NzQ3Nw==&mid=2654250605&idx=3&sn=318be2061d3855de51cdadb709853215&chksm=8061f567b7167c710ab8a0bdffb30c32c63f140507ab85fdb9297da3d8d5deb9206bc49e3580&scene=0#rd"},{"Title":"iOS开发 - 仿简书个人主页多页面滑动视图","Digest":"之前项目中很多地方用到了滑动视图，三个界面五个界面或界面个数不定的情况都有，这里以简书 APP 的个人主页为例，总结一下，一则对自己也有好处，二则希望对看到的朋友有所帮助。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/foPACGrddJ05DHibfY6D9sg6ibD8BhcCqtL8rySgGNLmHAuaz5KgG1iaBx8aIxlkr4caqQHCEP5tS9oNxuXozXgFA/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAxMzQ3NzQ3Nw==&mid=2654250605&idx=4&sn=d22dd8c2493d2b8b16c6915bf6113aa7&chksm=8061f567b7167c714492a48380029652bc4636845fb8f61560a6e428b9e207ed430edd305db6&scene=0#rd"},{"Title":"千万别得罪程序员！","Digest":"-","Cover":"http://mmbiz.qpic.cn/mmbiz_png/NVvB3l3e9aF0joF0LcN5bJL0HmY64OcHjVWngGw3qMPOWdUJNFUicWmYYrVbib4XrMj0F1ChdPpdQ94ZkhEn07Aw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAxMzQ3NzQ3Nw==&mid=2654250605&idx=5&sn=9aca9e244ed6dc3a77b5452458605561&chksm=8061f567b7167c716fb5ffe51b3ed5722a1ac09904d49a1b0819b549dde6ed77c282df874332&scene=0#rd"}],"Time":1503195907,"NickName":"程序员大咖"},{"UserName":"@426242098d5507efce5d2f24b8d2a3bee51853c003944efd6f57210d3f27d09c","MPArticleCount":4,"MPArticleList":[{"Title":"听说，硅谷的聪明大脑们都爱这个「S曲线」 | 一周开氪精华","Digest":"开氪这周都讲了什么？","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/WRGz2LWLARB5qKJicCSmgFdTNQk1FXxhTG9PwgfVBDXBkJzPh14YtF6nibuOs8roH72ILKSUQv06PqEZTWk7YzpQ/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjAzNzMzNTkyMQ==&mid=2653763552&idx=1&sn=5bfac0cdd9d7db112d53b8fe638503ae&chksm=4a8927fe7dfeaee86e0bbe833a78ce919e908ad9249d8bb83ed24049dd1459c78918179c587b&scene=0#rd"},{"Title":"为什么「智能音箱」离开我家才10天，就开始想念它？","Digest":"智能语音助手，可以有。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/WRGz2LWLARB5qKJicCSmgFdTNQk1FXxhTBqyGv1wWNib8RgZI1XH7bcKSHIkIWNYelVabAJU7zDfxXKM7xJhd0pA/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjAzNzMzNTkyMQ==&mid=2653763552&idx=2&sn=0bc34fd8529b1650c3b5ce2efa306703&chksm=4a8927fe7dfeaee8682b69fca78e25eb48065a612188eb41d1854aee916e0a69ec28db507ebf&scene=0#rd"},{"Title":"亲子音乐节、教育游戏、家庭旅游，「带娃」也是一笔大生意","Digest":"玩音乐的和做游戏的都来亲子市场抢滩头了。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/WRGz2LWLARB5qKJicCSmgFdTNQk1FXxhTbkczOvuHvr5bG3PM4QSQeBuqJmFibvTXueeY3I62dSYGN2jW8ufVVRg/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjAzNzMzNTkyMQ==&mid=2653763552&idx=3&sn=9fd0f0c9ffe0e8a913a6ae38fb92d524&chksm=4a8927fe7dfeaee85047943e6b751aa79cd387012192c96dd38d7e3dd1e9d5c88dbadd49374b&scene=0#rd"},{"Title":"「迪士尼乐园」又出新玩法, 让你在VR版《星球大战》主题公园中与「尤达」决斗","Digest":"真得好期待VR版西游记乐园啊，亲身过一把大闹天宫的瘾","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/WRGz2LWLARB5qKJicCSmgFdTNQk1FXxhT2P5icqMyMeBXkYPIicL6QrcR9Jeebic3ia3wxCicEKEVuicFyicnibv25U45fw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjAzNzMzNTkyMQ==&mid=2653763552&idx=4&sn=2372997d21a9f3d8256ec1d280aa563f&chksm=4a8927fe7dfeaee8e63b99d3100b707f83bb5af1cb1cc34f6cd49290b8c5319dead33a1d2615&scene=0#rd"}],"Time":1503193095,"NickName":"36氪"},{"UserName":"@eb3a3df086070d72392682d784c328f3","MPArticleCount":3,"MPArticleList":[{"Title":"要怎样努力，才能修炼成一个架构师？","Digest":"未来是不是人人都要学习编程？\n\n从化学专业转到软件是什么感受？\n\n年轻程序员如何成长？\n\n如何在团队中脱颖而出？\n\n如何做好架构？","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/YriaiaJPb26VNG4qGLFIFPxnK7TsMc6RYHzRcicMwRRaAmj2X4piadWpCkWSGqSQPIkHVwnWXKFgILnhSYBq5G2chg/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=2650997425&idx=1&sn=410e82de6c736cb2ee37e3220106745a&chksm=bdbefae28ac973f411920ab2c811ce7c3868c4518c6b4c26508587a256472ddd0df449781d7a&scene=0#rd"},{"Title":"免费公开课｜1小时上手 TensorFlow 深度学习应用","Digest":"花两分钟看看感不感兴趣？","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/YriaiaJPb26VPrRdcBkwSCxdiauVHewWLJO6PhnHBaDCKfyN3pZyswwic0aAlbZXJOHibC3cT2GTsgtr1Ivdl3CQAvQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=2650997425&idx=2&sn=4318b824d64017fd56a8e59cb00e174a&chksm=bdbefae28ac973f44ebc2a2c4c21ffdb4d0be7bd96d0a510eae5537908890ff0238a1e8ba634&scene=0#rd"},{"Title":"智能泊车、环境控制\u2026\u2026这些开发者作品会是未来「智慧社会」的蓝本吗？","Digest":"如果，给你一个最有限的时间，给你提供一个集合云计算、大数据、物联网、移动宽带、SDN 等技术的开放平台或接口，你会做怎样的一套解决方案开发？","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/YriaiaJPb26VNG4qGLFIFPxnK7TsMc6RYH9pJv5ppTfC0XFuryXUHrkBUGvETyqOL2XwXCwf5BZoMnJF807RqhQg/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=2650997425&idx=3&sn=464779a4ffa66b6f7afde5ea59b90df3&chksm=bdbefae28ac973f452037003f2daa6d16a6e8edffc4452ab440d865a8aa95af2fef49a02531a&scene=0#rd"}],"Time":1503190850,"NickName":"InfoQ"},{"UserName":"@cc1c8068400301428cb61a269e044a82","MPArticleCount":2,"MPArticleList":[{"Title":"流式计算新贵Kafka Stream设计详解","Digest":"一篇文章让你全面了解Kafka Stream并学会如何使用它。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/cokWkYcF4Ddx1QUicTT5FpGOic7sNRV1lLy41QUicRWibjz9seFnY4bq0bq1cnz7nY4iaQicic0AyLz7X9v9ZgVH3pPvA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA5NzkxMzg1Nw==&mid=2653162822&idx=1&sn=8c46114360b98b621b166d41d8e01d74&chksm=8b493028bc3eb93e8376d85c7d1f9b2a699888b7f0f52e4556bb8543ebebd5e102e91ea23355&scene=0#rd"},{"Title":"荐号丨可能是技术圈最值得关注的十一个公众号","Digest":"这可能是技术圈最值得关注的十一个公众号！","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/cokWkYcF4Ddx1QUicTT5FpGOic7sNRV1lL0D42ncy1NlYrbMSVWap4kJamQ3gLficwIQYDTOaZrWYQlia509cDIuXQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA5NzkxMzg1Nw==&mid=2653162822&idx=2&sn=40dc741f77d3bba52c72e7e26a47ddba&chksm=8b493028bc3eb93e6a9cc254e3162e92f2e2936227dab8b233f8b794f613bfd20f0eaa32650c&scene=0#rd"}],"Time":1503135017,"NickName":"大数据杂谈"},{"UserName":"@5ac67db79da1f1f7201d178a11a148ac","MPArticleCount":4,"MPArticleList":[{"Title":"她是我昨天的好友，却只能是今天的路人","Digest":"小时候的朋友，如小时候的衣服一样，不是不想穿了，而是无可奈何了。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/8ZDVnCsVkGIiad6KA7rtZps0IHOxxPcuMemMdiato2WAwh06EnPeRxGtKiagibbmaElI1oiaibibKtoNzR9zicwM0DxrQg/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5NjM4OTAyMA==&mid=2650958757&idx=1&sn=fd4ba28deb157847ed2d169dcf60f17c&chksm=bd1cc2568a6b4b40e1b29db4941c7501d84a773d8762360b19f80c9c2b963721d607ec873ef3&scene=0#rd"},{"Title":"如何快速熟悉一个领域","Digest":"如题","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/8ZDVnCsVkGJibxxqme0YaATu3ZgB2qkoibvK3tkk0J0e4diaCxdvQoFpJUMhChymD1TYyD0ydiaoP3FcC4r6DibJ7SA/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5NjM4OTAyMA==&mid=2650958757&idx=2&sn=1402aa17f4e37b5d72c70e1a893d13a2&chksm=bd1cc2568a6b4b40b29ea37568e8c8f4aa5d9482d6186450df6dafb258c069c0fe9d265c27ba&scene=0#rd"},{"Title":"你最想学习的一个技能是什么？","Digest":"今日话题","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/8ZDVnCsVkGJibxxqme0YaATu3ZgB2qkoibmQNgibTBXn17kDLIpwhicThVj8jPE5YveIpgeHL2XH0uCNlAjkQQ788w/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5NjM4OTAyMA==&mid=2650958757&idx=3&sn=f7c5ad234a9c08a88faaace8a2e81c0b&chksm=bd1cc2568a6b4b40b4fa7afe3fbc9f1fabda8b40260d95777eb237239648cbb1f74f13ad4165&scene=0#rd"},{"Title":"小说 | 时间盗窃者","Digest":"我本来是资质平平的人，可是有一天我发现，我可以盗取别人的时间。","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/8ZDVnCsVkGJibxxqme0YaATu3ZgB2qkoib8l74lnro3q6GQoRib4FvCILT1mY9ribtOk21gicpQVWqetmpNV7Al83HA/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5NjM4OTAyMA==&mid=2650958757&idx=4&sn=537b5b16a838d3b273b726ae02c7a588&chksm=bd1cc2568a6b4b40783e59a53a3e029f365f6944717869a989274f7e25e23553feffb907c989&scene=0#rd"}],"Time":1503134460,"NickName":"简书"}]
     * ClickReportInterval : 600000
     */

    private BaseResponseBean BaseResponse;
    private int Count;
    private SyncKeyBean SyncKey;
    private com.earyant.wechatitchat4jprovider.dao.User User;
    private String ChatSet;
    private String SKey;
    private int ClientVersion;
    private int SystemTime;
    private int GrayScale;
    private int InviteStartCount;
    private int MPSubscribeMsgCount;
    private int ClickReportInterval;
    private List<ContactListBean> ContactList;
    private List<MPSubscribeMsgListBean> MPSubscribeMsgList;

    @NoArgsConstructor
    @Data
    public static class BaseResponseBean {
        /**
         * Ret : 0
         * ErrMsg :
         */

        private int Ret;
        private String ErrMsg;
    }

    @NoArgsConstructor
    @Data
    public static class SyncKeyBean {
        /**
         * Count : 4
         * List : [{"Key":1,"Val":679457335},{"Key":2,"Val":679457384},{"Key":3,"Val":679456957},{"Key":1000,"Val":1503363242}]
         */

        private int Count;
        private java.util.List<ListBean> List;

        @NoArgsConstructor
        @Data
        public static class ListBean {
            /**
             * Key : 1
             * Val : 679457335
             */

            private int Key;
            private int Val;
        }
    }

    @NoArgsConstructor
    @Data
    public static class UserBean {
        /**
         * Uin : 445565535
         * UserName : @911ceb61491ba62a71f34ce7900df3fe
         * NickName : 李睿
         * HeadImgUrl : /cgi-bin/mmwebwx-bin/webwxgeticon?seq=2014782132&username=@911ceb61491ba62a71f34ce7900df3fe&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1
         * RemarkName :
         * PYInitial :
         * PYQuanPin :
         * RemarkPYInitial :
         * RemarkPYQuanPin :
         * HideInputBarFlag : 0
         * StarFriend : 0
         * Sex : 1
         * Signature :
         * AppAccountFlag : 0
         * VerifyFlag : 0
         * ContactFlag : 0
         * WebWxPluginSwitch : 0
         * HeadImgFlag : 0
         * SnsFlag : 17
         */

        private int Uin;
        private String UserName;
        private String NickName;
        private String HeadImgUrl;
        private String RemarkName;
        private String PYInitial;
        private String PYQuanPin;
        private String RemarkPYInitial;
        private String RemarkPYQuanPin;
        private int HideInputBarFlag;
        private int StarFriend;
        private int Sex;
        private String Signature;
        private int AppAccountFlag;
        private int VerifyFlag;
        private int ContactFlag;
        private int WebWxPluginSwitch;
        private int HeadImgFlag;
        private int SnsFlag;
    }

    @NoArgsConstructor
    @Data
    public static class ContactListBean {
        /**
         * Uin : 0
         * UserName : filehelper
         * NickName : 文件传输助手
         * HeadImgUrl : /cgi-bin/mmwebwx-bin/webwxgeticon?seq=860850&username=filehelper&skey=@crypt_535307c1_a02a528e6c05a75ba8145a6b9b6bb9f1
         * ContactFlag : 3
         * MemberCount : 0
         * MemberList : []
         * RemarkName :
         * HideInputBarFlag : 0
         * Sex : 0
         * Signature :
         * VerifyFlag : 0
         * OwnerUin : 0
         * PYInitial : WJCSZS
         * PYQuanPin : wenjianchuanshuzhushou
         * RemarkPYInitial :
         * RemarkPYQuanPin :
         * StarFriend : 0
         * AppAccountFlag : 0
         * Statues : 0
         * AttrStatus : 0
         * Province :
         * City :
         * Alias :
         * SnsFlag : 0
         * UniFriend : 0
         * DisplayName :
         * ChatRoomId : 0
         * KeyWord : fil
         * EncryChatRoomId :
         * IsOwner : 0
         */

        private int Uin;
        private String UserName;
        private String NickName;
        private String HeadImgUrl;
        private int ContactFlag;
        private int MemberCount;
        private String RemarkName;
        private int HideInputBarFlag;
        private int Sex;
        private String Signature;
        private int VerifyFlag;
        private int OwnerUin;
        private String PYInitial;
        private String PYQuanPin;
        private String RemarkPYInitial;
        private String RemarkPYQuanPin;
        private int StarFriend;
        private int AppAccountFlag;
        private int Statues;
        private int AttrStatus;
        private String Province;
        private String City;
        private String Alias;
        private int SnsFlag;
        private int UniFriend;
        private String DisplayName;
        private int ChatRoomId;
        private String KeyWord;
        private String EncryChatRoomId;
        private int IsOwner;
        private List<?> MemberList;
    }

    @NoArgsConstructor
    @Data
    public static class MPSubscribeMsgListBean {
        /**
         * UserName : @bb99ccd93cd75683722260d200340611
         * MPArticleCount : 2
         * MPArticleList : [{"Title":"Android 8.0 Oreo 现已推出！","Digest":"新一代 Android 正式命名为 Oreo！","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/rFWVXwibLGtwn5Ohic5dbz2QNaxKXIQ34jhSyDzpGlyFz1tibQwGXJGo2o17YmjFrsld8dkf8Q1OvRL3YlmpVLiaDA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652044487&idx=1&sn=ce2de5e0f31ffe526667156f2ac26ce9&chksm=808d5c82b7fad594d5d5ab0e4e387fa53b6519e945755fcca740c8a01a50ea6b23328c80aa64&scene=0#rd"},{"Title":"Android O 行为变更官方指南","Digest":"Android O 除了提供诸多新特性和功能外，还对系统和 API 行为做出了各种变更。本文重点介绍您应该了","Cover":"http://mmbiz.qpic.cn/mmbiz_jpg/rFWVXwibLGtwCVLOuXt2dKIqBpw7p1go7UmSwuqs8q0q0tCtx3cTccFChxACrMsZojV680p9FKIt5nm6icViaRjcg/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652044487&idx=2&sn=1de1a01840c74b6e8b3bcbdb1fccc81c&chksm=808d5c82b7fad594dabddeec10378d417c4684634943ed106900be59f506ce51afa1f679ddb5&scene=0#rd"}]
         * Time : 1503378056
         * NickName : 谷歌开发者
         */

        private String UserName;
        private int MPArticleCount;
        private int Time;
        private String NickName;
        private List<MPArticleListBean> MPArticleList;

        @NoArgsConstructor
        @Data
        public static class MPArticleListBean {
            /**
             * Title : Android 8.0 Oreo 现已推出！
             * Digest : 新一代 Android 正式命名为 Oreo！
             * Cover : http://mmbiz.qpic.cn/mmbiz_jpg/rFWVXwibLGtwn5Ohic5dbz2QNaxKXIQ34jhSyDzpGlyFz1tibQwGXJGo2o17YmjFrsld8dkf8Q1OvRL3YlmpVLiaDA/640?wxtype=jpeg&wxfrom=0
             * Url : http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652044487&idx=1&sn=ce2de5e0f31ffe526667156f2ac26ce9&chksm=808d5c82b7fad594d5d5ab0e4e387fa53b6519e945755fcca740c8a01a50ea6b23328c80aa64&scene=0#rd
             */

            private String Title;
            private String Digest;
            private String Cover;
            private String Url;
        }
    }
}
