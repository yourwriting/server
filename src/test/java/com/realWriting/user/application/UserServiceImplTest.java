package com.realWriting.user.application;

import com.realWriting.global.error.exception.UserException;
import com.realWriting.user.application.port.in.UserService;
import com.realWriting.user.application.port.in.dto.UserReq;
import com.realWriting.user.application.port.out.UserPersistencePort;
import com.realWriting.user.application.port.out.dto.UserRes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Autowired
    UserPersistencePort userPersistencePort;

    private String LOGIN_ID = "loginId";
    private String PASSWORD = "qwer12!@";
    private String NICKNAME = "별명이";

    @Test
    @DisplayName("회원 가입 성공")
    void 회원가입() {
        // given
        UserReq.SignupReq req = UserReq.SignupReq.builder()
                .loginId(LOGIN_ID)
                .password(PASSWORD)
                .nickname(NICKNAME)
                .build();

        // when
        UserRes.SignupRes res = userService.signup(req);

        // then
        assertThat(res.getLoginId()).isEqualTo(LOGIN_ID);
        assertThat(res.getNickname()).isEqualTo(NICKNAME);
        assertThat(userPersistencePort.existsById(res.getId())).isTrue();
    }

    @Test
    @DisplayName("회원 가입 실패 - 중복 ID")
    void 중복아이디() {
        // given
        UserReq.SignupReq req = UserReq.SignupReq.builder()
                .loginId(LOGIN_ID)
                .password(PASSWORD)
                .nickname(NICKNAME)
                .build();
        UserRes.SignupRes res = userService.signup(req);

        UserReq.SignupReq req2 = UserReq.SignupReq.builder()
                .loginId(LOGIN_ID)
                .password(PASSWORD)
                .nickname(NICKNAME)
                .build();

        // when
        UserException e = assertThrows(UserException.class, () -> userService.signup(req2));

        // then
        assertThat(e.getMessage()).isEqualTo("이미 가입된 아이디입니다.");
    }
}