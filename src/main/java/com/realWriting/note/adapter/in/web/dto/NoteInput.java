package com.realWriting.note.adapter.in.web.dto;

import com.realWriting.note.application.port.in.dto.NoteReq;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class NoteInput {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class ContentInput {
        private String title;
        private String content;

        public NoteReq.ContentReq toReq(List<MultipartFile> files) {
            return NoteReq.ContentReq.builder()
                    .title(title)
                    .content(content)
                    .files(files)
                    .build();
        }
    }
}
