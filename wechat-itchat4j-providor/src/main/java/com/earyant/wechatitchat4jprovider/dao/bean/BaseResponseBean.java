package com.earyant.wechatitchat4jprovider.dao.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by earyant on 2017 : 08 : 2017/8/15 : 14:07 : .
 * WechatCloud  com.earyant.wechatitchat4jprovider.dao.bean
 */
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties
public class BaseResponseBean {
    /**
     * Ret : 0
     * ErrMsg :
     */

    @Id
    @GeneratedValue
    Long id;
    private int Ret;
    private String ErrMsg;
}