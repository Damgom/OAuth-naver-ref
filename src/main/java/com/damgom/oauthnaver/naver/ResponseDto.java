package com.damgom.oauthnaver.naver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    String access_token;
    String refresh_token;
    String token_type;
    String expires_in;
    String error;
    String error_description;
}
