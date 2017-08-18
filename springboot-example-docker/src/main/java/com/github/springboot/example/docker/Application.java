package com.github.springboot.example.docker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.github.springboot.example.docker.repository.boot")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
