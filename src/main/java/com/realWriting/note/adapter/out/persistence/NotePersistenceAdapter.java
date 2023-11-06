package com.realWriting.note.adapter.out.persistence;

import com.realWriting.note.adapter.out.persistence.repository.NoteRepository;
import com.realWriting.note.application.port.out.NotePersistencePort;
import com.realWriting.note.domain.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.realWriting.note.application.port.out.dto.NoteRes.ContentRes;

@Component
@RequiredArgsConstructor
public class NotePersistenceAdapter implements NotePersistencePort {
    private final NoteRepository noteRepository;

    @Override
    public Note save(Note entity) {
        return noteRepository.save(entity);
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
    public List<Note> findAllByUserId(Long userId) {
        return noteRepository.findAllByUserId(userId, Sort.by(Sort.Order.desc("id")));
    }

    @Override
    public Note update(Note entity) {
        return noteRepository.save(entity);
    }
}
