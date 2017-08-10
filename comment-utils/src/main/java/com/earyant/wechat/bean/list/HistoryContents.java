package com.earyant.wechat.bean.list;

/**
 * Created by earyant on 2016/11/19.
 */
public class HistoryContents {
    private String _id;

    private String content;

    private String publishedAt;

    private String title;

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return this._id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
