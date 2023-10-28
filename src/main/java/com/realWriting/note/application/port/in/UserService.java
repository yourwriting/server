package com.realWriting.note.application.port.in;

import com.realWriting.note.application.port.in.dto.UserReq;
import com.realWriting.note.application.port.out.dto.UserRes;

public interface UserService {
    UserRes.SignupRes signup(UserReq.SignupReq req);
    UserRes.LoginRes login(UserReq.LoginReq req);
}
