package com.realWriting.note.adapter.in.web;

import com.realWriting.global.success.SuccessResponse;
import com.realWriting.note.adapter.in.web.dto.CreateNoteInput;
import com.realWriting.note.adapter.in.web.dto.CreateNoteOutput;
import com.realWriting.note.adapter.in.web.dto.NoteOutput;
import com.realWriting.note.application.port.in.CreateNoteUseCase;
import com.realWriting.note.application.port.in.DeleteNoteUseCase;
import com.realWriting.note.application.port.in.ShowNotesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.realWriting.global.success.SuccessCode.*;
import static com.realWriting.note.adapter.in.web.dto.CreateNoteOutput.toOutput;
import static com.realWriting.note.application.port.in.dto.CreateNoteReq.toReq;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoteController {
    private final CreateNoteUseCase createNoteUseCase;
    private final DeleteNoteUseCase deleteNoteUseCase;
    private final ShowNotesUseCase showNotesUseCase;

    @PostMapping("/note")
    public SuccessResponse<CreateNoteOutput> createNote(@RequestBody CreateNoteInput createNoteInput) {
        CreateNoteOutput output = toOutput(createNoteUseCase.createNote(toReq(createNoteInput)));
        return new SuccessResponse(NOTE_CREATE_SUCCESS, output);
    }

    // TODO 수정

    @DeleteMapping("/note/{noteId}")
    public SuccessResponse<Long> deleteNote(@PathVariable("noteId") Long noteId) {
        deleteNoteUseCase.delete(noteId);
        return new SuccessResponse(NOTE_DELETE_SUCCESS, noteId);
    }

    @GetMapping("/home")
    public SuccessResponse<List<NoteOutput>> showNotes() {
        List<NoteOutput> output = NoteOutput.toOutput(showNotesUseCase.findAll());
        return new SuccessResponse<>(SHOW_NOTES_SUCCESS, output);
    }
}
