package com.realWriting.note.application.port.out;

import com.realWriting.note.adapter.out.persistence.entity.NoteJpaEntity;
import com.realWriting.note.application.port.in.dto.CreateNoteReq;
import com.realWriting.note.application.port.in.dto.CreateNoteRes;

import java.util.Optional;

public interface NotePersistencePort {
    CreateNoteRes save(CreateNoteReq req);
    Optional<NoteJpaEntity> findById(Long id);
    void delete(Long id);
}
