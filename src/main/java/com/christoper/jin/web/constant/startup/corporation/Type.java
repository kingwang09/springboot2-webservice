package com.christoper.jin.web.constant.startup.corporation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Type {
  CORPORATION("법인기업"), INDIVIDUAL("개인기업");

  private String displayName;
}
