package com.realWriting.note.application.port.in;

import com.realWriting.note.application.port.in.dto.NoteRes;

import java.util.List;

import static com.realWriting.note.application.port.in.dto.NoteReq.ContentReq;
import static com.realWriting.note.application.port.in.dto.NoteRes.ContentRes;

public interface NoteService {
    ContentRes createNote(ContentReq req);
    ContentRes updateNote(Long id, ContentReq req);
    void delete(Long id);
    List<NoteRes.ListRes> findAll();
}
