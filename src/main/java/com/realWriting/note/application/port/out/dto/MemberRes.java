package com.realWriting.note.application.port.out.dto;

import com.realWriting.note.domain.Member;
import com.realWriting.note.domain.Note;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class MemberRes {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class SignupRes {
        String nickname;
        String email;

        public static MemberRes.SignupRes of(Member entity) {
            return SignupRes.builder()
                    .nickname(entity.getNickname())
                    .email(entity.getEmail())
                    .build();
        }
    }
}
