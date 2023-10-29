package com.realWriting.user.adapter.in.web.dto;

import com.realWriting.user.application.port.in.dto.UserReq;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class UserInput {
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class SignupInput {
        @NotBlank(message = "아이디는 필수 입력 값입니다.")
        private String loginId;
        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        private String password;
        @NotBlank(message = "별명은 필수 입력 값입니다.")
        private String nickname;

        public UserReq.SignupReq toReq() {
            return UserReq.SignupReq.builder()
                    .loginId(loginId)
                    .password(password)
                    .nickname(nickname)
                    .build();
        }
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class LoginInput {
        @NotBlank(message = "아이디는 필수 입력 값입니다.")
        private String loginId;
        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        private String password;

        public UserReq.LoginReq toReq() {
            return UserReq.LoginReq.builder()
                    .loginId(loginId)
                    .password(password)
                    .build();
        }
    }
}
