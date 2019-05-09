package com.kgc.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.kgc")
@EnableAutoConfiguration
@SpringBootApplication
public class SApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SApplication.class, args);
	}

}
