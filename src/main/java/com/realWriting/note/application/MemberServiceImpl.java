package com.realWriting.note.application;

import com.realWriting.note.application.port.in.MemberService;
import com.realWriting.note.application.port.in.dto.MemberReq;
import com.realWriting.note.application.port.out.MemberPersistencePort;
import com.realWriting.note.application.port.out.dto.MemberRes;
import com.realWriting.note.application.port.validator.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberPersistencePort memberPersistencePort;
    private final MemberValidator memberValidator;

    @Override
    public MemberRes.SignupRes signup(MemberReq.SignupReq req) {
        memberValidator.validate(req);
        return memberPersistencePort.save(req.toEntity());
    }
}
