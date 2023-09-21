package com.project.dasi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping ("/")
    public String mainLoc() {
        return "main";
    }

    @GetMapping("/main")
    public void goMain() {
    }

    @GetMapping("/about")
    public void goFaq() {
    }
}

