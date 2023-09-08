package com.realWriting.note.adapter.in.web;

import com.realWriting.note.adapter.in.web.dto.NoteOutput;
import com.realWriting.note.application.port.in.NoteService;
import com.realWriting.note.application.port.in.dto.NoteRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.realWriting.global.success.SuccessCode.*;
import static com.realWriting.global.success.SuccessResponse.toResponseEntity;
import static com.realWriting.note.adapter.in.web.dto.NoteInput.ContentInput;
import static com.realWriting.note.application.port.in.dto.NoteRes.ContentRes;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping("/note")
    public ResponseEntity<?> createNote(@RequestBody ContentInput input) {
        ContentRes output = noteService.createNote(input.toReq());
        return toResponseEntity(NOTE_CREATE_SUCCESS, output);
    }

    @PutMapping("/note/{noteId}")
    public ResponseEntity<?> updateNote(@PathVariable("noteId") Long noteId, @RequestBody ContentInput input) {
        ContentRes output = noteService.updateNote(noteId, input.toReq());
        return toResponseEntity(NOTE_UPDATE_SUCCESS, output);
    }

    @DeleteMapping("/note/{noteId}")
    public ResponseEntity<?> deleteNote(@PathVariable("noteId") Long noteId) {
        noteService.delete(noteId);
        return toResponseEntity(NOTE_DELETE_SUCCESS, noteId);
    }

    @GetMapping("/home")
    public ResponseEntity<?> showNotes() {
        List<NoteOutput.ListOutput> output = NoteOutput.ListOutput.of(noteService.findAll());
        return toResponseEntity(SHOW_NOTES_SUCCESS, output);
    }
}
