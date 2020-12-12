package com.christoper.jin.web.greeting.controller;

import com.christoper.jin.config.JpaConfig;
import com.christoper.jin.config.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @Class GreetingApiControllerWebMvcTest
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 12. 12.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 12. 12. || 진형은 || 최초생성
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = GreetingApiController.class,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = JpaConfig.class)
        }
)
/**
 * @WebMvcTest는 @Controller, @ControllerAdvice만 읽음.
 *
 */
public class GreetingApiControllerWebMvcTest {

  @Autowired
  private MockMvc mvc;

  @WithMockUser(roles="USER")
  @Test
  public void hello_return() throws Exception {
    String returnResult = "hello";
    mvc.perform(get("/greeting"))
            .andExpect(status().isOk())
            .andExpect(content().string(returnResult));
  }

}
