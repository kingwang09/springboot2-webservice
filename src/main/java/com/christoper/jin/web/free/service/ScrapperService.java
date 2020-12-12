package com.christoper.jin.web.free.service;

import com.christoper.jin.web.free.constant.FreeArticleType;
import com.christoper.jin.web.free.domain.FreeArticle;
import com.christoper.jin.web.free.repository.FreeArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Class JunggonaraScrapperService
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
@RequiredArgsConstructor
@Slf4j
@Service
public class ScrapperService {

  private final FreeArticleRepository repository;

  private final AlarmService alarmService;

  public void junggonaraScrapper() throws IOException {
    FreeArticleType junngonara = FreeArticleType.JUNNGONARA;

    Document document = Jsoup.connect(junngonara.getMainURL() + junngonara.getListURL()).get();
    Element targetElement = document.getElementById(junngonara.getTargetElement());
    log.debug("targetElement: {}", targetElement);

    Element articleDiv = targetElement.nextElementSibling();

    Elements articleList = articleDiv.select("a.article");
    for (Element article : articleList) {
      FreeArticle freeArticle = FreeArticle.builder()
              .type(junngonara)
              .title(article.ownText())
              .articleUrl(article.attr("href"))
              .build();
      boolean isExist = repository.existsById(freeArticle.getArticleUrl());
      if (!isExist) {
        repository.save(freeArticle);
        alarmService.send(freeArticle);
      }
    }
  }
}
