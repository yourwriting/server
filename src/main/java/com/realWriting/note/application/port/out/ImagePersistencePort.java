package com.realWriting.note.application.port.out;

import com.realWriting.note.domain.Image;

import java.util.List;

public interface ImagePersistencePort {
    List<Image> findByNoteId(Long noteId);
    void deleteAllByNoteId(Long noteId);
    void delete(Image image);
    Image save(Image image);
}
