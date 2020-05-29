package com.christoper.jin.free.service;

import com.christoper.jin.free.domain.FreeArticle;
import com.christoper.jin.notification.constant.WebHook;
import com.christoper.jin.notification.slack.model.SlackBase;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Class AlaramService
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
@Service
public class AlarmService {

  public void send(FreeArticle freeArticle) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
    SlackBase params = SlackBase.builder().text(freeArticle.getTitle()+", "+freeArticle.getDetailLink()).build();
    restTemplate.exchange(WebHook.SLACK_FREE_MARKET.getWebbHookURL(), HttpMethod.POST, new HttpEntity<SlackBase>(params, headers), (Class<Object>) null);
  }
}
