package br.com.fiap.ugallery.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    GalleryService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("gallery", service.findAll());
        return "gallery/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        service.delete(id);
        redirect.addFlashAttribute("success", "Sucesso");
        return "redirect:/gallery";

    }

    @GetMapping("new")
    public String form(Gallery gallery) {
        return "gallery/form";
    }

    @PostMapping
    public String save(@Valid Gallery gallery, BindingResult result, RedirectAttributes redirect){
        if (result.hasErrors()) return "/gallery/form";

        service.save(gallery);
        redirect.addFlashAttribute("success", "Tarefa cadastrada com sucesso");
        return "redirect:/task";
    }

}
