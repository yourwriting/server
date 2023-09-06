package com.realWriting.note.adapter.out.persistence;

import com.realWriting.note.adapter.out.persistence.entity.NoteJpaEntity;
import com.realWriting.note.adapter.out.persistence.repository.NoteRepository;
import com.realWriting.note.application.port.in.dto.CreateNoteReq;
import com.realWriting.note.application.port.in.dto.CreateNoteRes;
import com.realWriting.note.application.port.out.NotePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.realWriting.note.application.port.in.dto.CreateNoteRes.*;

@Component
@RequiredArgsConstructor
public class CreateNotePersistenceAdapter implements NotePersistencePort {
    private final NoteRepository noteRepository;

    @Override
    public CreateNoteRes save(CreateNoteReq req) {
        NoteJpaEntity entity = NoteJpaEntity.builder()
                .title(req.getTitle())
                .content(req.getContent())
                .build();
        return toRes(noteRepository.save(entity));
    }

    @Override
    public Optional<NoteJpaEntity> findById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
