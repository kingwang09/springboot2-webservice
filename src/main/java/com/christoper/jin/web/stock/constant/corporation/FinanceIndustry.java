package com.christoper.jin.web.stock.constant.corporation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FinanceIndustry {
  MANUFACTURE("01", "제조 업종"),
  BANK("02", "은행 업종"),
  INSURANCE("03", "보험 업종"),
  STOCK("04", "증권 업종"),
  CREDIT("06", "신용 업종"),
  FINANCE("07", "종합(금융) 업종"),
  LOAN("08", "여신 업종"),
  FOUNDED("09", "창업투자 업종");

  private String code;
  private String codeName;

  public static FinanceIndustry convert(String targetCode){
    for(FinanceIndustry e : values()){
      if(e.getCode().equals(targetCode)){
        return e;
      }
    }
    return null;
  }
}
