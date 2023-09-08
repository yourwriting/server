package com.realWriting.note.application.port.out;

import com.realWriting.note.adapter.out.persistence.entity.NoteJpaEntity;
import com.realWriting.note.application.port.in.dto.NoteReq;
import com.realWriting.note.application.port.in.dto.NoteRes;

import java.util.List;
import java.util.Optional;

import static com.realWriting.note.application.port.in.dto.NoteRes.*;

public interface NotePersistencePort {
    ContentRes save(NoteReq.ContentReq req);
    Optional<NoteJpaEntity> findById(Long id);
    void delete(Long id);
    List<NoteJpaEntity> findAll();
    ContentRes update(NoteJpaEntity entity);
}
