package com.christoper.jin.web.stock.constant.corporation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Scale {
  MAJOR_CORP("01", "대기업"),
  MIDDLE_CORP("02", "중기업"),
  SMALL_CORP("03", "소기업"),
  LIMITED_SMALL_CORP("04", "한시성중소기업"),
  MAJOR_MIDDLE_CORP("05", "중견기업"),
  SMALL("06", "소상공인");

  private String code;
  private String codeName;

  public static Scale convert(String targetCode){
    for(Scale e : values()){
      if(e.getCode().equals(targetCode)){
        return e;
      }
    }
    return null;
  }
}
