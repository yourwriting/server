package com.realWriting.note.adapter.out.persistence.repository;

import com.realWriting.note.adapter.out.persistence.entity.NoteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteJpaEntity, Long> {
}
