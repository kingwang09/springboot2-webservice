package com.christoper.jin.notification.constant;

import lombok.Getter;

@Getter
public enum WebHook {
  SLACK_FREE_MARKET("https://hooks.slack.com/services/");

  private String webbHookURL;

  WebHook(String webbHookURL){
    this.webbHookURL = webbHookURL;
  }
}
