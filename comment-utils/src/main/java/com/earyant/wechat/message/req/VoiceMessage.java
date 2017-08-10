package com.earyant.wechat.message.req;

/**
 * ClassName: VoiceMessage
 *
 * @author dapengniao
 * @Description: 语音消息
 * @date 2016年3月7日 下午3:07:10
 */
public class VoiceMessage extends BaseMessage {
    // 媒体ID   
    private String MediaId;
    // 语音格式   
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}  
