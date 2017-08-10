package com.earyant.wechatitchat4jprovider.dao.test;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by earyant on 2017 : 08 : 2017/8/6 : 21:13 : .
 * ln_spring_boot  com.earyant.wechatitchat4jprovider.dao.test
 */
@Entity
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BOOK_AUTHOR", joinColumns = {
            @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")})
    private Set<Author> authors;

    public Book() {
        super();
    }

    public Book(String name) {
        super();
        this.name = name;
        this.authors = new HashSet<>();
    }

    public Book(String name, Set<Author> authors) {
        super();
        this.name = name;
        this.authors = authors;
    }


}
