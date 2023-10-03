package com.realWriting.note.adapter.out.persistence;

import com.realWriting.note.domain.Note;
import com.realWriting.note.adapter.out.persistence.repository.NoteRepository;
import com.realWriting.note.application.port.out.NotePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.realWriting.note.application.port.out.dto.NoteRes.ContentRes;

@Component
@RequiredArgsConstructor
public class NotePersistenceAdapter implements NotePersistencePort {
    private final NoteRepository noteRepository;

    @Override
    public ContentRes save(Note entity) {
        return ContentRes.of(noteRepository.save(entity));
    }

    @Override
    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public ContentRes update(Note entity) {
        return ContentRes.of(noteRepository.save(entity));
    }
}
