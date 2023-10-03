package com.realWriting.note.adapter.in.web;

import com.realWriting.global.success.SuccessResponse;
import com.realWriting.note.adapter.in.web.dto.NoteInput;
import com.realWriting.note.application.port.in.NoteService;
import com.realWriting.note.application.port.out.dto.NoteRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.realWriting.global.success.SuccessCode.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping("/note")
    public ResponseEntity<?> createNote(@RequestBody NoteInput.ContentInput input) throws Exception {
        NoteRes.ContentRes output = noteService.saveNote(input.toReq());
        return SuccessResponse.toResponseEntity(NOTE_CREATE_SUCCESS, output);
    }

    @GetMapping("/note/{noteId}")
    public ResponseEntity<?> getNote(@PathVariable("noteId") Long noteId) {
        NoteRes.ContentRes output = noteService.getNote(noteId);
        return SuccessResponse.toResponseEntity(NOTE_GET_SUCCESS, output);
    }

    @PutMapping("/note/{noteId}")
    public ResponseEntity<?> updateNote(@PathVariable("noteId") Long noteId, @RequestBody NoteInput.ContentInput input) {
        NoteRes.ContentRes output = noteService.updateNote(noteId, input.toReq());
        return SuccessResponse.toResponseEntity(NOTE_UPDATE_SUCCESS, output);
    }

    @DeleteMapping("/note/{noteId}")
    public ResponseEntity<?> deleteNote(@PathVariable("noteId") Long noteId) {
        noteService.deleteNote(noteId);
        return SuccessResponse.toResponseEntity(NOTE_DELETE_SUCCESS, noteId);
    }

    @GetMapping("/home")
    public ResponseEntity<?> showNotes() {
        List<NoteRes.ListRes> output = noteService.findAll();
        return SuccessResponse.toResponseEntity(SHOW_NOTES_SUCCESS, output);
    }

    @PostMapping("/upload/{noteId}")
    public ResponseEntity<?> uploadImage(@PathVariable Long noteId, @RequestParam("image") MultipartFile image) throws IOException {
        noteService.uploadImage(noteId, image);
        return SuccessResponse.toResponseEntity(IMAGE_UPLOAD_SUCCESS, noteId);
    }
}