package com.earyant.token.repostity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by earyant on 2017 : 08 : 2017/8/4 : 21:50 : .
 * ln_spring_boot  com.earyant.token.repostity
 */
public interface TokenRepsitory extends JpaRepository<Token,Long> {
}
