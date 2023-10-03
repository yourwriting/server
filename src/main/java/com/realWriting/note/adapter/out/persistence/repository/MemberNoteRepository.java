package com.realWriting.note.adapter.out.persistence.repository;

import com.realWriting.note.domain.MemberNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberNoteRepository extends JpaRepository<MemberNote, Long> {
}
