package com.realWriting.entity;

import jakarta.persistence.*;

@Entity
public class Font {

    @Id @GeneratedValue
    @Column(name="font_id")
    private Long id;

    @Column(name="font_info")
    private String fontInfo;

}
