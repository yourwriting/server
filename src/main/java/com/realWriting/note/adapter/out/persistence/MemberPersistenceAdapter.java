package com.realWriting.note.adapter.out.persistence;

import com.realWriting.note.adapter.out.persistence.repository.MemberRepository;
import com.realWriting.note.application.port.out.MemberPersistencePort;
import com.realWriting.note.application.port.out.dto.MemberRes;
import com.realWriting.note.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements MemberPersistencePort {
    private final MemberRepository memberRepository;

    @Override
    public MemberRes.SignupRes save(Member entity) {
        return MemberRes.SignupRes.of(memberRepository.save(entity));
    }

    @Override
    public boolean existsByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }
}
