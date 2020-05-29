package com.christoper.jin.notification.slack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @Class SlackBase
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
@Builder
@AllArgsConstructor
@Getter @Setter
public class SlackBase {
  private String text;
}
