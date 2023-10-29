package com.realWriting.user.adapter.out.persistence.repository;

import com.realWriting.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLoginId(String loginId);
    Optional<User> findByLoginId(String loginId);
}
