package com.example.demo.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Country Not Found")
public class CountryNotFoundException extends Exception{
	public CountryNotFoundException() {
		// TODO Auto-generated constructor stub
	}

}