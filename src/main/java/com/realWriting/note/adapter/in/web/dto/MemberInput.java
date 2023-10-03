package com.realWriting.note.adapter.in.web.dto;

import com.realWriting.note.application.port.in.dto.MemberReq;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class MemberInput {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class SignupInput {
        @NotBlank @Email
        private String email;
        @NotBlank
        private String password;
        @NotBlank
        private String nickname;

        public MemberReq.SignupReq toReq() {
            return MemberReq.SignupReq.builder()
                    .email(email)
                    .password(password)
                    .nickname(nickname)
                    .build();
        }
    }
}
