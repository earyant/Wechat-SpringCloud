package com.earyant.wechat.mainclass;

import com.earyant.wechat.message.resp.Article;
import com.earyant.wechat.message.resp.NewsMessage;
import com.earyant.wechat.util.MessageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lirui on 2016/11/3.
 */
public class PublishToAll {
    public static void main(String[] args) {
        NewsMessage newmsg = new NewsMessage();
        Article article = new Article();
        article.setDescription("欢迎光临我的blog"); //图文消息的描述
        article.setPicUrl("http://ww2.sinaimg.cn/large/610dc034jw1f978bh1cerj20u00u0767.jpg"); //图文消息图片地址
        article.setTitle("我的博客");  //图文消息标题
        article.setUrl("https://earyant.github.io/");  //图文url链接
        List<Article> list = new ArrayList<Article>();
        list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
        newmsg.setArticleCount(list.size());
        newmsg.setArticles(list);
        MessageUtil.newsMessageToXml(newmsg);
    }
}
