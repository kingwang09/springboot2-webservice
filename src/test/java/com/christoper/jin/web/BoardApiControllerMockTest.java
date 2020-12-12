package com.christoper.jin.web;

import com.christoper.jin.web.board.domain.Board;
import com.christoper.jin.web.board.domain.BoardRepository;
import com.christoper.jin.web.board.dto.BoardDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Class BoardApiControllerMockTest
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 12. 12.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 12. 12. || 진형은 || 최초생성
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiControllerMockTest {


  private MockMvc mvc;
  private final String ROOT_URL = "http://localhost:";
  private final String BOARD_URL = "/api/v1/board";

  @Autowired
  private WebApplicationContext context;

  @LocalServerPort
  private int port;

  @Autowired
  private BoardRepository repository;

  @Before
  public void setup(){
    mvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(springSecurity())
            .build();
  }

  @Test
  @WithMockUser(roles="USER")
  public void 게시글_등록() throws Exception {
    String url = ROOT_URL + port + BOARD_URL;
    String title = "테스트";
    String content = "테스트 게시글이여잉";
    String author = "hyungeun.jin@wadiz.kr";

    //given
    BoardDto newBoardDto = BoardDto.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();

    //when
    mvc.perform(
            post(url)
              .contentType(MediaType.APPLICATION_JSON_UTF8)
              .content(new ObjectMapper().writeValueAsString(newBoardDto))
    ).andExpect(status().isOk());


    //then
    List<Board> all = repository.findAll();

    assertThat(all.get(0).getTitle()).isEqualTo(title);
    assertThat(all.get(0).getContent()).isEqualTo(content);
  }


  @Test
  @WithMockUser(roles = "USER")
  public void 게시글_수정() throws Exception {
    String title = "테스트 (수정)";
    String content = "테스트 게시글이여잉(수정)";
    String author = "hyungeun.jin@wadiz.kr";

    //given
    Board createBoard = Board.builder()
            .title("Dummy-title")
            .content("Dummy-content")
            .author("Dummy-author")
            .build();
    repository.save(createBoard);
    log.debug("create Board Id: {}", createBoard.getId());
    String url = ROOT_URL + port + BOARD_URL +"/"+createBoard.getId();

    BoardDto modifyBoard = BoardDto.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();
    //when
    mvc.perform(
            put(url)
              .contentType(MediaType.APPLICATION_JSON_UTF8)
              .content(new ObjectMapper().writeValueAsString(modifyBoard))
    ).andExpect(status().isOk());

    //then
    Board assertBoard = repository.findById(createBoard.getId()).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    assertThat(assertBoard.getTitle()).isEqualTo(title);
    assertThat(assertBoard.getContent()).isEqualTo(content);
  }
}
