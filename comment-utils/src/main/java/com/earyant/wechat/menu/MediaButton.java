package com.earyant.wechat.menu;

/**
 * ClassName: ViewButton
 *
 * @author dapengniao
 * @Description: 视图型菜单事件
 * @date 2016年3月14日 下午5:31:38
 */
public class MediaButton {
    private String type;
    private String name;
    private String url;
    private String media_id;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
