package com.earyant.wechat.bean;

import com.earyant.wechat.bean.list.Pic;

import java.util.List;

/**
 * Created by lirui on 2016/11/3.
 */
public class GetPic {
    private List<Pic> articles;

    public void setArticles(List<Pic> articles) {
        this.articles = articles;
    }

    public List<Pic> getArticles() {
        return this.articles;
    }
}
