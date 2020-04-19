package com.christoper.jin.web.constant.stock.corporation;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstablishedShape {
  NEW("01", "신설(신규)"),
  CORPORATION_TRANSITION("02", "법인 전환"),
  MERGE_NEW("03", "신설(합병)"),
  SEPARATED_NEW("04", "신설(분할)"),
  INHERITANCE("05", "사업 상속"),
  ETC("06", "기타");

  private String code;
  private String codeName;

  public static EstablishedShape convert(String targetCode){
    for(EstablishedShape e : values()){
      if(e.getCode().equals(targetCode)){
        return e;
      }
    }
    return null;
  }
}
