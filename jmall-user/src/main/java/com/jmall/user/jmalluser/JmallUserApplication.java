package com.jmall.user.jmalluser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.jmall.user")
@SpringBootApplication
public class JmallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmallUserApplication.class, args);
    }

}
