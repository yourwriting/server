package com.realWriting.note.application.port.in.dto;

import com.realWriting.note.domain.Note;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class NoteReq {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class CreateReq {
        private Long memberId;
        private String title;
        private String content;
        private List<MultipartFile> files;

        public Note toEntity() {
            return Note.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class ContentReq {
        private String title;
        private String content;
        private List<MultipartFile> files;

        public Note toEntity() {
            return Note.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }
}
