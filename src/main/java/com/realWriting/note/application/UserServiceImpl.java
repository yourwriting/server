package com.realWriting.note.application;

import com.realWriting.note.application.port.in.UserService;
import com.realWriting.note.application.port.in.dto.UserReq;
import com.realWriting.note.application.port.out.UserPersistencePort;
import com.realWriting.note.application.port.out.dto.UserRes;
import com.realWriting.note.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserPersistencePort userPersistencePort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserRes.SignupRes signup(UserReq.SignupReq req) {
        User user = User.createUser(req.getLoginId(), bCryptPasswordEncoder.encode(req.getPassword()), req.getNickname());
        return userPersistencePort.save(user);
    }

    @Override
    public UserRes.LoginRes login(UserReq.LoginReq req) {
        return null;
    }
}
