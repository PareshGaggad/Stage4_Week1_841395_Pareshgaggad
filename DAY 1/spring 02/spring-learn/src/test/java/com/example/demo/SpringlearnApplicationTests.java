package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.controller.CountryController;
@AutoConfigureMockMvc
@SpringBootTest
class SpringlearnApplicationTests {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private CountryController countryController;
	@Test
	void contextLoads() {
		assertNotNull(countryController);
	}
	
	@Test
	void testGetCountry() throws Exception{
		ResultActions actions=mvc.perform(get("/country"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$.code").value("IN"));
		actions.andExpect(jsonPath("$.name").exists());
		actions.andExpect(jsonPath("$.name").value("India"));
		
	}
	
	@Test
	void testGetCountryException() throws Exception {
		ResultActions actions=mvc.perform(get("/countries/az"));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Country Not Found"));
	}

}
