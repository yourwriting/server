package com.realWriting.member.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public static User createUser(String loginId, String password, String nickname) {
        User user = new User();
        user.loginId = loginId;
        user.password = password;
        user.nickname = nickname;
        user.role = Role.USER;
        return user;
    }
}
