package com.whk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.whk.dao")
public class VueProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueProjectApplication.class, args);
    }

}
