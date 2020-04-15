package com.christoper.jin.web.service;

import com.christoper.jin.web.dto.BoardDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Class BoardServiceTest
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
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceTest {

  @Autowired
  private BoardService boardService;

  @Test
  public void 게시글추가(){
    String title = "테스트";
    String content = "하루 1 커밋";
    String author = "kingwang09@gmail.com";
    Long id = boardService.save(BoardDto.builder()
            .title(title)
            .content(content)
            .author(author)
            .build());

    BoardDto boardDto = boardService.get(id);

    assertThat(boardDto.getTitle()).isEqualTo(title);
    assertThat(boardDto.getContent()).isEqualTo(content);
    assertThat(boardDto.getAuthor()).isEqualTo(author);
  }

  @Test
  public void 전체조회(){
    게시글추가();

    List<BoardDto> boardDtoList = boardService.getList();
    assertThat(boardDtoList.size()).isEqualTo(1);
  }
}
