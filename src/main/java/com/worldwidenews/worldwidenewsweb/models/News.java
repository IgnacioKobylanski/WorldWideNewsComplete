package com.worldwidenews.worldwidenewsweb.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private String content;
    private String category;

    @Lob
    private byte[] image;
}
