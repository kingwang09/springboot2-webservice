package com.christoper.jin.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //method 파라미터일 때만 사용 가능
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
