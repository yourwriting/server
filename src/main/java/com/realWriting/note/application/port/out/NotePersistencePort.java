package com.realWriting.note.application.port.out;

import com.realWriting.note.application.port.out.dto.NoteRes;
import com.realWriting.note.domain.Note;

import java.util.List;
import java.util.Optional;

public interface NotePersistencePort {
    NoteRes.ContentRes save(Note entity);
    Optional<Note> findById(Long id);
    void delete(Long id);
    List<Note> findAll();
    NoteRes.ContentRes update(Note entity);
}
