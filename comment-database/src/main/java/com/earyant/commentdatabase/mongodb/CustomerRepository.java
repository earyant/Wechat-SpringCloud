package com.earyant.commentdatabase.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Created by earyant on 2017 : 07 : 2017/7/29 : 23:44 : .
 * ln_spring_boot  com.earyant.commentdatabase.mongodb
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastName(String lastName);
}
