package com.christoper.jin.web.board.domain.user;

import com.christoper.jin.support.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Class User
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
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false)
  private String name;

  @Column(nullable=false)
  private String email;

  @Column
  private String picture;

  @Enumerated(value=EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  @Builder
  public User(String name, String email, String picture, Role role){
    this.name = name;
    this.email = email;
    this.picture = picture;
    this.role = role;
  }

  public User update(String name, String picture){
    this.name = name;
    this.picture = picture;
    return this;
  }

  public String getRoleKey(){
    return this.role.getKey();
  }
}
