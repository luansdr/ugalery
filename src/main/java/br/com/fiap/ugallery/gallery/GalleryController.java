package br.com.fiap.ugallery.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/gallery")
public class GalleryController {
    
    @Autowired
    GalleryService service;
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("gallery", service.findAll());
        return "gallery/index";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        service.delete(id);
        redirect.addFlashAttribute("success", "Sucesso");
        return "redirect:/gallery";

    }
}
