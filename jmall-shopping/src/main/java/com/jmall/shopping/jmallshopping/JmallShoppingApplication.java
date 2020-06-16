package com.jmall.shopping.jmallshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.jmall.shopping")
@SpringBootApplication
public class JmallShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmallShoppingApplication.class, args);
    }

}
