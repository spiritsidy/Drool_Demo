package com.ppbl.Drool_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.ppbl.Drool_demo")
public class DroolDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroolDemoApplication.class, args);
	}

}
