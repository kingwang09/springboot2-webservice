package com.christoper.jin.config.auth;

import com.christoper.jin.web.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Class SecurityConfig
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 4. 15.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 4. 15. || 진형은 || 최초생성
 */
@RequiredArgsConstructor
@EnableWebSecurity  //Spring Security 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private final CustomOAuth2UserService customOAuth2UserService;

  protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf().disable()
            .headers().frameOptions().disable() //H2-Console을 위해 disable
            .and()
              .authorizeRequests() //URL별 권한관리
              .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //해당 URL은 모두 허용
              .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //API호출은 USER 권한있는 경우만 허용

              .anyRequest().authenticated() //나머지 URL에 대해서는 로그인한 사용자만 허용
            .and()
              .oauth2Login().defaultSuccessUrl("/board")
            .and()
              .logout() //로그아웃에 대한 설정
                .logoutSuccessUrl("/")
            .and()
              .oauth2Login() //OAuth2설정 진입점
                .userInfoEndpoint()
                  .userService(customOAuth2UserService);
  }

}
