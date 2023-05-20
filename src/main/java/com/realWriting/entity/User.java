package com.realWriting.entity;

import jakarta.persistence.*;

@Entity
public class User {

    @Id @GeneratedValue
    @Column(name="user_id")
    private Long id;

}
