package com.christoper.jin.web.dto;

import com.christoper.jin.web.domain.board.Board;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 * @Class BoardDto
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
  private String title;

  private String content;

  private String author;

  public Board toEntity() {
    return Board.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();
  }

  public BoardDto(Board board){
    this.title = board.getTitle();
    this.content = board.getContent();
    this.author = board.getAuthor();
  }
}
