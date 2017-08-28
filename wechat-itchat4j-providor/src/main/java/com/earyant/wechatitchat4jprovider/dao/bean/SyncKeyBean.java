package com.earyant.wechatitchat4jprovider.dao.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by earyant on 2017 : 08 : 2017/8/15 : 14:08 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.bean
 */
@NoArgsConstructor
@Data
@Entity
public class SyncKeyBean {
    /**
     * Count : 4
     * List : [{"Key":1,"Val":686075797},{"Key":2,"Val":686075838},{"Key":3,"Val":686075818},{"Key":1000,"Val":1502757722}]
     */

    @Id
    String id;
    private int Count;
    @Transient
    @JsonProperty("List")
    private java.util.List<ListBean> List;
    String userId;
}
