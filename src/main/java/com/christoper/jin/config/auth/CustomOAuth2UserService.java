package com.christoper.jin.config.auth;

import com.christoper.jin.config.auth.dto.OAuthAttributes;
import com.christoper.jin.config.auth.dto.SessionUser;
import com.christoper.jin.web.board.domain.user.User;
import com.christoper.jin.web.board.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

/**
 * @Class CustomOAuth2UserService
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 4. 15.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 4. 15. || 진형은 || 최초생성
 */
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

  private final UserRepository userRepository;
  private final HttpSession httpSession;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    OAuth2UserService delegate = new DefaultOAuth2UserService();
    OAuth2User oAuth2User = delegate.loadUser(userRequest);


    String registrationId = userRequest.getClientRegistration().getRegistrationId(); //현재로그인 진행중인 서비스 구분하는 코드 (구글만 사용함)
    String userNameAttributeName = userRequest.getClientRegistration()
                                        .getProviderDetails()
                                          .getUserInfoEndpoint()
                                            .getUserNameAttributeName(); // OAuth2 로그인 진행시 키가되는 필드값 (PK)
    OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
    User user = saveOrUpdate(attributes);
    httpSession.setAttribute("user", new SessionUser(user));
    return new DefaultOAuth2User(
            Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                    attributes.getAttributes(),
                    attributes.getNameAttributeKey()
    );
  }

  private User saveOrUpdate(OAuthAttributes attributes) {
    User user = userRepository.findByEmail(attributes.getEmail())
            .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
            .orElse(attributes.toEntity());
    return userRepository.save(user);
  }
}
