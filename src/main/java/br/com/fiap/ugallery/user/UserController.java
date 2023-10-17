package br.com.fiap.ugallery.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }
}
