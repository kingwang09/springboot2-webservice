package com.christoper.jin.web.domain.board;

import lombok.*;

import javax.persistence.*;

/**
 * @Class Board
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
@ToString
@Getter
@NoArgsConstructor
@Entity
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //GenerationType 차이점에 대해 알아보기
  private Long id;

  @Column(length = 500, nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  private String author;

  @Builder
  public Board(String title, String content, String author){
    this.title = title;
    this.content = content;
    this.author = author;
  }
}
