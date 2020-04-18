package com.christoper.jin.jpa.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @Class Member
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
@Getter
@NoArgsConstructor
@Entity
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String city;

  private String street;

  private String zipCode;

  @Setter
  @ManyToOne
  private Team team;

  @Builder
  public Member(String name, String city, String street, String zipCode){
    this.name = name;
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;
  }

  public void setTeam(Team team){
    this.team = team;

    //양방향 연관관계일 때 객체지향 관점에서 추가 작업
    if(team.getMemberList() != null){
      team.getMemberList().remove(this);
    }
    team.getMemberList().add(this);
  }
}
