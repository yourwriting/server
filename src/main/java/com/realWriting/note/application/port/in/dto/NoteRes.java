package com.realWriting.note.application.port.in.dto;

import com.realWriting.note.adapter.out.persistence.entity.NoteJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class NoteRes {
    Long noteId;
    String title;
    LocalDateTime createdAt;

    public static List<NoteRes> toRes(List<NoteJpaEntity> entities) {
        return entities.stream()
                .map(e -> new NoteRes(e.getId(), e.getTitle(), e.getCreatedAt()))
                .collect(Collectors.toList());
    }
}
