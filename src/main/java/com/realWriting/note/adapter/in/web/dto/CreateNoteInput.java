package com.realWriting.note.adapter.in.web.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateNoteInput {
    String title;
    String content;
}
