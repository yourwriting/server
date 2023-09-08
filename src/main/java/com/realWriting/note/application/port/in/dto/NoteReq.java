package com.realWriting.note.application.port.in.dto;

import lombok.*;

public class NoteReq {

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class ContentReq {
        private Long memberId;
        private String title;
        private String content;
    }
}
