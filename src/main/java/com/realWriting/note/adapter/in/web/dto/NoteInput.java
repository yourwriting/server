package com.realWriting.note.adapter.in.web.dto;

import com.realWriting.note.application.port.in.dto.NoteReq;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class NoteInput {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class ContentInput {
        @NotBlank(message = "필수 입력 값입니다.")
        private String title;
        @NotBlank(message = "필수 입력 값입니다.")
        private String content;

        public NoteReq.ContentReq toReq(Long userId) {
            return NoteReq.ContentReq.builder()
                    .userId(userId)
                    .title(title)
                    .content(content)
                    .build();
        }
    }
}
