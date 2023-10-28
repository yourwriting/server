package com.realWriting.note.adapter.out.persistence;

import com.realWriting.note.adapter.out.persistence.repository.UserRepository;
import com.realWriting.note.application.port.out.UserPersistencePort;
import com.realWriting.note.application.port.out.dto.UserRes;
import com.realWriting.note.domain.User;
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
}
