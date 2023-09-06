package com.realWriting.note.adapter.in.web.dto;

import com.realWriting.note.application.port.in.dto.CreateNoteRes;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class CreateNoteOutput {
    Long noteId;
    String title;
    String content;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public static CreateNoteOutput toOutput(CreateNoteRes res) {
        return CreateNoteOutput.builder()
                .noteId(res.getNoteId())
                .title(res.getTitle())
                .content(res.getContent())
                .createdAt(res.getCreatedAt())
                .updatedAt(res.getUpdatedAt())
                .build();
    }
}