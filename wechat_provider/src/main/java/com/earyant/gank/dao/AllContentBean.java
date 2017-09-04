package com.earyant.gank.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class AllContentBean {
    @Id
    @GeneratedValue
    Long id;
    private String tImages;

    private String tUrl;

    private Integer tId;

    private String tContentId;

    private String tCreatedat;

    private String tDesc;

    private String tPublishedat;

    private String tSource;

    private String tType;

    private String tUsed;

    private String tWho;
}