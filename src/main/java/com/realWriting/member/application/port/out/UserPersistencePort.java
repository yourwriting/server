package com.realWriting.member.application.port.out;

import com.realWriting.member.application.port.out.dto.UserRes;
import com.realWriting.member.domain.User;

public interface UserPersistencePort {
    UserRes.SignupRes save(User entity);
    boolean existsByLoginId(String loginId);
}
