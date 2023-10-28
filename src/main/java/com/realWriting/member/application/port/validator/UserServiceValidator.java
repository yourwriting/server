package com.realWriting.member.application.port.validator;

import com.realWriting.global.error.ErrorCode;
import com.realWriting.global.error.exception.UserException;
import com.realWriting.member.application.port.out.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceValidator {
    private final UserPersistencePort userPersistencePort;

    public void signupValidate(String loginId) {
        if (userPersistencePort.existsByLoginId(loginId)) {
            throw new UserException(ErrorCode.DUPLICATED_LOGIN_ID);
        }
    }
}
