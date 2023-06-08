package com.damgom.oauthnaver.naver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponseDto {

    public String resultcode;
    public String message;
    public Response response;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {

        public String id;
//        public String nickname;
//        public String name;
        public String email;
//        public String gender;
//        public String age;
//        public String birthday;
//        public String profile_image;
//        public String birthyear;
//        public String mobile;
    }
}
