package com.realWriting.note.application;

import com.realWriting.global.error.exception.NoteNotFoundException;
import com.realWriting.note.application.port.in.CreateNoteUseCase;
import com.realWriting.note.application.port.in.DeleteNoteUseCase;
import com.realWriting.note.application.port.in.dto.CreateNoteReq;
import com.realWriting.note.application.port.in.dto.CreateNoteRes;
import com.realWriting.note.application.port.out.NotePersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.realWriting.global.error.ErrorCode.NOTE_NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
public class NoteService implements CreateNoteUseCase, DeleteNoteUseCase {
    private final NotePersistencePort notePersistencePort;

    @Override
    public CreateNoteRes createNote(CreateNoteReq req) {
        return notePersistencePort.save(req);
    }

    @Override
    public void delete(Long id) {
        notePersistencePort.findById(id)
                        .orElseThrow(() -> new NoteNotFoundException(NOTE_NOT_FOUND));
        notePersistencePort.delete(id);
    }
}
