package com.realWriting.note.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "MEMBER_NOTE")
public class MemberNote {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_NOTE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NOTE_ID")
    private Note note;
}
