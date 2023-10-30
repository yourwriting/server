package com.realWriting.note.application.port.out;

import com.realWriting.note.domain.Image;
import com.realWriting.note.domain.Note;

import java.util.List;
import java.util.Optional;

public interface NotePersistencePort {
    Note save(Note entity);
    Optional<Note> findById(Long id);
    void delete(Long id);
    List<Note> findAllByUserId(Long userId);
    Note update(Note entity);
}
