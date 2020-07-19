package com.wook.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ShortenerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void shorten() throws Exception {
    mockMvc
        .perform(
            get("/shorten").param("url", "http://www.wook87.me/test")
        )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code", is(equalTo(HttpStatus.OK.value()))))
        .andExpect(jsonPath("$.message", is(equalTo(HttpStatus.OK.name()))));
  }
}