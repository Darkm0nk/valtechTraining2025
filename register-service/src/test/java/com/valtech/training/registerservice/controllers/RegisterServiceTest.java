package com.valtech.training.registerservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterServiceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetUserByValidId() throws Exception {
		mockMvc.perform(get("/api/v1/users/1")).andDo(print())
		.andExpect(content().json("{\n"
				+ "    \"id\": 1,\n"
				+ "    \"name\": \"none\",\n"
				+ "    \"mobile\": \"98998989989\",\n"
				+ "    \"email\": \"none@0null.com\",\n"
				+ "    \"kid\": false,\n"
				+ "    \"subId\": 1\n"
				+ "}"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testGetUserByInValidId() throws Exception {
		mockMvc.perform(get("/api/v1/users/0"))
		.andExpect(status().isNotFound());
	}
}
