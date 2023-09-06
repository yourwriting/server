package com.realWriting.note.adapter.out.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FONT")
public class FontJpaEntity {
    @Id
    @GeneratedValue
    @Column(name="FONT_ID")
    private Long id;

    @Column(name="FONT_INFO")
    @Lob
    private String fontInfo;

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private MemberJpaEntity member;
}
