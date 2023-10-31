package com.realWriting.note.application;

import com.realWriting.global.error.exception.NoteException;
import com.realWriting.global.vo.BaseFile;
import com.realWriting.note.application.port.in.FileService;
import com.realWriting.note.application.port.in.NoteService;
import com.realWriting.note.application.port.in.dto.NoteReq;
import com.realWriting.note.application.port.out.ImagePersistencePort;
import com.realWriting.note.application.port.out.NotePersistencePort;
import com.realWriting.note.application.port.out.dto.NoteRes;
import com.realWriting.note.domain.Image;
import com.realWriting.note.domain.Note;
import com.realWriting.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.realWriting.global.error.ErrorCode.NOTE_NOT_FOUND;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NotePersistencePort notePersistencePort;
    private final FileService fileService;
    private final ImagePersistencePort imagePersistencePort;

    @Transactional
    @Override
    public NoteRes.ContentRes saveNote(NoteReq.ContentReq req, User user) {
        Note savedNote = notePersistencePort.save(req.toEntity()).setUser(user);

        if (req.getFiles() != null) {
            uploadFiles(savedNote, req.getFiles());
        }

        List<NoteRes.FileRes> fileResList = fileService.getNoteFileList(savedNote.getId());

        return NoteRes.ContentRes.of(savedNote, fileResList);
    }

    private void uploadFiles(Note note, List<MultipartFile> files) {
        List<BaseFile> baseFiles = fileService.uploadNoteFileList(files);

        baseFiles.forEach(baseFile -> {
            imagePersistencePort.save(
                    Image.createImage(
                            note,
                            baseFile.getFileUrl(),
                            baseFile.getOriginFileName(),
                            baseFile.getStoredFileName()
                    )
            );
        });
    }

    @Override
    public NoteRes.ContentRes getNote(Long id) {
        Note note = notePersistencePort.findById(id)
                .orElseThrow(() -> new NoteException(NOTE_NOT_FOUND));

        List<NoteRes.FileRes> fileResList = fileService.getNoteFileList(note.getId());

        return NoteRes.ContentRes.of(note, fileResList);
    }

    @Transactional
    @Override
    public NoteRes.ContentRes updateNote(Long id, NoteReq.ContentReq req) {
        Note updatedNote = notePersistencePort.findById(id)
                .orElseThrow(() -> new NoteException(NOTE_NOT_FOUND))
                .update(req.getTitle(), req.getContent());

        if (req.getFiles() != null) {
            uploadFiles(updatedNote, req.getFiles());
        }

        List<NoteRes.FileRes> fileResList = fileService.getNoteFileList(updatedNote.getId());

        return NoteRes.ContentRes.of(updatedNote, fileResList);
    }

    @Transactional
    @Override
    public void deleteNote(Long id) {
        // TODO userId 검증

        notePersistencePort.findById(id)
                        .orElseThrow(() -> new NoteException(NOTE_NOT_FOUND));

        fileService.deleteNoteFileList(id);

        notePersistencePort.delete(id);
    }

    @Override
    public List<NoteRes.ListRes> findAll(Long userId) {
        List<Note> entities = notePersistencePort.findAllByUserId(userId);
        return NoteRes.ListRes.of(entities);
    }
}
