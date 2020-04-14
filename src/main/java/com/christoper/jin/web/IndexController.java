package com.christoper.jin.web;

import com.christoper.jin.web.dto.ResponseDto;
import com.christoper.jin.web.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class IndexController
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 4. 14.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 4. 14. || 진형은 || 최초생성
 */
@RequiredArgsConstructor
@RestController
public class IndexController {
  private final IndexService indexService;

  @GetMapping("/index")
  public String index(){
    return indexService.sayHello();
  }

  @GetMapping("/index/dto")
  public ResponseDto index(@RequestParam String name, @RequestParam int amount){
    return new ResponseDto(name, amount);
  }
}
