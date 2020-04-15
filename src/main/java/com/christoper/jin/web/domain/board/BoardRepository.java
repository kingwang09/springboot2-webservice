package com.christoper.jin.web.domain.board;

import com.christoper.jin.web.dto.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
