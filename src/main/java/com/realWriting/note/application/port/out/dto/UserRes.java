package com.realWriting.note.application.port.out.dto;

import com.realWriting.note.domain.Note;
import com.realWriting.note.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserRes {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class SignupRes {
        Long userId;
        String loginId;
        String nickname;

        public static UserRes.SignupRes of(User entity) {
            return SignupRes.builder()
                    .userId(entity.getId())
                    .loginId(entity.getLoginId())
                    .nickname(entity.getNickname())
                    .build();
        }
    }

    public static class LoginRes {
        String loginId;
    }
}
