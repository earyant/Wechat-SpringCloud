package com.earyant.wechat.bean;

import com.earyant.wechat.bean.list.AllContentList;

import java.util.List;

/**
 * Created by earyant on 2016/11/20.
 */
public class AllContent {
    private boolean error;

    private List<AllContentList> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean getError() {
        return this.error;
    }

    public void setResults(List<AllContentList> results) {
        this.results = results;
    }

    public List<AllContentList> getResults() {
        return this.results;
    }
}
