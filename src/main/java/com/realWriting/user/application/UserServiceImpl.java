package com.realWriting.user.application;

import com.realWriting.global.error.ErrorCode;
import com.realWriting.global.error.exception.UserException;
import com.realWriting.global.util.JwtUtil;
import com.realWriting.user.application.port.in.UserService;
import com.realWriting.user.application.port.in.dto.UserReq;
import com.realWriting.user.application.port.out.UserPersistencePort;
import com.realWriting.user.application.port.out.dto.UserRes;
import com.realWriting.user.application.port.validator.UserServiceValidator;
import com.realWriting.user.domain.Role;
import com.realWriting.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserServiceValidator userServiceValidator;
    private final UserPersistencePort userPersistencePort;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public UserRes.SignupRes signup(UserReq.SignupReq req) {
        userServiceValidator.signupValidate(req.getLoginId());User user = User.createUser(req.getLoginId(), passwordEncoder.encode(req.getPassword()), req.getNickname());
        return userPersistencePort.save(user);
    }

    @Override
    public UserRes.LoginRes login(UserReq.LoginReq req) {
        User user = userPersistencePort.findByLoginId(req.getLoginId());

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new UserException(ErrorCode.WRONG_PASSWORD);
        }

        String token = jwtUtil.createToken(req.getLoginId(), String.valueOf(Role.USER));

        return UserRes.LoginRes.of(user, token);
    }
}
