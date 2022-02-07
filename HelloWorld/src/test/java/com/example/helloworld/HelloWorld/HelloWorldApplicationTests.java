package com.example.helloworld.HelloWorld;

import com.example.helloworld.HelloWorld.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest

class HelloWorldApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	private static ObjectMapper mapper = new ObjectMapper();

	@Autowired
	WebApplicationContext context;
	@Test
	void contextLoads() {
	}


	@Test
	public void testMessageSuccess() throws Exception {
		List<Message> messages = new ArrayList<>();
		Message message = new Message("Hello World");

		messages.add(message);


		String json = mapper.writeValueAsString(messages);
		mockMvc.perform(get("/api/hello/").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].message", Matchers.equalTo("Hello World")));



	}

	@Test
	public void testMessageFail() throws Exception {
		List<Message> messages = new ArrayList<>();
		Message message = new Message("Hello World");

		messages.add(message);


		String json = mapper.writeValueAsString(messages);
		mockMvc.perform(get("/api/hello/").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].message", Matchers.not("Simple Message")));



	}

}
