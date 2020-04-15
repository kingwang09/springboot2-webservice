package com.christoper.jin.web.service;

import com.christoper.jin.web.domain.board.Board;
import com.christoper.jin.web.domain.board.BoardRepository;
import com.christoper.jin.web.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Class BoardService
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
@Service
public class BoardService {

  private final BoardRepository repository;

  public Long save(BoardDto boardDto){
    return repository.save(boardDto.toEntity()).getId();
  }

  public BoardDto get(Long id){
    Optional<Board> boardOptional = repository.findById(id);
    return new BoardDto(boardOptional.orElseThrow(() -> new RuntimeException("없음.")));
  }

  @Transactional
  public Long update(Long id, BoardDto boardDto) {
    Board board = repository.findById(id).orElseThrow(() -> new RuntimeException("없다이."));
    board.update(boardDto);
    return board.getId();
  }

  public List<BoardDto> getList() {
    List<Board> boardList = repository.findAll(Sort.by(Sort.Order.desc("id")));
    return boardList.stream().map(BoardDto::new).collect(Collectors.toList());
  }
}
