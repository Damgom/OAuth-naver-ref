package com.damgom.oauthnaver.naver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class NaverController {

    private final NaverService naverService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/naver/auth")
    @ResponseBody
    public ProfileResponseDto getCode(@RequestParam String code, @RequestParam String state) {
        return naverService.loginService(code, state);
    }

    @ResponseBody
    @PostMapping("/oauth/naver")
    public String loginUrlGoogle(){

        return naverService.getRequireUrl();
    }
}
