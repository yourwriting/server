package com.realWriting.member.adapter.in.web.dto;

import com.realWriting.member.application.port.in.dto.UserReq;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class UserInput {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class SignupInput {
        @NotBlank(message = "필수 입력 값입니다.")
        private String loginId;
        @NotBlank(message = "필수 입력 값입니다.")
        private String password;
        @NotBlank(message = "필수 입력 값입니다.")
        private String nickname;

        public UserReq.SignupReq toReq() {
            return UserReq.SignupReq.builder()
                    .loginId(loginId)
                    .password(password)
                    .nickname(nickname)
                    .build();
        }
    }
}
