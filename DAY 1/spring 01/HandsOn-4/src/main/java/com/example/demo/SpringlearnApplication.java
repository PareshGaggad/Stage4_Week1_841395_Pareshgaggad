package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class SpringlearnApplication {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(SpringlearnApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringlearnApplication.class, args);
		displayCountry();
	}
	
	public static void displayCountry() {
		ApplicationContext context=new ClassPathXmlApplicationContext("Country.xml");
		Country country=(Country) context.getBean("country",Country.class);
		LOGGER.debug("Country:{}",country.toString());
				
	}
}

