package com.gm.token_test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gm.token_test.mapper")
public class TokenTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenTestApplication.class, args);
    }

}
