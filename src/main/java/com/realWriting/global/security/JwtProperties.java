package com.realWriting.global.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class JwtProperties {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SECRET_KEY = "yourwritingqu4waizw7b&=*y=sr3^igb+z_e*7ma%bk5+!z+%4k3%b2$y)tisecretkey";
    public static final Long TOKEN_VALIDITY = 2592000L;
}
