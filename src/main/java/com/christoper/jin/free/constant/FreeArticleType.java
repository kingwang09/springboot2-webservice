package com.christoper.jin.free.constant;


import lombok.Getter;

@Getter
public enum FreeArticleType {
  /**
   * upperArticleList의 siblingElement
   */
  JUNNGONARA("https://cafe.naver.com","/ArticleList.nhn?search.clubid=10050146&search.menuid=96&search.boardtype=L&search.totalCount=151&search.page=1", "upperArticleList");

  FreeArticleType(String mainURL, String listURL, String targetElement) {
    this.mainURL = mainURL;
    this.listURL = listURL;
    this.targetElement = targetElement;
  }

  private String mainURL;
  private String listURL;
  private String targetElement;
}
