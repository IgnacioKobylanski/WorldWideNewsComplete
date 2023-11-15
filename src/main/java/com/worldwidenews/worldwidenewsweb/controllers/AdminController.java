package com.worldwidenews.worldwidenewsweb.controllers;

import com.worldwidenews.worldwidenewsweb.models.News;
import com.worldwidenews.worldwidenewsweb.models.NewsForm;
import com.worldwidenews.worldwidenewsweb.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final NewsService newsService;

    @Autowired
    public AdminController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public String showAdminDashboard() {
        return "redirect:/admin/news-form";
    }

    @GetMapping("/news-form")
    public String showNewsForm(Model model) {
        return "news-form";
    }

    @GetMapping("/create-news")
    public String showCreateNewsForm(Model model) {
        model.addAttribute("newsForm", new NewsForm());
        return "create-news";
    }

    @PostMapping("/create-news")
    public String createNews(@ModelAttribute NewsForm newsForm,
                             RedirectAttributes redirectAttributes,  Model model) throws IOException {
        News news = new News();
        news.setTitle(newsForm.getTitle());
        news.setDescription(newsForm.getDescription());
        news.setContent(newsForm.getContent());
        news.setCategory(newsForm.getCategory());
        news.setImageUrl(newsForm.getImageUrl());

        newsService.saveNews(news);

        if (!model.containsAttribute("successMessage")) {
            redirectAttributes.addFlashAttribute("successMessage", "News Created");
        }
        return "redirect:/admin/create-news";
    }



    @GetMapping("/edit-news")
    public String showEditNewsForm(Model model) {
        model.addAttribute("newsForm", new NewsForm());
        return "edit-news";
    }

    @PostMapping("/delete-news")
    public String deleteNews(@RequestParam("newsId") Long newsId, Model model, RedirectAttributes redirectAttributes) {
        Optional<News> optionalNewsToDelete = newsService.getNewsById(newsId);

        if (optionalNewsToDelete.isPresent()) {
            model.addAttribute("newsToDelete", optionalNewsToDelete.get());
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Cannot find a news with that ID");
            return "redirect:/admin/delete-news";
        }

        return "delete-news";
    }

    @GetMapping("/delete-news")
    public String showDeleteNewsForm(Model model) {
        // Lógica para mostrar el formulario de búsqueda
        return "delete-news";
    }

    @PostMapping("/confirm-delete")
    public String confirmDelete(@RequestParam("id") Long newsId, RedirectAttributes redirectAttributes) {
        // Lógica para confirmar y eliminar la noticia
        Optional<News> optionalNewsToDelete = newsService.getNewsById(newsId);

        if (optionalNewsToDelete.isPresent()) {
            newsService.deleteNewsById(newsId);
            redirectAttributes.addFlashAttribute("successMessage", "News Deleted");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Cannot find a news with that ID");
        }

        return "redirect:/admin/delete-news";
    }



    @GetMapping("/show-news")
    public String showNews(@RequestParam(value = "newsId", required = false) Long newsId, Model model) {

        if (newsId != null) {
            Optional<News> optionalNews = newsService.getNewsById(newsId);

            if (optionalNews.isPresent()) {
                model.addAttribute("news", optionalNews.get());
            } else {
                model.addAttribute("errorMessage", "No se encontró una noticia con ese ID");
            }
        }

        List<News> allNews = newsService.getAllNews();
        model.addAttribute("allNews", allNews);

        return "show-news";
    }

    @PostMapping("/update-news")
    public String updateNews(@RequestParam("newsId") Long newsId, Model model) {
        Optional<News> optionalNews = newsService.getNewsById(newsId);

        if (optionalNews.isPresent()) {
            model.addAttribute("foundNews", true);
            model.addAttribute("newsForm", optionalNews.get());
        } else {
            model.addAttribute("foundNews", false);
            model.addAttribute("errorMessage", "Cannot find a news with that ID");
        }

        return "edit-news";
    }



    @PostMapping("/confirm-update")
    public String confirmUpdate(@ModelAttribute News news, NewsForm newsForm, RedirectAttributes redirectAttributes) {
        Long newsId = news.getId();
        Optional<News> optionalNews = newsService.getNewsById(newsId);

        if (optionalNews.isPresent()) {
            News updatedNews = optionalNews.get();
            updatedNews.setTitle(newsForm.getTitle());
            updatedNews.setDescription(newsForm.getDescription());
            updatedNews.setContent(newsForm.getContent());
            updatedNews.setCategory(newsForm.getCategory());
            updatedNews.setImageUrl(newsForm.getImageUrl());

            newsService.saveNews(updatedNews);

            redirectAttributes.addFlashAttribute("successMessage", "News Updated");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Cannot find a news with that ID");
        }

        return "redirect:/admin/edit-news";
    }





}
