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

    @Column(length = 2500)
    private String content;

    private String category;
    private String imageUrl;
}
