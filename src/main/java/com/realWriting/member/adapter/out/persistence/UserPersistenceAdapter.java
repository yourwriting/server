package com.realWriting.member.adapter.out.persistence;

import com.realWriting.member.adapter.out.persistence.repository.UserRepository;
import com.realWriting.member.application.port.out.dto.UserPersistencePort;
import com.realWriting.member.application.port.out.dto.UserRes;
import com.realWriting.member.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {
    private final UserRepository userRepository;

    @Override
    public UserRes.SignupRes save(User entity) {
        User savedUser = userRepository.save(entity);
        return UserRes.SignupRes.of(savedUser);
    }

    @Override
    public boolean existsByLoginId(String loginId) {
        return userRepository.existsByLoginId(loginId);
    }
}
