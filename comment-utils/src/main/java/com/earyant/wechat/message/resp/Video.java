package com.earyant.wechat.message.resp;

/**
 * ClassName: Video
 *
 * @author dapengniao
 * @Description: 视频消息体
 * @date 2016年3月8日 下午6:05:45
 */
public class Video {

    private String MediaId;
    private String Title;
    private String Description;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

}
