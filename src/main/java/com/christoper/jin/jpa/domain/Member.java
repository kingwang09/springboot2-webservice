package com.christoper.jin.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Class Member
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 4. 18.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 4. 18. || 진형은 || 최초생성
 */
@Getter
@Entity
@NoArgsConstructor
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String city;

  private String street;

  private String zipCode;

  @Builder
  public Member(String name, String city, String street, String zipCode){
    this.name = name;
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;
  }
}
