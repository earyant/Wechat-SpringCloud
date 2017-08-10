package com.earyant.wechat.menu;

import com.alibaba.fastjson.JSONObject;
import com.earyant.wechat.util.HttpUtils;
import net.sf.json.JSONArray;

public class MenuMain {

    public static void main(String[] args) {

        ClickButton cbt = new ClickButton();
        cbt.setKey("image");
        cbt.setName("发张自拍！");
        cbt.setType("pic_photo_or_album");

        ClickButton cbt2 = new ClickButton();
        cbt2.setKey("rselfmenu_0_0");
        cbt2.setName("扫码");
        cbt2.setType("scancode_waitmsg");

        ClickButton cbt3 = new ClickButton();
        cbt3.setKey("rselfmenu_0_1");
        cbt3.setName("扫码推事件");
        cbt3.setType("scancode_push");

        ClickButton cbt4 = new ClickButton();
        cbt4.setKey("rselfmenu_1_0");
        cbt4.setName("系统拍照发图");
        cbt4.setType("pic_sysphoto");

        ViewButton vbt = new ViewButton();
        vbt.setUrl("https://earyant.github.io/");
        vbt.setName("博客");
        vbt.setType("view");

        JSONArray sub_button = new JSONArray();
        sub_button.add(cbt);
        sub_button.add(cbt2);
        sub_button.add(cbt3);
        sub_button.add(cbt4);
        sub_button.add(vbt);


        JSONObject buttonOne = new JSONObject();
        buttonOne.put("name", "快");
        buttonOne.put("sub_button", sub_button);

        ClickButton c = new ClickButton();
        c.setKey("rselfmenu_1_1");
        c.setName("拍照或者相册发图");
        c.setType("pic_photo_or_album");

        ClickButton c2 = new ClickButton();
        c2.setKey("rselfmenu_1_2");
        c2.setName("微信相册发图");
        c2.setType("pic_weixin");

        ClickButton c3 = new ClickButton();
        c3.setKey("rselfmenu_2_0");
        c3.setName("发送位置");
        c3.setType("location_select");

//        MediaButton c4 = new MediaButton();
//        c4.setMedia_id("MEDIA_ID1");
//        c4.setName("图片");
//        c4.setType("media_id");


        JSONArray sub_button2 = new JSONArray();
        sub_button2.add(c);
        sub_button2.add(c2);
        sub_button2.add(c3);
//        sub_button2.add(c4);

        JSONObject button2 = new JSONObject();
        button2.put("name", "看");
        button2.put("sub_button", sub_button2);

        ClickButton vbt2 = new ClickButton();
//        vbt2.setUrl("http://59.42.254.212/tomcat8081/wechat/gank/getOneDayContent");
        vbt2.setName("查看技术文档");
        vbt2.setType("click");
        vbt2.setKey("getOneDayContent");

        ViewButton vbt3 = new ViewButton();
        vbt3.setUrl("http://earyant1.tunnel.qydev.com");
        vbt3.setName("博客2");
        vbt3.setType("view");

        ClickButton vbt4 = new ClickButton();
//        vbt2.setUrl("http://59.42.254.212/tomcat8081/wechat/gank/getOneDayContent");
        vbt4.setName("Android");
        vbt4.setType("click");
        vbt4.setKey("getAndroidContent");
        ClickButton vbt5 = new ClickButton();
//        vbt2.setUrl("http://59.42.254.212/tomcat8081/wechat/gank/getOneDayContent");
        vbt5.setName("IOS");
        vbt5.setType("click");
        vbt5.setKey("getIOSContent");

//        ClickButton c2 = new ClickButton();
//        c2.setKey("rselfmenu_1_2");
//        c2.setName("微信相册发图");
//        c2.setType("pic_weixin");

        JSONArray sub_button3 = new JSONArray();
        sub_button3.add(vbt2);
        sub_button3.add(vbt3);
        sub_button3.add(vbt4);
        sub_button3.add(vbt5);

        JSONObject button3 = new JSONObject();
        button3.put("name", "我");
        button3.put("sub_button", sub_button3);

        JSONArray button = new JSONArray();
        button.add(buttonOne);
        button.add(button2);
        button.add(button3);

        JSONObject menujson = new JSONObject();
        menujson.put("button", button);
//		System.out.println(menujson);
        //这里为请求接口的url   +号后面的是token，这里就不做过多对token获取的方法解释
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
//                + GlobalConstants.getInterfaceUrl("access_token");
                + "d0tHcLOBe-vn_00NM4dVPzmF0bOO1zfqEZ9iEA0srTBFk4X7dmOpvMGjAPRTU5CQNJxveFK9oHb01h7a8znN2DRmnEshD2sd5LNIOGl88seYC_ApzSCrLVQz17S-B9XlDLFbACAVDX";

        try {
            String rs = HttpUtils.sendPostBuffer(url, menujson.toJSONString());
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println("请求错误！");
        }

    }

}
