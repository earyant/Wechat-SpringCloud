package com.earyant.wechat.message.req;

/**
 * ClassName: ImageMessage
 *
 * @author dapengniao
 * @Description: 图片消息
 * @date 2016年3月7日 下午3:04:52
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
