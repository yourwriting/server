package com.realWriting.user.adapter.out.persistence;

import com.realWriting.global.error.ErrorCode;
import com.realWriting.global.error.exception.UserException;
import com.realWriting.user.adapter.out.persistence.repository.UserRepository;
import com.realWriting.user.application.port.out.UserPersistencePort;
import com.realWriting.user.application.port.out.dto.UserRes;
import com.realWriting.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {
    private final UserRepository userRepository;

    @Override
    public UserRes.SignupRes save(User entity) {
        User savedUser = userRepository.save(entity);
        log.info("save -> {}", savedUser.getLoginId());
        return UserRes.SignupRes.of(savedUser);
    }

    @Override
    public boolean existsByLoginId(String loginId) {
        return userRepository.existsByLoginId(loginId);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public User findByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));
    }
}
