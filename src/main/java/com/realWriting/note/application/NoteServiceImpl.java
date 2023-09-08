package com.realWriting.note.application;

import com.realWriting.global.error.exception.NoteNotFoundException;
import com.realWriting.note.adapter.out.persistence.entity.NoteJpaEntity;
import com.realWriting.note.application.port.in.NoteService;
import com.realWriting.note.application.port.in.dto.NoteReq;
import com.realWriting.note.application.port.in.dto.NoteRes;
import com.realWriting.note.application.port.out.NotePersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.realWriting.global.error.ErrorCode.NOTE_NOT_FOUND;
import static com.realWriting.note.application.port.in.dto.NoteRes.ContentRes;
import static com.realWriting.note.application.port.in.dto.NoteRes.ListRes;

@Service
@Transactional
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NotePersistencePort notePersistencePort;

    public ContentRes createNote(NoteReq.ContentReq req) {
        return notePersistencePort.save(req);
    }

    @Override
    public ContentRes updateNote(Long id, NoteReq.ContentReq req) {
        NoteJpaEntity entity = notePersistencePort.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(NOTE_NOT_FOUND))
                .update(req.getTitle(), req.getContent());
        return notePersistencePort.update(entity);
    }

    @Override
    public void delete(Long id) {
        notePersistencePort.findById(id)
                        .orElseThrow(() -> new NoteNotFoundException(NOTE_NOT_FOUND));
        notePersistencePort.delete(id);
    }

    @Override
    public List<NoteRes.ListRes> findAll() {
        List<NoteJpaEntity> entities = notePersistencePort.findAll();
        return ListRes.of(entities);
    }
}
