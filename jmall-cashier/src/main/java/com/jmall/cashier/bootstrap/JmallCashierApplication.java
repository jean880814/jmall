package com.jmall.cashier.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.jmall.cashier")
@SpringBootApplication
public class JmallCashierApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmallCashierApplication.class, args);
    }

}
