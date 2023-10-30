package com.realWriting.note.adapter.out.persistence.repository;

import com.realWriting.note.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
