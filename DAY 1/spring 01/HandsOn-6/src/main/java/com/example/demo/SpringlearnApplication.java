package com.example.demo;

import java.util.ArrayList;

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
		LOGGER.info("START");
		ApplicationContext context=new ClassPathXmlApplicationContext("Country.xml");
		//Country country=(Country) context.getBean("country",Country.class);
		ArrayList<Country> list=context.getBean("countryList",ArrayList.class);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}

		LOGGER.info("END");		
	}
}

