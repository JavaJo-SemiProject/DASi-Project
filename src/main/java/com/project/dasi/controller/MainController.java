package com.project.dasi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;


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
    @GetMapping("/content/product/portfolio")
    public void goPortfolio() {
    }
    @GetMapping("/content/order/orderGuidePage")
    public void goOrderGuidePage() {
    }
    @GetMapping("/content/order/orderRequestPage")
    public void goOrderRequestPage() {
    }
    @GetMapping("/content/question/faq")
    public void goFaq() {
    }


}

