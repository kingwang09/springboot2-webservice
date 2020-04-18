package com.christoper.jin.jpa;

import com.christoper.jin.jpa.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {
  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private TeamRepository teamRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private OrderItemRepository orderItemRepository;

  @Autowired
  private ItemRepository itemRepository;


  @Test
  public void 멤버테스트(){
    Member member = Member.builder()
            .name("진형은")
            .city("경기도")
            .street("성남시 수정구 태평4동 시민로")
            .zipCode("1234")
            .build();
    Team team = Team.builder().name("개발2랩").build();

    teamRepository.save(team);

    member.setTeam(team);
    memberRepository.save(member);


    List<Member> memberList = memberRepository.findAll();
    for(Member m : memberList){
      log.info("이름 : {}", m.getName());
      log.info("팀이름 : {}", m.getTeam().getName());
    }
  }
}
