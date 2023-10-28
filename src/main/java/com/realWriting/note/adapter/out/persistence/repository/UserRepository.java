package com.realWriting.note.adapter.out.persistence.repository;

import com.realWriting.note.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
