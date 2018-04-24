package com.example.blog.Controllers;

import com.example.blog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
    @PostMapping("/login")
    public String loginUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "redirect:/";
    }
}
