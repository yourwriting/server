package com.realWriting.note.domain;

import com.realWriting.member.domain.User;
import jakarta.persistence.*;

@Entity
@Table(name = "USER_NOTE")
public class UserNote {
    @Id
    @GeneratedValue
    @Column(name = "USER_NOTE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NOTE_ID")
    private Note note;
}
