package com.herb.lib;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibWebApplication.class, args);
    }

}
