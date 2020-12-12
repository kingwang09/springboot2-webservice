package com.christoper.jin.web.greeting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class GreetingApiController
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
@RequestMapping("/greeting")
@RestController
public class GreetingApiController {

  @GetMapping("")
  public String greeting(){
    return "hello";
  }
}
