package com.christoper.jin.web.free;

import com.christoper.jin.web.free.service.ScrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Class FreeArticleController
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 5. 29.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 5. 29. || 진형은 || 최초생성
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/scrapper")
public class FreeArticleController {

  private final ScrapperService scrapperService;
  @GetMapping("/junggonara")
  public String junggonara(){
    try {
      scrapperService.junggonaraScrapper();
    } catch (IOException e) {
      return "error";
    }
    return "success";
  }
}
