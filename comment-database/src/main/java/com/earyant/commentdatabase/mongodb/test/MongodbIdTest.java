package com.earyant.commentdatabase.mongodb.test;

import com.earyant.commentdatabase.mongodb.Customer;
import com.earyant.commentdatabase.mongodb.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by earyant on 2017 : 07 : 2017/7/29 : 23:44 : .
 * ln_spring_boot  com.earyant.commentdatabase.mongodb.test
 */
@RestController
public class MongodbIdTest {
private Logger logger = Logger.getLogger(MongodbIdTest.class.getName());
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping("/getUUID")
            public String getUUID() {
        Customer customer = new Customer("earyant","dd");
         customer =customerRepository.save(customer);
         logger.info("mongodbId:"+customer.getId());
         return customer.getId();
    }

}
