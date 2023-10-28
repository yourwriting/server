package com.realWriting.note.adapter.in.web;

import com.realWriting.global.success.SuccessResponse;
import com.realWriting.note.adapter.in.web.dto.UserInput;
import com.realWriting.note.application.port.in.UserService;
import com.realWriting.note.application.port.out.dto.UserRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.realWriting.global.success.SuccessCode.USER_SIGNUP_SUCCESS;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> signup(@RequestBody UserInput.SignupInput input) {
        UserRes.SignupRes output = userService.signup(input.toReq());
        return SuccessResponse.toResponseEntity(USER_SIGNUP_SUCCESS, output);
    }
}
