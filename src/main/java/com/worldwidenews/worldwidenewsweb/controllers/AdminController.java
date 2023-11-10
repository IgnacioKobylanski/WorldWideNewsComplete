package com.worldwidenews.worldwidenewsweb.controllers;

import com.worldwidenews.worldwidenewsweb.models.News;
import com.worldwidenews.worldwidenewsweb.models.NewsForm;
import org.springframework.ui.Model;
import com.worldwidenews.worldwidenewsweb.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final NewsService newsService;

    @Autowired
    public AdminController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/create-news")
    public String showCreateNewsForm(Model model) {
            model.addAttribute("newsForm", new NewsForm());
        return "news-form";
    }

    @PostMapping("/create-news")
    public String createNews(@ModelAttribute NewsForm newsForm,
                             RedirectAttributes redirectAttributes) throws IOException {
        // Crear una nueva instancia de News
        News news = new News();
        news.setTitle(newsForm.getTitle());
        news.setDescription(newsForm.getDescription());
        news.setContent(newsForm.getContent());
        news.setCategory(newsForm.getCategory());
        news.setImageUrl(newsForm.getImageUrl());  // Usar la URL en lugar de la imagen

        // Guardar la noticia en la base de datos
        newsService.saveNews(news);

        // Redirigir a la página de creación de noticias con un mensaje de éxito
        redirectAttributes.addFlashAttribute("successMessage", "Noticia creada exitosamente");
        return "redirect:/admin/create-news";
    }
}
