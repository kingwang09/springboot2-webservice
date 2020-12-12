package com.christoper.jin.web;

import com.christoper.jin.web.board.domain.BoardRepository;
import com.christoper.jin.web.board.dto.BoardDto;
import com.christoper.jin.web.board.service.BoardService;
import com.christoper.jin.web.user.domain.Role;
import com.christoper.jin.web.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Class BoardControllerTest
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiControllerTest {

  private final String ROOT_URL = "http://localhost:";
  private final String BOARD_URL = "/api/v1/board";

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private BoardService boardService;

  @Autowired
  private BoardRepository repository;

  @Before
  public void check(){
    log.info("port : {}", port);
  }

  @After
  public void clean(){
    repository.deleteAll();
  }


  @Test
  @WithMockUser(roles= "USER")
  public void 게시글등록하기(){
    String title = "컨트롤러 테스트";
    String content = "테스트는 위대하다";
    String author = "kingwang09@gmail.com";


    ResponseEntity<Long> responseEntity = 신규등록(title, content, author);
    Long responseId = responseEntity.getBody();
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseId).isGreaterThan(0L);

    확인(responseId, title, content, author);
  }

  @Test
  @WithMockUser(roles= "USER")
  public void 게시글_수정하기(){
    String title = "컨트롤러 테스트";
    String content = "테스트는 위대하다";
    String author = "kingwang09@gmail.com";

    String additionalText = "-수정하였다이이이이";

    ResponseEntity<Long> responseEntity = 신규등록(title, content, author);
    ResponseEntity<Long> updateResponse = 수정(responseEntity.getBody(), title+additionalText, content+additionalText, author+additionalText);

    확인(updateResponse.getBody(), title+additionalText, content+additionalText, author+additionalText);
  }

  private ResponseEntity<Long> 신규등록(String title, String content, String author){
    BoardDto boardDto = BoardDto.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();
    String url = ROOT_URL + port + BOARD_URL;
    ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, boardDto, Long.class);
    log.info("save response: {}", responseEntity);
    return responseEntity;
  }

  private ResponseEntity<Long> 수정(Long id, String title, String content, String author){
    String url = ROOT_URL + port + BOARD_URL +"/"+id;
    BoardDto boardDto = BoardDto.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();
    ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(boardDto), Long.class);
    log.info("update response: {}", responseEntity);
    return responseEntity;
  }

  private void 확인(Long id, String title, String content, String author){
    BoardDto resultBoard = boardService.get(id);
    assertThat(resultBoard.getTitle()).isEqualTo(title);
    assertThat(resultBoard.getContent()).isEqualTo(content);
    assertThat(resultBoard.getAuthor()).isEqualTo(author);
  }
}
