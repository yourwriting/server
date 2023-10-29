package com.realWriting.note.adapter.in.web;

import com.realWriting.global.success.SuccessResponse;
import com.realWriting.note.adapter.in.web.dto.NoteInput;
import com.realWriting.note.application.port.in.NoteService;
import com.realWriting.note.application.port.out.dto.NoteRes;
import com.realWriting.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.realWriting.global.success.SuccessCode.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping("/note")
    public ResponseEntity<?> createNote(@RequestBody NoteInput.ContentInput input,
                                        @AuthenticationPrincipal User user) throws Exception {
        NoteRes.ContentRes output = noteService.saveNote(input.toReq(user.getId()), user);
        return SuccessResponse.toResponseEntity(NOTE_CREATE_SUCCESS, output);
    }

    @GetMapping("/note/{noteId}")
    public ResponseEntity<?> getNote(@PathVariable("noteId") Long noteId) {
        NoteRes.ContentRes output = noteService.getNote(noteId);
        return SuccessResponse.toResponseEntity(NOTE_GET_SUCCESS, output);
    }

    @PutMapping("/note/{noteId}")
    public ResponseEntity<?> updateNote(@PathVariable("noteId") Long noteId,
                                        @RequestBody NoteInput.ContentInput input,
                                        @AuthenticationPrincipal User user) {
        NoteRes.ContentRes output = noteService.updateNote(noteId, input.toReq(user.getId()));
        return SuccessResponse.toResponseEntity(NOTE_UPDATE_SUCCESS, output);
    }

    @DeleteMapping("/note/{noteId}")
    public ResponseEntity<?> deleteNote(@PathVariable("noteId") Long noteId) {
        noteService.deleteNote(noteId);
        return SuccessResponse.toResponseEntity(NOTE_DELETE_SUCCESS, noteId);
    }

    @GetMapping("/home")
    public ResponseEntity<?> showNotes(@AuthenticationPrincipal User user) {
        List<NoteRes.ListRes> output = noteService.findAll(user.getId());
        return SuccessResponse.toResponseEntity(SHOW_NOTES_SUCCESS, output);
    }
}