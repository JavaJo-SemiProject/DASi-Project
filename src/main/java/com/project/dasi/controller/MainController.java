package com.project.dasi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping ("/")
    public String mainLoc() {
        return "main";
    }

    @GetMapping("/main")
    public void goMain() {
    }
    @GetMapping("/content/about")
    public void goAbout() {
    }

}

