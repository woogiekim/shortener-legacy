package com.shorten.controller;

import static com.shorten.domain.entity.ShortenPath.LENGTH;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ShortenerControllerTest {

  @Value("${config.shorten.redirect-url}")
  private String redirectUrl;

  @Autowired
  MockMvc mockMvc;

  @Test
  void shorten() throws Exception {
    mockMvc
        .perform(
            post("/shorten")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content("{\"originalUrl\":\"http://www.wook87.me/test\"}")
        )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.originalUrl", is(equalTo("http://www.wook87.me/test"))))
        .andExpect(jsonPath("$.shortenUrl", is(hasLength((redirectUrl + "/").length() + LENGTH))));
  }
}