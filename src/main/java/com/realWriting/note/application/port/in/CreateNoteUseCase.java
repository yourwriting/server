package com.realWriting.note.application.port.in;

import com.realWriting.note.application.port.in.dto.CreateNoteReq;
import com.realWriting.note.application.port.in.dto.CreateNoteRes;

public interface CreateNoteUseCase {
    CreateNoteRes createNote(CreateNoteReq req);
}
