package com.christoper.jin.web.board.domain.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Class Financial
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 4. 23.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 4. 23. || 진형은 || 최초생성
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Financial {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String corporationCode;

  private LocalDateTime settlementDate;//결산일

  private Long totalAsset;

  private Long capital;
  private Long totalCapital;

  private Long sales;

  private Long businessProfits;
  private Long profit;


  @ManyToOne
  //@JoinColumn(name="corporation_code", foreignKey = @ForeignKey(name = "corporation_code"))
  private Corporation corporation;
}
