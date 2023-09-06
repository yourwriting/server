package com.realWriting.note.adapter.in.web;

import com.realWriting.global.success.SuccessCode;
import com.realWriting.global.success.SuccessResponse;
import com.realWriting.note.adapter.in.web.dto.CreateNoteInput;
import com.realWriting.note.adapter.in.web.dto.CreateNoteOutput;
import com.realWriting.note.application.port.in.CreateNoteUseCase;
import com.realWriting.note.application.port.in.DeleteNoteUseCase;
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

    @PostMapping("/note")
    public SuccessResponse<CreateNoteOutput> createNote(@RequestBody CreateNoteInput createNoteInput) {
        CreateNoteOutput output = toOutput(createNoteUseCase.createNote(toReq(createNoteInput)));
        return new SuccessResponse(NOTE_CREATE_SUCCESS, output);
    }

    // TODO 전체 조회, 검색 -> HomeController
//    @GetMapping("/notes")
//    public SuccessResponse<List<CreateNoteOutput>> listAll() {
//
//    }

    // TODO 수정

    @DeleteMapping("/note/{noteId}")
    public SuccessResponse<Long> deleteNote(@PathVariable("noteId") Long noteId) {
        deleteNoteUseCase.delete(noteId);
        return new SuccessResponse(NOTE_DELETE_SUCCESS, noteId);
    }
}
