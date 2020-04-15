package com.christoper.jin.web;

import com.christoper.jin.web.dto.ResponseDto;
import com.christoper.jin.web.service.BoardService;
import com.christoper.jin.web.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@Controller
@RequestMapping("/board")
public class IndexController {
  private final IndexService indexService;
  private final BoardService boardService;
  @GetMapping("")
  public String main(Model model){
    model.addAttribute("boards", boardService.getList());
    return "index";
  }

  @GetMapping("/register")
  public String register(){
    return "register";
  }

  @GetMapping("/update/{id}")
  public String modify(@PathVariable Long id, Model model){
    model.addAttribute("board", boardService.get(id));
    return "update";
  }

  @GetMapping("/index/dto")
  public ResponseDto index(@RequestParam String name, @RequestParam int amount){
    return new ResponseDto(name, amount);
  }

  @GetMapping("/index")
  public String index(){
    return indexService.sayHello();
  }
}
