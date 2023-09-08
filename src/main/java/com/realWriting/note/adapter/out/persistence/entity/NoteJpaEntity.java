package com.realWriting.note.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "NOTE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class NoteJpaEntity {
    @Id @GeneratedValue
    @Column(name="NOTE_ID")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private MemberJpaEntity member;

    private String title;

    @Lob
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public NoteJpaEntity update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }
}
