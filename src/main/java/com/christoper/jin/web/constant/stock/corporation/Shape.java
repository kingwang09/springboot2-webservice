package com.christoper.jin.web.constant.stock.corporation;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Shape {
  CORP("01", "주식회사"),
  UNLIMITED("02", "합명회사"),
  MIXED("03", "합자회사"),
  LIMITED("04", "유한회사"),
  NON_PROFIT_FOUND("05", "비영리 재단법인"),
  NON_PROFIT_CORP("06", "비영리 사단법인"),
  UNION("07", "조합"),
  FOREIGN_CORP("08", "외국법인"),
  MEDICAL_CORP("09", "의료법인"),
  EDU_CORP("10", "학교법인"),
  RELIGION_CORP("11", "종교법인"),
  SCHOLARSHIP_CORP("12", "학술장학법인"),
  SOCIAL_CORP("13", "사회복지법인"),
  PUBLIC_CORP("14", "기타공익법인"),
  INDIVIDUAL("16", "개인기업"),
  CO_INDIVIDUAL("17", "개인동업기업"),
  GROUP("18", "법인격없는 단체"),
  LIMITED_LIABILITY("19","유한책임회사");

  private String code;

  private String codeName;

  public static Shape convert(String targetCode){
    for(Shape e : values()){
      if(e.getCode().equals(targetCode)){
        return e;
      }
    }
    return null;
  }
}
