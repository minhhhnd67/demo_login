package com.example.demo_login.controller;

import com.example.demo_login.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(String username, String password, Model model) {
        userService.registerUser(username, password);
        model.addAttribute("success", "Đăng ký thành công!");
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
