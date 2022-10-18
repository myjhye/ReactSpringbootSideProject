package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.web.controller", "com.sist.web.rest", "com.sist.web.dao", 
									"com.sist.web.manager"})
public class SpringBootFinalProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFinalProject2Application.class, args);
	}

}
