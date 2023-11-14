package com.worldwidenews.worldwidenewsweb.services;

import com.worldwidenews.worldwidenewsweb.models.News;
import com.worldwidenews.worldwidenewsweb.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News saveNews(News news) {
        return newsRepository.save(news);
    }

    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id);
    }

    public void deleteNewsById(Long id) {
        newsRepository.deleteById(id);
    }
}
