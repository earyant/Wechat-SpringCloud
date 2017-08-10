package com.earyant.wechatitchat4jprovider.dao.test;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 21:13 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.dao.test
 */
@Entity
@Data
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author() {
        super();
    }

    public Author(String name) {
        super();
        this.name = name;
    }



}
