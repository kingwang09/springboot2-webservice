package com.christoper.jin.jpa.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Class OrderItem
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
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Order order;

  @ManyToOne
  private Item item;

  private long orderPrice;

  private int count;
}
