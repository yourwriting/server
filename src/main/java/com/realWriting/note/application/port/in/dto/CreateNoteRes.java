package com.realWriting.note.application.port.in.dto;

import com.realWriting.note.adapter.out.persistence.entity.NoteJpaEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateNoteRes {
    Long noteId;
    String title;
    String content;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public static CreateNoteRes toRes(NoteJpaEntity entity) {
        return CreateNoteRes.builder()
                .noteId(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
