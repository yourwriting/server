package com.realWriting.user.application.port.in.dto;

import lombok.*;

public class UserReq {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class SignupReq {
        private String loginId;
        private String password;
        private String nickname;
    }

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class LoginReq {
        private String loginId;
        private String password;
    }
}
