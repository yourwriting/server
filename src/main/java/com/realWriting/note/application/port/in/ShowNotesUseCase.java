package com.realWriting.note.application.port.in;

import com.realWriting.note.application.port.in.dto.NoteRes;

import java.util.List;

public interface ShowNotesUseCase {
    List<NoteRes> findAll();
}
