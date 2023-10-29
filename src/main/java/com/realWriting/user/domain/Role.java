package com.realWriting.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Getter
@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    USER("ROLE_USER", "일반 사용자");

    private final String authority;
    private final String title;

    @Override
    public String getAuthority() {
        return authority;
    }
}
