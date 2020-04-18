package com.christoper.jin.jpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Class Order
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
@NoArgsConstructor
@Entity
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Member member;

  private LocalDateTime orderDate;

  private String orderStatus; //enum

  @Builder
  public Order(Member member, LocalDateTime orderDate, String orderStatus){
    this.member = member;
    this.orderDate = orderDate;
    this.orderStatus = orderStatus;
  }
}
