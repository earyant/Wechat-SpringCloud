/**
  * Copyright 2017 aTool.org 
  */
package com.earyant.wechatitchat4jprovider.dao.wxsync;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
/**
 * Auto-generated: 2017-08-13 20:23:58
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
public class Synccheckkey {

    @JsonProperty("Count")
    private int count;
    @JsonProperty("List")
    private List<String> list;
    public void setCount(int count) {
         this.count = count;
     }
     public int getCount() {
         return count;
     }

    public void setList(List<String> list) {
         this.list = list;
     }
     public List<String> getList() {
         return list;
     }

}