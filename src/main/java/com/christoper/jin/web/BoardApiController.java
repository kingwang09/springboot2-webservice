package com.christoper.jin.web;

import com.christoper.jin.web.dto.BoardDto;
import com.christoper.jin.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Class BoardController
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
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/board")
public class BoardApiController {

  private final BoardService boardService;

  @PostMapping("")
  public Long save(@RequestBody BoardDto boardDto){
    return boardService.save(boardDto);
  }

  @PutMapping("/{id}")
  public Long update(@PathVariable Long id, @RequestBody BoardDto boardDto){
    return boardService.update(id, boardDto);
  }

  @GetMapping("/{id}")
  public BoardDto get(@PathVariable Long id){
    return boardService.get(id);
  }

  @DeleteMapping("/{id}")
  public Long delete(@PathVariable Long id){
    boardService.remove(id);
    return id;
  }
}
