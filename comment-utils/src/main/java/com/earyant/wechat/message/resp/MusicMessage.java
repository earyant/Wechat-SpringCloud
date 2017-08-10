package com.earyant.wechat.message.resp;

/**
 * ClassName: MusicMessage
 *
 * @author dapengniao
 * @Description: 音乐消息
 * @date 2016年3月7日 下午3:53:38
 */
public class MusicMessage extends BaseMessage {
    // 音乐   
    private com.earyant.wechat.message.resp.Music Music;

    public com.earyant.wechat.message.resp.Music getMusic() {
        return Music;
    }

    public void setMusic(com.earyant.wechat.message.resp.Music music) {
        Music = music;
    }
}  
