package com.realWriting.note.application;

import com.realWriting.member.application.port.in.UserService;
import com.realWriting.member.application.port.in.dto.UserReq;
import com.realWriting.member.application.port.out.dto.UserPersistencePort;
import com.realWriting.member.application.port.out.dto.UserRes;
import com.realWriting.member.application.port.validator.UserServiceValidator;
import com.realWriting.member.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserServiceValidator userServiceValidator;
    private final UserPersistencePort userPersistencePort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserRes.SignupRes signup(UserReq.SignupReq req) {
        userServiceValidator.signupValidate(req.getLoginId());
        User user = User.createUser(req.getLoginId(), bCryptPasswordEncoder.encode(req.getPassword()), req.getNickname());
        return userPersistencePort.save(user);
    }

    @Override
    public UserRes.LoginRes login(UserReq.LoginReq req) {
        return null;
    }
}
