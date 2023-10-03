package com.realWriting.note.application.port.validator;

import com.realWriting.global.error.ErrorCode;
import com.realWriting.global.error.exception.DuplicationException;
import com.realWriting.note.application.port.in.dto.MemberReq;
import com.realWriting.note.application.port.out.MemberPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberValidator {
    private final MemberPersistencePort memberPersistencePort;

    public void validate(MemberReq.SignupReq req) {
        checkDuplicatedEmail(req.getEmail()); // 중복 이메일 exception
    }

    private void checkDuplicatedEmail(String email) {
        if (!memberPersistencePort.existsByEmail(email)) {
            throw new DuplicationException(ErrorCode.DUPLICATED_EMAIL);
        }
    }
}
