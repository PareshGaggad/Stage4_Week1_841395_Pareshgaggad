package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
	}

	 static void displayDate() {
		// TODO Auto-generated method stub
		 ApplicationContext context= new ClassPathXmlApplicationContext("dateformat.xml");
		 SimpleDateFormat format= context.getBean("dateFormat",SimpleDateFormat.class);
		 try {
			 Date d=format.parse("31/12/2018");
			 System.out.println(d);
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		
	}

}
