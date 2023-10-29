package com.realWriting.user.application.port.out.dto;

import com.realWriting.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserRes {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class SignupRes {
        Long id;
        String loginId;
        String nickname;

        public static UserRes.SignupRes of(User entity) {
            return SignupRes.builder()
                    .id(entity.getId())
                    .loginId(entity.getLoginId())
                    .nickname(entity.getNickname())
                    .build();
        }
    }

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class LoginRes {
        String loginId;
        String nickname;
        String accessToken;

        public static UserRes.LoginRes of(User entity, String accessToken) {
            return LoginRes.builder()
                    .loginId(entity.getLoginId())
                    .nickname(entity.getNickname())
                    .accessToken(accessToken)
                    .build();
        }
    }
}
