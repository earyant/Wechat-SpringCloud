package com.earyant.wechatitchat4jprovider.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by earyant on 2017 : 08 : 2017/8/16 : 21:37 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao
 */
@NoArgsConstructor
@Data
public class WxBatchGetContact {

    /**
     * BaseResponse : {"Ret":0,"ErrMsg":""}
     * Count : 14
     * ContactList : [{"Uin":0,"UserName":"@4c5d308c1ce095918da5bf61fbe5d003586a6c9b8534ef729cf91702a4d20f94","NickName":"忙啪聛氓庐垄氓鈥βモ\u20ac郝�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450712&username=@4c5d308c1ce095918da5bf61fbe5d003586a6c9b8534ef729cf91702a4d20f94&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"莽鈥澛ε韭伱ヂ⒚р\u20ac犆р\u20ac櫭寂捗柯矫嘎ぢ铰犆ε撯偓盲赂聧氓聫炉茅鈥濃劉猫驴鈥∶♀\u20ac灻р\u20ac樏ε犫偓氓艙藛茫鈧\u20ac毭ε撯\u20ac懊ヂ柯┾\u20ac斅幻ｂ偓聛盲鹿鸥忙艙鈥懊β磁久伱尖\u20ac好ε撯\u20ac懊ㄢ\u20ac炩\u20ac樏β磁久ｂ偓聛盲鹿鸥忙艙鈥懊︹偓聺猫鈧捗ｂ偓鈥�","VerifyFlag":24,"OwnerUin":0,"PYInitial":"JKGY","PYQuanPin":"jikegongyuan","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":3,"Province":"氓艗鈥斆ぢ郝�","City":"忙艙聺茅藴鲁","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@dd65963d8c5b7f6a3a748800fc03c3ff","NickName":"氓陇搂忙鈥⒙懊β嵚β濃\u20ac毭八�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450682&username=@dd65963d8c5b7f6a3a748800fc03c3ff&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"忙藛鈥樏ぢ宦ぢ糕\u20ac溍β陈ヂぢ︹\u20ac⒙懊β嵚モ\u20ac櫯捗ε撀好モ劉篓氓颅娄盲鹿聽茂录艗氓鈥β趁β陈モ\u20ac奥嵜β猜棵ε犫偓忙艙炉氓鈥櫯捗ぢ概∶р\u20ac⑴捗ヂ久仿得ｂ偓鈥毭β徝ヂぢ┟ヂ忊\u20ac樏ヂ钙捗┞溍绰┾\u20ac÷徝︹\u20ac撯\u20ac∶犆寂捗ε犫偓忙艙炉忙隆藛盲戮鈥姑\u20ac懊ヅ脚该ニ嗏\u20ac好ヂ孤裁绰β郝惷β郝惷ぢ嘎嵜︹\u20ac撀ｂ偓鈥毭ヂ惻捗︹\u20ac斅睹ε撯\u20ac懊モ\u20ac衡\u20ac好ヂ嵠捗ぢ郝好♀\u20ac灻ぢ久韭っヂ韭久ヂ犫\u20ac毭寂捗β徝モ\u20ac樎ぢ糕偓忙卢隆盲赂拧莽鈥⑴捗ヂぢр\u20ac扳\u20ac好ε犫偓忙艙炉氓藛鈥犆ぢ郝寂捗ぢ古该ヂ概捗ε撯\u20ac好ぢ铰犆ㄆ捖矫ぢ慌矫库劉茅鈥∨捗ニ嗏\u20ac犆ぢ郝モ\u20ac奥嵜β猜棵ε犫偓忙艙炉茂录艗盲潞陇忙碌聛忙路卤氓潞娄忙鈧澝ㄢ偓茠茫鈧\u20ac�","VerifyFlag":8,"OwnerUin":0,"PYInitial":"DSJZT","PYQuanPin":"dashujuzatan","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"氓艗鈥斆ぢ郝�","City":"忙艙聺茅藴鲁","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@60b4fd91b2282741145a4b883f5327aa","NickName":"莽庐鈧ぢ孤�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450587&username=@60b4fd91b2282741145a4b883f5327aa&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"盲赂鈧ぢ嘎ぢ妓溍绰♀\u20ac灻ニ嗏\u20ac好ぢ脚撁ぢ久ヅ捖好⑩偓鈥澝⑩偓鈥澝ε撯\u20ac懊ヂ库\u20ac斆┞濃\u20ac櫭ヂ孤疵伵∶┾\u20ac衡\u20ac犆ヅ撀�","VerifyFlag":24,"OwnerUin":0,"PYInitial":"JS","PYQuanPin":"jianshu","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"盲赂艩忙碌路","City":"忙聺篓忙碌娄","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@57d712ed9a8ab5211b3f61d450caa6d4","NickName":"猫掳路忙颅艗氓录鈧ヂ忊\u20ac樏ㄢ偓鈥�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450715&username=@57d712ed9a8ab5211b3f61d450caa6d4&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"Google盲赂颅氓鈥郝矫ヂ溍︹\u20ac撀姑绰γヂ徛访ｂ偓鈥毭β扁\u20ac∶┾\u20ac衡\u20ac燗ndroid, Chrome, Angular莽颅鈥懊幻ヅ犅モ\u20ac櫯捗解\u20ac樏慌撁ヂ尖偓氓聫鈥樏ε犫偓忙艙炉茫鈧丟oogle Play氓鈥櫯扐dMob莽颅鈥懊ヂ尖偓氓聫鈥樏ㄢ偓鈥γλ喡惷┾\u20ac⒙棵ｂ偓聛盲录藴氓艗鈥撁モ\u20ac櫯捗ヂ徦溍铰懊ヂ孤趁ヂ徛懊ｂ偓鈥�","VerifyFlag":24,"OwnerUin":0,"PYInitial":"GGKFZ","PYQuanPin":"gugekaifazhe","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"盲赂艩忙碌路","City":"忙碌娄盲赂艙忙鈥撀懊ヅ捖�","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@203b6b0ba3baa5b2b36398cff252965c","NickName":"莽篓鈥姑ヂ郝徝モ\u20ac標溍♀\u20ac灻┾\u20ac毬Ｃぢ衡\u20ac好ぢ衡\u20ac�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450631&username=@203b6b0ba3baa5b2b36398cff252965c&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"忙艙鈧ε撯\u20ac懊ヂ铰泵モ\u20ac溌嵜ヅ犫\u20ac好♀\u20ac灻ㄢ\u20ac姑ヂ郝徝モ\u20ac標溍ㄢ\u20ac÷ヂ\u20ac櫭ぢ解\u20ac溍寂捗モ\u20acβ趁β陈ㄢ\u20ac姑ヂ郝徝モ\u20ac標溍р\u20ac郝该モ\u20acβ趁澝┞⑺溍寂T忙艩鈧ε撀ｂ偓聛IT猫聛艗氓艙潞茫鈧伱ヅ撀郝棵久ㄢ\u20ac姑ｂ偓聛氓颅娄盲鹿聽猫碌鈥灻β郝惷\u20ac懊ｂ偓鈥�","VerifyFlag":24,"OwnerUin":0,"PYInitial":"CXYDNXS","PYQuanPin":"chengxuyuandenaxieshi","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"氓艗鈥斆ぢ郝�","City":"盲赂艙氓鸥沤","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@72ad16c62257ff9b5db13697da96bd5f","NickName":"忙鈥⒙懊β嵚ヂ衡\u20ac溍ヂ尖偓氓聫鈥�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450661&username=@72ad16c62257ff9b5db13697da96bd5f&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"盲录炉盲鹿聬氓艙篓莽潞驴忙鈥斺\u20ac斆ぢ糕\u20ac姑绰γヂ徛访寂捗ニ嗏\u20ac犆ぢ郝︹\u20ac⒙懊β嵚ヂ衡\u20ac溍р\u20ac郝该モ\u20acβ趁ε犫偓忙艙炉忙鈥撯\u20ac∶犆ｂ偓聛忙鈥⑩劉莽篓鈥姑モ\u20ac櫯捗ヂ仿ッモ\u20acβ访寂捗ヂ徛γヂも\u20ac撁克溍ヅ掆\u20acγ︹\u20ac孤︹\u20ac⒙懊β嵚ヂ衡\u20ac溍р\u20ac郝该モ\u20acβ趁♀\u20ac灻ヂ仿ッぢ脚撁ｂ偓鈥毭ヂ伮睹ヂ扳\u20ac澝ぢ古该八喢八喢ㄢ\u20ac姑ヂ郝徝モ\u20ac標溍ぢ郝好р\u20ac澟� :)","VerifyFlag":8,"OwnerUin":0,"PYInitial":"SJKKF","PYQuanPin":"shujukukaifa","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"盲赂艩忙碌路","City":"氓楼鈥懊绰�","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@1b56ba57957142bb370d6bc7ef15da67","NickName":"莽庐鈥斆β斥\u20ac⒚ぢ概矫︹\u20ac⒙懊ヂγぢ光\u20ac姑九�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450724&username=@1b56ba57957142bb370d6bc7ef15da67&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"盲潞陇忙碌聛忙鈧澝ζ捖趁寂捗ニ嗏\u20ac犆ぢ郝嘎ッ\u20ac犆寂捗⒙懊︹\u20ac櫯久伮ㄅ犅泵寂捗ε撯\u20ac懊ヂ姑ぢ蛊捗ヂぢ悸�","VerifyFlag":8,"OwnerUin":0,"PYInitial":"SFYSXZM","PYQuanPin":"suanfayushuxuezhimei","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"氓艗鈥斆ぢ郝�","City":"忙碌路忙路鈧�","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@d9174774901c624d727d8790c5aff73a","NickName":"氓庐鈥懊ヂ嶁\u20ac溍ヂ尖偓氓聫鈥樏猜久┾偓鈥�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450655&username=@d9174774901c624d727d8790c5aff73a&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"盲录炉盲鹿聬氓艙篓莽潞驴忙鈥斺\u20ac斆ぢ糕\u20ac姑绰γヂ徛访寂捗ニ嗏\u20ac犆ぢ郝ヂ\u20ac懊ヂ嶁\u20ac溍ヂ衡\u20ac澝р\u20ac澛р\u20ac郝该モ\u20acβ趁モ\u20ac犫\u20acγヂ姑寂捗ヅ掆\u20acγ︹\u20ac孤寂∶ヂ\u20ac懊ヂ嶁\u20ac溍ヂ衡\u20ac澝р\u20ac澛ヂ尖偓氓聫鈥樏ｂ偓聛猫庐戮猫庐隆氓鈥櫯捗ヅ犅︹偓聛莽颅鈥懊ｂ偓鈥�","VerifyFlag":8,"OwnerUin":0,"PYInitial":"AZKFJX","PYQuanPin":"anzhuokaifajingxuan","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"盲赂艩忙碌路","City":"氓戮聬忙卤鈥�","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@216a3f4ce165c6bb819af27e9d73c58b","NickName":"忙艩鈧ε撀ε撯偓氓鈥奥嵜郝�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450637&username=@216a3f4ce165c6bb819af27e9d73c58b&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"忙艙鈧︹\u20ac撀懊ε犫偓忙艙炉氓鈥櫯捗ぢ概∶р\u20ac⑴捗ヅ犅︹偓聛茂录艗氓掳卤氓艙篓忙艩鈧ε撀ε撯偓氓鈥奥嵜郝�","VerifyFlag":24,"OwnerUin":0,"PYInitial":"JSZQX","PYQuanPin":"jishuzuiqianxian","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"盲赂艩忙碌路","City":"氓藴鈥懊ヂ�","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@cf4b7f85b61c83959c035dd16f9bd6699615598838bc2804acd298184d3605f2","NickName":"猫鈥β久︹\u20ac光\u20ac好佀�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450600&username=@cf4b7f85b61c83959c035dd16f9bd6699615598838bc2804acd298184d3605f2&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":" ","VerifyFlag":24,"OwnerUin":0,"PYInitial":"TXZP","PYQuanPin":"tengxunzhaopin","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"氓鹿驴盲赂艙","City":"忙路卤氓艙鲁","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@487ef54a323ef3e7a4e3667e725f0adc","NickName":"盲录炉盲鹿聬氓艙篓莽潞驴","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450643&username=@487ef54a323ef3e7a4e3667e725f0adc&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"氓鈥β趁β陈伵捗ぢ概∶碘\u20ac灻尖\u20ac好ヂγぢ孤犆ヂ愨\u20ac灻甭幻伵捗ぢ概∶︹\u20ac炁该︹\u20ac毰该ｂ偓聛氓驴茠氓戮鈥斆モ\u20ac櫯捗宦徝┞捗ニ嗏\u20ac犆ぢ郝寂捗︹\u20ac奥┟ヂぢ伵捗ぢ概∶р\u20ac犆┾\u20ac∨矫尖\u20ac好ぢ解\u20ac溍ぢ寂∶β扁\u20ac毭伵捗ｂ偓聛氓路楼盲陆艙氓鈥櫯捗ニ嗏\u20ac好ぢ概∶♀\u20ac灻ヅ解\u20ac犆ㄢ\u20ac� - 氓掳卤氓艙篓JobBole.com 盲录炉盲鹿聬氓艙篓莽潞驴","VerifyFlag":8,"OwnerUin":0,"PYInitial":"BYZX","PYQuanPin":"baiyuezaixian","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"氓艗鈥斆ぢ郝�","City":"盲赂艙氓鸥沤","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@71895be359786d145d92ed4a236f0fb0","NickName":"ImportNew","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450649&username=@71895be359786d145d92ed4a236f0fb0&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"盲录炉盲鹿聬氓艙篓莽潞驴忙鈥斺\u20ac斆ぢ糕\u20ac姑绰γヂ徛访寂捗ぢ糕\u20ac溍β陈↗ava忙艩鈧ε撀ニ嗏\u20ac犆ぢ郝寂捗ヅ掆\u20acγ︹\u20ac孤琂ava氓鸥潞莽隆鈧ε犫偓忙艙炉茫鈧伱库\u20ac好┧溌睹ε犫偓猫茠陆茫鈧伱ε韭睹ε锯\u20ac灻久∶モ\u20ac櫯扟ava忙艩鈧ε撀┞⑩\u20ac犆ヅ概该ヅ犅︹偓聛莽颅鈥懊ｂ偓鈥�","VerifyFlag":8,"OwnerUin":0,"PYInitial":"IMPORTNEW","PYQuanPin":"ImportNew","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"氓艗鈥斆ぢ郝�","City":"忙艙聺茅藴鲁","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@12a0385a881089acde3cce8587c29658","NickName":"莽搂禄氓艩篓氓录鈧ヂ忊\u20ac樏モ\u20ac奥嵜郝�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450679&username=@12a0385a881089acde3cce8587c29658&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"盲赂鈥溍β陈ぢ号矫ニ嗏\u20ac犆ぢ郝幻ヅ犅ヂ尖偓氓聫鈥樏モ\u20ac奥嵜β猜棵モ\u20ac櫯捗ぢ糕偓莽潞驴忙艩鈧ε撀ｂ偓鈥�","VerifyFlag":8,"OwnerUin":0,"PYInitial":"YDKFQX","PYQuanPin":"yidongkaifaqianxian","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"氓艗鈥斆ぢ郝�","City":"忙碌路忙路鈧�","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0},{"Uin":0,"UserName":"@ef83602e0135099e8aad50d222be0912","NickName":"Java氓鈥郝⒚┾\u20ac⒙�","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450794&username=@ef83602e0135099e8aad50d222be0912&skey=","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"氓藛鈥犆ぢ郝獼ava氓颅娄盲鹿聽忙鈥撀姑β斥\u20ac⒚寂捗β徛惷ぢ锯\u20ac篔ava氓鈥β嵜绰姑ヂγぢ孤犆碘\u20ac灻β郝惷悸�","VerifyFlag":8,"OwnerUin":0,"PYInitial":"JAVATC","PYQuanPin":"Javatuanchang","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"氓艗鈥斆ぢ郝�","City":"盲赂艙氓鸥沤","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"0","IsOwner":0}]
     */

