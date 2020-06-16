package com.jmall.search.bootstrap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jmall.search")
@MapperScan(basePackages = "com.jmall.search.dal")
@EnableElasticsearchRepositories(basePackages = "com.jmall.search.repository")
public class SearchProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchProviderApplication.class, args);
	}

}

