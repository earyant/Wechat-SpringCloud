package com.earyant.wechat.bean;

import java.util.List;

/**
 * Created by lirui on 2016/11/2.
 */
public class Day {
    private boolean error;

    //    @JSONField(name = "results")
    private List<String> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean getError() {
        return this.error;
    }

    public void setString(List<String> results) {
        this.results = results;
    }

    public List<String> getString() {
        return this.results;
    }
}