    private BaseResponseBean BaseResponse;
    private int Count;
    private List<ContactListBean> ContactList;

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
    public static class ContactListBean {
        /**
         * Uin : 0
         * UserName : @4c5d308c1ce095918da5bf61fbe5d003586a6c9b8534ef729cf91702a4d20f94
         * NickName : 忙啪聛氓庐垄氓鈥βモ€郝�
         * HeadImgUrl : /cgi-bin/mmwebwx-bin/webwxgeticon?seq=679450712&username=@4c5d308c1ce095918da5bf61fbe5d003586a6c9b8534ef729cf91702a4d20f94&skey=
         * ContactFlag : 3
         * MemberCount : 0
         * MemberList : []
         * RemarkName :
         * HideInputBarFlag : 0
         * Sex : 0
         * Signature : 莽鈥澛ε韭伱ヂ⒚р€犆р€櫭寂捗柯矫嘎ぢ铰犆ε撯偓盲赂聧氓聫炉茅鈥濃劉猫驴鈥∶♀€灻р€樏ε犫偓氓艙藛茫鈧€毭ε撯€懊ヂ柯┾€斅幻ｂ偓聛盲鹿鸥忙艙鈥懊β磁久伱尖€好ε撯€懊ㄢ€炩€樏β磁久ｂ偓聛盲鹿鸥忙艙鈥懊︹偓聺猫鈧捗ｂ偓鈥�
         * VerifyFlag : 24
         * OwnerUin : 0
         * PYInitial : JKGY
         * PYQuanPin : jikegongyuan
         * RemarkPYInitial :
         * RemarkPYQuanPin :
         * StarFriend : 0
         * AppAccountFlag : 0
         * Statues : 0
         * AttrStatus : 3
         * Province : 氓艗鈥斆ぢ郝�
         * City : 忙艙聺茅藴鲁
         * Alias :
         * SnsFlag : 0
         * UniFriend : 0
         * DisplayName :
         * ChatRoomId : 0
         * KeyWord :
         * EncryChatRoomId : 0
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
}
