package com.realWriting.note.adapter.in.web.dto;

import com.realWriting.note.application.port.in.dto.NoteReq;
import com.realWriting.note.application.port.in.dto.UserReq;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class UserInput {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class SignupInput {
        @NotBlank
        private String loginId;
        @NotBlank
        private String password;
        @NotBlank
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
