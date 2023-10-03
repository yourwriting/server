package com.realWriting.note.application.port.out;

import com.realWriting.note.application.port.out.dto.MemberRes;
import com.realWriting.note.domain.Member;

import static com.realWriting.note.application.port.out.dto.MemberRes.*;

public interface MemberPersistencePort {
    SignupRes save(Member entity);
    boolean existsByEmail(String email);
}
