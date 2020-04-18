package com.christoper.jin.jpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  private LocalDateTime orderDate;

  private String orderStatus; //enum

  @Setter
  @ManyToOne
  private Member member;//단방향

  @Builder
  public Order(LocalDateTime orderDate, String orderStatus){
    this.orderDate = orderDate;
    this.orderStatus = orderStatus;
  }
}
