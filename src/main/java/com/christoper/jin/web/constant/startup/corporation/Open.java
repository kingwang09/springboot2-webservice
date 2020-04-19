package com.christoper.jin.web.constant.startup.corporation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Open {
  ALL("0", "전체"),
  SECURITIES_MARKET("1", "유가증권"),
  KOSDAQ("2", "KOSDAQ"),
  FINANCIAL_SUPERVISORY("3", "금융감독위원회 등록"),
  INDEPENDENT_AUDITOR("4", "외감 법인"),
  CORPORATION("5", "일반 법인"),
  INDIVIDUAL("6", "개인사업자"),
  KONEX("7", "KONEX"),
  ETC("9", "기타");

  private String code;
  private String codeName;

  public static Open convert(String targetCode){
    for(Open e : values()){
      if(e.getCode().equals(targetCode)){
        return e;
      }
    }
    return null;
  }

}
