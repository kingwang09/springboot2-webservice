package com.christoper.jin.jpa;

import com.christoper.jin.jpa.domain.ItemRepository;
import com.christoper.jin.jpa.domain.MemberRepository;
import com.christoper.jin.jpa.domain.OrderItemRepository;
import com.christoper.jin.jpa.domain.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Class JpaTest
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 4. 18.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 4. 18. || 진형은 || 최초생성
 */
@Slf4j
@SpringBootTest
public class JpaTest {
  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private OrderItemRepository orderItemRepository;

  @Autowired
  private ItemRepository itemRepository;


  @Test
  public void 모든객체생성(){
  }
}
