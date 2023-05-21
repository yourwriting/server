package com.realWriting.entity;

import jakarta.persistence.*;

@Entity
public class Element {

    @Id @GeneratedValue
    @Column(name="element_id")
    private Long id;

    private String text;

    @Column(name="text_color")
    private String textColor;

    @OneToOne
    private Note note;

}
