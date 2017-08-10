package com.earyant.token.repostity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by earyant on 2017 : 08 : 2017/8/4 : 21:25 : .
 * ln_spring_boot  com.earyant.token.repostity
 */
@Data
@Entity
public class Token {
    @Id
    @GeneratedValue
    Long id;

    @Column
    String appid;
    @Column
    String secret;

    @Column
    Date updTime;
    @Column
    Date createTime;
    @Column
    String token;

    @Column
    String wechatName;


}
