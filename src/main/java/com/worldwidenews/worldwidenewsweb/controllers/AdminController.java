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
        // Lógica para obtener y agregar información al modelo si es necesario
        return "news-form";
    }

    @GetMapping("/create-news")
    public String showCreateNewsForm(Model model) {
        model.addAttribute("newsForm", new NewsForm());
        return "create-news";
    }

    @PostMapping("/create-news")
    public String createNews(@ModelAttribute NewsForm newsForm,
                             RedirectAttributes redirectAttributes) throws IOException {
        // Lógica para crear una nueva noticia
        // ...

        // Redirigir con un mensaje de éxito
        redirectAttributes.addFlashAttribute("successMessage", "Noticia creada exitosamente");
        return "redirect:/admin/create-news";
    }

    @GetMapping("/edit-news")
    public String showEditNewsForm(Model model) {
        // Lógica para mostrar el formulario de edición
        model.addAttribute("newsForm", new NewsForm());
        return "edit-news";
    }

    @PostMapping("/delete-news")
    public String deleteNews(@RequestParam("newsId") Long newsId, Model model, RedirectAttributes redirectAttributes) {
        // Lógica para buscar la noticia por ID
        Optional<News> optionalNewsToDelete = newsService.getNewsById(newsId);

        if (optionalNewsToDelete.isPresent()) {
            // Si la noticia se encuentra, la agregamos al modelo para mostrar la información
            model.addAttribute("newsToDelete", optionalNewsToDelete.get());
            return "delete-news";
        } else {
            // Si la noticia no se encuentra, añadimos un mensaje de error
            redirectAttributes.addFlashAttribute("errorMessage", "No se encontró una noticia con ese ID");
            return "redirect:/admin/delete-news";
        }
    }

    @GetMapping("/delete-news")
    public String showDeleteNewsForm(Model model) {
        // Lógica para mostrar el formulario de búsqueda
        return "delete-news";
    }

}
