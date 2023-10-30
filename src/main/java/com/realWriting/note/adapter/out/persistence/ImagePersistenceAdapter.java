package com.realWriting.note.adapter.out.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.realWriting.note.adapter.out.persistence.repository.ImageRepository;
import com.realWriting.note.application.port.out.ImagePersistencePort;
import com.realWriting.note.domain.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.realWriting.note.domain.QImage.image;

@Component
@RequiredArgsConstructor
public class ImagePersistenceAdapter implements ImagePersistencePort {
    private final JPAQueryFactory jpaQueryFactory;
    private final ImageRepository imageRepository;

    @Override
    public List<Image> findByNoteId(Long noteId) {
        return jpaQueryFactory
                .selectFrom(image)
                .where(image.note.id.eq(noteId))
                .fetch();
    }

    @Override
    public void deleteAllByNoteId(Long noteId) {
        jpaQueryFactory
                .delete(image)
                .where(image.note.id.eq(noteId))
                .execute();
    }

    @Override
    public void delete(Image image) {
        imageRepository.delete(image);
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }
}
