package com.earyant.wechat.bean;

import com.earyant.wechat.bean.list.HistoryContents;

import java.util.List;

/**
 * Created by earyant on 2016/11/19.
 */
public class HistoryContent {
    private boolean error;

    private List<HistoryContents> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean getError() {
        return this.error;
    }

    public void setResults(List<HistoryContents> results) {
        this.results = results;
    }

    public List<HistoryContents> getResults() {
        return this.results;
    }
}
