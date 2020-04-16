package com.christoper.jin.web;

import com.christoper.jin.config.auth.LoginUser;
import com.christoper.jin.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @Class IndexController
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
@Controller
public class IndexController {

  private final HttpSession httpSession;
  @GetMapping("")
  public String index(Model model, @LoginUser SessionUser user){
    model.addAttribute("user", user);
    return "index";
  }
}
