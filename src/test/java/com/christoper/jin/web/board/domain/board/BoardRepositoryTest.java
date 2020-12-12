package com.christoper.jin.web.board.domain.board;

import com.christoper.jin.web.board.domain.Board;
import com.christoper.jin.web.board.domain.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Class BoardRepositoryTest
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
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

  @Autowired
  private BoardRepository repository;

  @After //junit이 끝날때마다 실행
  public void clean(){
    repository.deleteAll();
  }

  @Test
  public void 게시글(){
    String title = "테스트 게시판";
    String content = "오늘부터 1일 1커밋";

    repository.save(Board.builder()
            .title(title)
            .content(content)
            .author("kingwang09@gmail.com")
            .build());

    List<Board> boardList = repository.findAll();
    for(Board board : boardList){
      log.info("board: {}", board);
      assertThat(board.getTitle()).isEqualTo(title);
      assertThat(board.getContent()).isEqualTo(content);
    }
  }
}
