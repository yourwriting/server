package com.realWriting.entity;

import jakarta.persistence.*;

@Entity
public class FileElement {

    @Id @GeneratedValue
    @Column(name="file_elm_id")
    private Long id;

    private String text;

    @Column(name="text_color")
    private String textColor;

    @OneToOne
    private CreatedFile createdFile;
}
