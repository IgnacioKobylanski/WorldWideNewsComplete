package com.worldwidenews.worldwidenewsweb.controllers;

import com.worldwidenews.worldwidenewsweb.models.News;
import com.worldwidenews.worldwidenewsweb.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @PostMapping
    public News saveNews(@RequestBody News news) {
        return newsService.saveNews(news);
    }
}
