package com.realWriting.note.adapter.out.persistence.dto;

import com.realWriting.note.application.port.out.dto.NoteRes;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class NoteOutput {

    @Data
    @AllArgsConstructor
    public static class ListOutput {
        Long noteId;
        String title;
        LocalDateTime createdAt;
        LocalDateTime updatedAt;

        public static List<ListOutput> of(List<NoteRes.ListRes> res) {
            return res.stream()
                    .map(r -> new ListOutput(r.getNoteId(), r.getTitle(), r.getCreatedAt(), r.getUpdatedAt()))
                    .collect(Collectors.toList());
        }
    }
}
