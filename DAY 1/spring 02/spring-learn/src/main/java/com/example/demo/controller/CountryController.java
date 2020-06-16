package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Country;
import com.example.demo.service.CountryService;
import com.example.demo.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	ApplicationContext context=new ClassPathXmlApplicationContext("Country.xml");
	Country country=(Country) context.getBean("country",Country.class);
	@Autowired
	CountryService conServ;

	@GetMapping("/country")
	public Country getCountryIndia() {
		return country;
	}

	@GetMapping("/countries")
	public ArrayList<Country> getAllCountries(){
		ArrayList<Country> list=context.getBean("countryList",ArrayList.class);
		return list;
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		Country con=conServ.getCountry(code);
		return con;
		
	}
}
