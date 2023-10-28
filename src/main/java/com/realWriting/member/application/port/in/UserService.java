package com.realWriting.member.application.port.in;

import com.realWriting.member.application.port.in.dto.UserReq;
import com.realWriting.member.application.port.out.dto.UserRes;

public interface UserService {
    UserRes.SignupRes signup(UserReq.SignupReq req);
    UserRes.LoginRes login(UserReq.LoginReq req);
}
