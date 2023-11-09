package com.worldwidenews.worldwidenewsweb.controllers;

import com.worldwidenews.worldwidenewsweb.models.News;
import com.worldwidenews.worldwidenewsweb.models.NewsForm;
import org.springframework.ui.Model;
import com.worldwidenews.worldwidenewsweb.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
        // Puedes agregar lógica adicional si es necesario
        return "news-form";
    }

    @PostMapping("/create-news")
    public String createNews(@ModelAttribute NewsForm newsForm,
                             @RequestParam("imageFile") MultipartFile imageFile,
                             RedirectAttributes redirectAttributes) throws IOException {
        // Procesar la imagen
        byte[] imageBytes = imageFile.getBytes();

        // Crear una nueva instancia de News
        News news = new News();
        news.setTitle(newsForm.getTitle());
        news.setDescription(newsForm.getDescription());
        news.setContent(newsForm.getContent());
        news.setCategory(newsForm.getCategory());
        news.setImage(imageBytes);

        // Guardar la noticia en la base de datos
        newsService.saveNews(news);

        // Redirigir a la página de creación de noticias con un mensaje de éxito
        redirectAttributes.addFlashAttribute("successMessage", "Noticia creada exitosamente");
        return "redirect:/admin/create-news";
    }


}
