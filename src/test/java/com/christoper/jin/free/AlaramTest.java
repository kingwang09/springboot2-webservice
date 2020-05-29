package com.christoper.jin.free;

import com.christoper.jin.free.constant.FreeArticleType;
import com.christoper.jin.free.domain.FreeArticle;
import com.christoper.jin.free.service.AlarmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Class AlaramTest
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
@RunWith(SpringRunner.class)
@SpringBootTest
public class AlaramTest {

  @Autowired
  private AlarmService alarmService;

  @Test
  public void test(){
    alarmService.send(FreeArticle.builder().articleUrl("http://daum.net").title("테스트").type(FreeArticleType.JUNNGONARA).build());
  }
}
