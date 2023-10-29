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

        public NoteReq.ContentReq toReq() {
            return NoteReq.ContentReq.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }
}
