package com.earyant.commentdatabase.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by earyant on 2017 : 07 : 2017/7/29 : 23:43 : .
 * ln_spring_boot  com.earyant.commentdatabase.mongodb
 */
@Data
@AllArgsConstructor
public class Customer {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
