package com.github.springboot.example;

import com.github.springboot.example.config.BootDsConfig;
import com.github.springboot.example.config.SysDsConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(value = {BootDsConfig.class, SysDsConfig.class})
////开启事务
//@EnableTransactionManagement
@ComponentScan
//@MapperScan("com.github.springboot.example.repository")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
