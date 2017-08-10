package com.earyant.wechat.bean;

import com.earyant.wechat.bean.list.ContentResult;

import java.util.List;

/**
 * Created by lirui on 2016/11/2.
 */
public class Content {
    private boolean error;

    private List<ContentResult> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean getError() {
        return this.error;
    }

    public void setResults(List<ContentResult> results) {
        this.results = results;
    }

    public List<ContentResult> getResults() {
        return this.results;
    }
}
