package com.realWriting.user.application.port.out;

import com.realWriting.user.application.port.out.dto.UserRes;
import com.realWriting.user.domain.User;

public interface UserPersistencePort {
    UserRes.SignupRes save(User entity);
    boolean existsByLoginId(String loginId);
    boolean existsById(Long id);

    User findByLoginId(String loginId);
    User findById(Long id);
}
