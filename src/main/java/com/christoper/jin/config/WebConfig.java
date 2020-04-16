package com.christoper.jin.config;

import com.christoper.jin.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Class WebConfig
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 4. 16.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 4. 16. || 진형은 || 최초생성
 */
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
  private final LoginUserArgumentResolver loginUserArgumentResolver;

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
    resolvers.add(loginUserArgumentResolver);
  }
}
