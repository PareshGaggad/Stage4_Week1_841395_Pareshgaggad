package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Country;
import com.example.demo.service.CountryService;
import com.example.demo.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	private static final Logger LOGGER =LoggerFactory.getLogger(CountryController.class);
	
	
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
	
	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.debug("Start");
		LOGGER.debug(country.toString());
		ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
		Validator validator=factory.getValidator();
		
		Set<ConstraintViolation<Country>> voilations=validator.validate(country);
		List<String> errors=new ArrayList<>();
		
		for(ConstraintViolation<Country> voilation: voilations) {
			errors.add(voilation.getMessage());
			
			if(voilations.size()>0) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.toString());
			}
		}
		return country;
	}
}
