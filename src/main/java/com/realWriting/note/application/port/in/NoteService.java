package com.realWriting.note.application.port.in;

import com.realWriting.note.application.port.in.dto.NoteReq;
import com.realWriting.note.application.port.out.dto.NoteRes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface NoteService {
    NoteRes.ContentRes saveNote(NoteReq.ContentReq req) throws Exception;
    NoteRes.ContentRes getNote(Long id);
    NoteRes.ContentRes updateNote(Long id, NoteReq.ContentReq req);
    void deleteNote(Long id);
    List<NoteRes.ListRes> findAll();
    void uploadImage(Long id, MultipartFile image) throws IOException;
}
