package com.realWriting.note.adapter.in.web.dto;

import com.realWriting.note.application.port.in.dto.NoteRes;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class NoteOutput {
    Long noteId;
    String title;
    LocalDateTime createdAt;

    public static List<NoteOutput> toOutput(List<NoteRes> res) {
        return res.stream()
                .map(r -> new NoteOutput(r.getNoteId(), r.getTitle(), r.getCreatedAt()))
                .collect(Collectors.toList());
    }
}
