package com.realWriting.note.application.port.in;

import com.realWriting.note.application.port.in.dto.NoteReq;
import com.realWriting.note.application.port.out.dto.NoteRes;
import com.realWriting.user.domain.User;

import java.util.List;

public interface NoteService {
    NoteRes.ContentRes saveNote(NoteReq.ContentReq req, User user) throws Exception;
    NoteRes.ContentRes getNote(Long id);
    NoteRes.ContentRes updateNote(Long id, NoteReq.ContentReq req);
    void deleteNote(Long id);
    List<NoteRes.ListRes> findAll(Long userId);
}
