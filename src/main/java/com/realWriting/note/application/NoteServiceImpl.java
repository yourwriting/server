package com.realWriting.note.application;

import com.realWriting.global.error.exception.NoteNotFoundException;
import com.realWriting.note.application.port.in.NoteService;
import com.realWriting.note.application.port.in.dto.NoteReq;
import com.realWriting.note.application.port.out.dto.NoteRes;
import com.realWriting.note.application.port.out.NotePersistencePort;
import com.realWriting.note.domain.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.realWriting.global.error.ErrorCode.NOTE_NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NotePersistencePort notePersistencePort;

    @Override
    public NoteRes.ContentRes saveNote(NoteReq.ContentReq req) {
        return notePersistencePort.save(req.toEntity());
    }

    @Transactional(readOnly = true)
    @Override
    public NoteRes.ContentRes getNote(Long id) {
        Note entity = notePersistencePort.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(NOTE_NOT_FOUND));
        return NoteRes.ContentRes.of(entity);
    }

    @Override
    public NoteRes.ContentRes updateNote(Long id, NoteReq.ContentReq req) {
        Note entity = notePersistencePort.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(NOTE_NOT_FOUND))
                .update(req.getTitle(), req.getContent());
        return notePersistencePort.update(entity);
    }

    @Override
    public void deleteNote(Long id) {
        notePersistencePort.findById(id)
                        .orElseThrow(() -> new NoteNotFoundException(NOTE_NOT_FOUND));
        notePersistencePort.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<NoteRes.ListRes> findAll() {
        List<Note> entities = notePersistencePort.findAll();
        return NoteRes.ListRes.of(entities);
    }

    @Override
    public void uploadImage(Long id, MultipartFile image) throws IOException {

    }
}
