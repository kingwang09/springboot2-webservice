package com.christoper.jin.web.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Class UserController
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
@Controller
public class UserController {
  @GetMapping("/login/form")
  public String loginForm(){
    return "login";
  }
}
