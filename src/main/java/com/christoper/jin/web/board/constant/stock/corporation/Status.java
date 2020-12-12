package com.christoper.jin.web.board.constant.stock.corporation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
  NORMAL("01", "정상"),
  CORPORATION_TRANSITION("02", "법인 전환"),
  CLOSE_TEMP("03", "휴업"),
  CLOSE("04", "폐업"),
  DISMISS("05", "청산/해산"),
  MERGED("06", "합병"),
  DELETE_REQUESTED("88", "삭제 요청"),
  ETC("99", "기타");

  private String code;

  private String codeName;

  public static Status convert(String targetCode){
    for(Status e : values()){
      if(e.getCode().equals(targetCode)){
        return e;
      }
    }
    return null;
  }
}
