package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}

//////============= RUN AS TOMCAT - WAR ============
//@SpringBootApplication
//public class DBApiApplication extends SpringBootServletInitializer {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(DBApiApplication.class);
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(DBApiApplication.class, args);
//	}
//}
