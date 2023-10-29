package com.realWriting.user.application.port.in;

import com.realWriting.global.error.exception.UserException;
import com.realWriting.user.application.port.in.dto.UserReq;
import com.realWriting.user.application.port.out.dto.UserRes;

public interface UserService {
    UserRes.SignupRes signup(UserReq.SignupReq req);
    UserRes.LoginRes login(UserReq.LoginReq req) throws UserException;
}
