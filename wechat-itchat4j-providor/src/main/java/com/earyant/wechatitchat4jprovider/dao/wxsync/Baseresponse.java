/**
  * Copyright 2017 aTool.org 
  */
package com.earyant.wechatitchat4jprovider.dao.wxsync;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2017-08-13 20:23:58
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
public class Baseresponse {

    @JsonProperty("Ret")
    private int ret;
    @JsonProperty("ErrMsg")
    private String errmsg;
    public void setRet(int ret) {
         this.ret = ret;
     }
     public int getRet() {
         return ret;
     }

    public void setErrmsg(String errmsg) {
         this.errmsg = errmsg;
     }
     public String getErrmsg() {
         return errmsg;
     }

}