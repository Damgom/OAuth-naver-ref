package com.damgom.oauthnaver.naver;

import com.damgom.oauthnaver.feign.LoginFeign;
import com.damgom.oauthnaver.feign.ProfileFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NaverService {

    private final LoginFeign loginFeign;
    private final ProfileFeign profileFeign;

    @Value("${oauth.naver.client_id}")
    private String client_id;
    @Value("${oauth.naver.client_secret}")
    private String client_secret;
    @Value("${oauth.naver.callback}")
    private String redirect_uri;

    public String getRequireUrl() {
        String reqUrl = "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=" + client_id
                + "&redirect_uri=" + redirect_uri + "&state=1546578234123";
        return reqUrl;
    }

    public ProfileResponseDto loginService(String code, String state) {
        ResponseDto responseDto =
                loginFeign.login("authorization_code", client_id, client_secret, code, state);
        String accessToken = "Bearer " + responseDto.access_token;
        log.info("accessToken = {}" , accessToken);
        ProfileResponseDto profileResponseDto = profileFeign.getProfile(accessToken);
        log.info("email = {}", profileResponseDto.getResponse().getEmail());
        return profileResponseDto;
    }
}
