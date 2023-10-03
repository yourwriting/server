package com.realWriting.note.application.port.in.dto;

import com.realWriting.note.domain.Member;
import com.realWriting.note.domain.Note;
import lombok.*;

public class MemberReq {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class SignupReq {
        private String email;
        private String password;
        private String nickname;

        public Member toEntity() {
            return Member.builder()
                    .email(email)
                    .password(password)
                    .nickname(nickname)
                    .build();
        }
    }
}
