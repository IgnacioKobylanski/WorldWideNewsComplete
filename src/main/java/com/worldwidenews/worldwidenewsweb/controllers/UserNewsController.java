package com.worldwidenews.worldwidenewsweb.controllers;


import com.worldwidenews.worldwidenewsweb.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/index")
public class UserNewsController {
    private final NewsService newsService;

    @Autowired
    public UserNewsController(NewsService newsService){
        this.newsService = newsService;
    }

    @GetMapping
    public String showNewsPage() {
        return "index";
    }


}
