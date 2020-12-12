package com.christoper.jin.config.auth.dto;

import com.christoper.jin.web.user.domain.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * @Class SessionUser
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
@Getter
public class SessionUser implements Serializable {
  private String name;
  private String email;
  private String picture;

  public SessionUser(User user){
    this.name = user.getName();
    this.email = user.getEmail();
    this.picture = user.getPicture();
  }
}
