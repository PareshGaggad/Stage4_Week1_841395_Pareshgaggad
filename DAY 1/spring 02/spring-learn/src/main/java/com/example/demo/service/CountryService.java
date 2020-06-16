package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.example.demo.Country;
import com.example.demo.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	ApplicationContext context=new ClassPathXmlApplicationContext("Country.xml");
	Country country=(Country) context.getBean("country",Country.class);
	
	public Country getCountry(String code) throws CountryNotFoundException {
		Country con=null;
		ArrayList<Country> list=context.getBean("countryList",ArrayList.class);
		boolean flag=false;
		for(Country c:list) {
			if(c.getCode().equalsIgnoreCase(code))
			{
				con=c;
				flag=true;
			}
		}
		if(con==null) {
			throw new CountryNotFoundException();			
		}		
		return con;
		
	}

}
