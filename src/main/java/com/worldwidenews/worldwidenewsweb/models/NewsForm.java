package com.worldwidenews.worldwidenewsweb.models;

import lombok.Data;

@Data
public class NewsForm {
    private String title;
    private String description;
    private String content;
    private String category;
    private String imageUrl;
}
