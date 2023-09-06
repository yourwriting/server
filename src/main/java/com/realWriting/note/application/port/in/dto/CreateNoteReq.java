package com.realWriting.note.application.port.in.dto;

import com.realWriting.note.adapter.in.web.dto.CreateNoteInput;
import lombok.Data;

@Data
public class CreateNoteReq {
    Long memberId;
    String title;
    String content;

    public static CreateNoteReq toReq(CreateNoteInput input) {
        CreateNoteReq req = new CreateNoteReq();
        req.memberId = 1L;
        req.title = input.getTitle();
        req.content = input.getContent();
        return req;
    }
}
