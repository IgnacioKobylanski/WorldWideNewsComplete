package com.worldwidenews.worldwidenewsweb.controllers;


import com.worldwidenews.worldwidenewsweb.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/news")
public class UserNewsController {
    private final NewsService newsService;

    @Autowired
    public UserNewsController(NewsService newsService){
        this.newsService = newsService;
    }

    @GetMapping
    public String showNewsPage() {
        return "news";
    }

    @GetMapping("/home")
    public String redirectToHome() {
        return "redirect:/index.html";
    }

    @GetMapping("/headlines")
    public String redirectToHeadlines() {
        return "redirect:/index.html#headlines";
    }

    @GetMapping("/local-news")
    public String redirectToLocalNews() {
        return "redirect:/index.html#local-news";
    }

    @GetMapping("/international-news")
    public String redirectToInternationalNews() {
        return "redirect:/index.html#international-news";
    }

    @GetMapping("/finance")
    public String redirectToFinance() {
        return "redirect:/index.html#finance";
    }

    @GetMapping("/sports")
    public String redirectToSports() {
        return "redirect:/index.html#sports";
    }

    @GetMapping("/entertainment")
    public String redirectToEntertainment() {
        return "redirect:/index.html#entertainment";
    }
}
