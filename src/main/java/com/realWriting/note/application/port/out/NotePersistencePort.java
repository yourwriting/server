package com.realWriting.note.application.port.out;

import com.realWriting.note.domain.Note;

import java.util.List;
import java.util.Optional;

import static com.realWriting.note.application.port.out.dto.NoteRes.*;

public interface NotePersistencePort {
    ContentRes save(Note entity);
    Optional<Note> findById(Long id);
    void delete(Long id);
    List<Note> findAll();
    ContentRes update(Note entity);
}
