package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
	}	

	 static void displayDate() {
		// TODO Auto-generated method stub
		 LOGGER.info("START");
		 ApplicationContext context= new ClassPathXmlApplicationContext("dateformat.xml");
		 SimpleDateFormat format= context.getBean("dateFormat",SimpleDateFormat.class);
		 
		 try {
			 Date d= format.parse("31/12/2018");
			 String date=d.toString();
			 
			 LOGGER.debug(date);
			 LOGGER.info(date);
		 }
		 catch (ParseException e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 LOGGER.info("END");
	}

}
