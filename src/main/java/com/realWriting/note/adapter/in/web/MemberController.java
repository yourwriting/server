package com.realWriting.note.adapter.in.web;

import com.realWriting.global.success.SuccessResponse;
import com.realWriting.note.adapter.in.web.dto.MemberInput;
import com.realWriting.note.application.port.in.MemberService;
import com.realWriting.note.application.port.out.dto.MemberRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.realWriting.global.success.SuccessCode.MEMBER_SIGNUP_SUCCESS;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<?> signup(@RequestBody MemberInput.SignupInput input) {
        MemberRes.SignupRes output = memberService.signup(input.toReq());
        return SuccessResponse.toResponseEntity(MEMBER_SIGNUP_SUCCESS, output);
    }
}
