package com.realWriting.note.application.port.out;

import com.realWriting.note.application.port.out.dto.NoteRes;
import com.realWriting.note.domain.Note;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface NotePersistencePort {
    Note save(Note entity);
    Optional<Note> findById(Long id);
    void delete(Long id);
    List<Note> findAllByUserId(Long userId);
    NoteRes.ContentRes update(Note entity);
}
