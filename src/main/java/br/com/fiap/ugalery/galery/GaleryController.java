package br.com.fiap.ugalery.galery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/galery")
public class GaleryController {
    
    @GetMapping
    public String index(){
        return "galery/index";
    }
}
