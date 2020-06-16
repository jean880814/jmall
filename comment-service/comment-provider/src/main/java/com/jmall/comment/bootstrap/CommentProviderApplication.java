package com.jmall.comment.bootstrap;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.jmall.comment")
@MapperScan("com.jmall.comment.dal")
public class CommentProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentProviderApplication.class, args);
    }
}
