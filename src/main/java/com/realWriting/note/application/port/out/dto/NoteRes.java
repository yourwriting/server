package com.realWriting.note.application.port.out.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.realWriting.note.domain.Image;
import com.realWriting.note.domain.Note;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class NoteRes {
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class ContentRes {
        Long noteId;
        String title;
        String content;
        LocalDateTime createdAt;
        LocalDateTime updatedAt;
        List<FileRes> fileResList;

        public static ContentRes of(Note entity, List<FileRes> fileResList) {
            return ContentRes.builder()
                    .noteId(entity.getId())
                    .title(entity.getTitle())
                    .content(entity.getContent())
                    .createdAt(entity.getCreatedAt())
                    .updatedAt(entity.getUpdatedAt())
                    .fileResList(fileResList)
                    .build();
        }
    }

    @AllArgsConstructor
    @Getter
    public static class ListRes {
        Long noteId;
        String title;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
        LocalDateTime createdAt;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
        LocalDateTime updatedAt;

        public static List<ListRes> of(List<Note> entities) {
            return entities.stream()
                    .map(e -> new ListRes(e.getId(), e.getTitle(), e.getCreatedAt(), e.getUpdatedAt()))
                    .collect(Collectors.toList());
        }
    }

    @Getter
    @Builder
    public static class FileRes {
        private String fileUrl;
        private String originFileName;

        public static FileRes of(Image image) {
            return FileRes.builder()
                    .fileUrl(image.getFileUrl())
                    .originFileName(image.getOriginFileName())
                    .build();
        }
    }
}
