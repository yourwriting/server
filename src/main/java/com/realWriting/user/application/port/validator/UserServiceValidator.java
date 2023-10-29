package com.realWriting.user.application.port.validator;

import com.realWriting.global.error.ErrorCode;
import com.realWriting.global.error.exception.UserException;
import com.realWriting.user.application.port.out.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceValidator {
    private final UserPersistencePort userPersistencePort;

    public void signupValidate(String loginId) {
        if (userPersistencePort.existsByLoginId(loginId)) {
            throw new UserException(ErrorCode.DUPLICATED_LOGIN_ID);
        }
        log.info("[signupValidate] 통과");
    }
}
