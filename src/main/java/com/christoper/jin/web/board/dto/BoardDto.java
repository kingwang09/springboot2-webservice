package com.christoper.jin.web.board.dto;

import com.christoper.jin.web.board.domain.board.Board;
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
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
  private Long id;

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
    this.id = board.getId();
  }
}
