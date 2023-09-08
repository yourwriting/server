package com.realWriting.note.application.port.in.dto;

import com.realWriting.note.adapter.out.persistence.entity.NoteJpaEntity;
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

        public static ContentRes of(NoteJpaEntity entity) {
            return ContentRes.builder()
                    .noteId(entity.getId())
                    .title(entity.getTitle())
                    .content(entity.getContent())
                    .createdAt(entity.getCreatedAt())
                    .updatedAt(entity.getUpdatedAt())
                    .build();
        }
    }

    @AllArgsConstructor
    @Getter
    public static class ListRes {
        Long noteId;
        String title;
        LocalDateTime createdAt;
        LocalDateTime updatedAt;

        public static List<ListRes> of(List<NoteJpaEntity> entities) {
            return entities.stream()
                    .map(e -> new ListRes(e.getId(), e.getTitle(), e.getCreatedAt(), e.getUpdatedAt()))
                    .collect(Collectors.toList());
        }
    }
}
