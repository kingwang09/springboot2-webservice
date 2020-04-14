package com.christoper.jin.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Class ResponseDto
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
@RequiredArgsConstructor
public class ResponseDto {
  private final String name;
  private final int amount;
}
