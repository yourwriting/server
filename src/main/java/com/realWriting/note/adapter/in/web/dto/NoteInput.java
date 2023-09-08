package com.realWriting.note.adapter.in.web.dto;

import lombok.*;

import static com.realWriting.note.application.port.in.dto.NoteReq.ContentReq;

public class NoteInput {

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class ContentInput {
        private String title;
        private String content;

        public ContentReq toReq() {
            return ContentReq.builder()
                    .memberId(1L)
                    .title(title)
                    .content(content)
                    .build();
        }
    }
}
