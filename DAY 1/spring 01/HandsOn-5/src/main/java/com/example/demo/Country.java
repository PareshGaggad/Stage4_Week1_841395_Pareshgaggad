package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(Country.class);
	public String code;
	public String name;
	public Country() {
		super();

		LOGGER.debug("Inside Country Constructor");
	}
	public String getCode() {
		LOGGER.debug("Inside code setter method");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Inside code getter method");

		this.code = code;
	}
	public String getName() {
		LOGGER.debug("Inside name setter method");

		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Inside name getter method");

		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
	
}
