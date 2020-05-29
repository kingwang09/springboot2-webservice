package com.christoper.jin.notification.constant;

import lombok.Getter;

@Getter
public enum WebHook {
  SLACK_FREE_MARKET("https://hooks.slack.com/services/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");

  private String webbHookURL;

  WebHook(String webbHookURL){
    this.webbHookURL = webbHookURL;
  }
}
