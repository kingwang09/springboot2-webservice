package com.christoper.jin.web.free.domain;

import com.christoper.jin.web.free.constant.FreeArticleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Class FreeArticle
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 5. 29.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 5. 29. || 진형은 || 최초생성
 */
@NoArgsConstructor
@Getter
@Entity
public class FreeArticle {
  @Id
  private String articleUrl;

  @Enumerated(EnumType.STRING)
  private FreeArticleType type;

  private String title;

  @Builder
  public FreeArticle(FreeArticleType type, String articleUrl, String title) {
    this.type = type;
    this.articleUrl = articleUrl;
    this.title = title;
  }

  public String getDetailLink(){
    if(articleUrl != null){
      return FreeArticleType.JUNNGONARA.getMainURL() + articleUrl;
    }
    return null;
  }
}
