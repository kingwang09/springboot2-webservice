# Todo List
## Board 서비스
- 이미지/첨부파일 기능 추가

## 기업 서비스
- 기본 조회 로직 구현


### SpringBoot2 + Spring-Data-JPA

#### 1-Day
- spring 기초 구성 완료
- spring-data-jpa 설정 완료
- Board 게시판 등록 완료
  - 등록 기능 완료
  - 수정 기능 완료
  - 조회 기능 완료

#### 2-Day
- Spring-Security with OAuth2
  - spring.security.oauth2.client.registration.google.client-id={클라이언트-ID}
  - spring.security.oauth2.client.registration.google.client-secret={클라이언트-Secret 비밀번호}
  - spring.security.oauth2.client.registration.google.scope=profile,email
- Google OAuth2 구현
- 왜 Git 활동이력이 안남는가
- 이거 git config email로 활동이력을 추적하는듯함.


#### 3-Day
- Spring-Session-JDBC 적용
- Naver, Kakao OAuth2 적용
    - 듸지는줄 알았음....


nohup java -jar -Dspring.config.location=classpath:/application.properties,/path/application-oauth.properties springboot2-webservice-1.0-SNAPSHOT.jar&
