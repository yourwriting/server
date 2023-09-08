package com.realWriting.note.adapter.out.persistence;

import com.realWriting.note.adapter.out.persistence.entity.NoteJpaEntity;
import com.realWriting.note.adapter.out.persistence.repository.NoteRepository;
import com.realWriting.note.application.port.in.dto.NoteReq;
import com.realWriting.note.application.port.in.dto.NoteRes;
import com.realWriting.note.application.port.out.NotePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.realWriting.note.application.port.in.dto.NoteReq.*;
import static com.realWriting.note.application.port.in.dto.NoteRes.*;

@Component
@RequiredArgsConstructor
public class CreateNotePersistenceAdapter implements NotePersistencePort {
    private final NoteRepository noteRepository;

    @Override
    public ContentRes save(ContentReq req) {
        NoteJpaEntity entity = NoteJpaEntity.builder()
                .title(req.getTitle())
                .content(req.getContent())
                .build();
        return ContentRes.of(noteRepository.save(entity));
    }

    @Override
    public Optional<NoteJpaEntity> findById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<NoteJpaEntity> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public ContentRes update(NoteJpaEntity entity) {
        return ContentRes.of(noteRepository.save(entity));
    }
}
