package com.realWriting.user.adapter.in.web;

import com.realWriting.global.success.SuccessCode;
import com.realWriting.global.success.SuccessResponse;
import com.realWriting.user.adapter.in.web.dto.UserInput;
import com.realWriting.user.application.port.in.UserService;
import com.realWriting.user.application.port.out.dto.UserRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> signup(@RequestBody UserInput.SignupInput input) {
        UserRes.SignupRes output = userService.signup(input.toReq());
        return SuccessResponse.toResponseEntity(SuccessCode.USER_SIGNUP_SUCCESS, output);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserInput.LoginInput input) {
        UserRes.LoginRes output = userService.login(input.toReq());
        return SuccessResponse.toResponseEntity(SuccessCode.USER_LOGIN_SUCCESS, output);
    }

    @GetMapping("/profile/password")
    public ResponseEntity<?> findPassword() {
        return SuccessResponse.toResponseEntity(SuccessCode.USER_FIND_PASSWORD, null);
    }
}
