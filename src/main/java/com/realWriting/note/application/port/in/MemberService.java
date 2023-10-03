package com.realWriting.note.application.port.in;

import com.realWriting.note.application.port.in.dto.MemberReq;
import com.realWriting.note.application.port.out.dto.MemberRes;

public interface MemberService {
    MemberRes.SignupRes signup(MemberReq.SignupReq req);
}
