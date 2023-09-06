package com.realWriting.note.adapter.out.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MEMBER")
public class MemberJpaEntity {
    @Id
    @Column(name = "MEMBER_ID")
    private Long id;
}
