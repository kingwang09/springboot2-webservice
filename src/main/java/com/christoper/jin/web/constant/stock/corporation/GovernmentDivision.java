package com.christoper.jin.web.constant.stock.corporation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GovernmentDivision {
  NONE("00", "해당 없음"),
  GOVERNMENT("01", "정부/지자체"),
  PUBLIC("02", "공공기관");

  private String code;

  private String codeName;

  public static GovernmentDivision convert(String targetCode){
    for(GovernmentDivision e : values()){
      if(e.getCode().equals(targetCode)){
        return e;
      }
    }
    return null;
  }
}
