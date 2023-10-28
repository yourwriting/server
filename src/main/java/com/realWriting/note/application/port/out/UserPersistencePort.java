package com.realWriting.note.application.port.out;

import com.realWriting.note.application.port.out.dto.UserRes;
import com.realWriting.note.domain.User;

public interface UserPersistencePort {
    UserRes.SignupRes save(User entity);
}
