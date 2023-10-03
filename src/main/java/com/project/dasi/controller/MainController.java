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

    @GetMapping("/content/about")
    public void goAbout() {
    }

    @GetMapping("/content/product/product")
    public void goProduct() {}

    @GetMapping("/content/product/productDetail")
    public void goProductDetail() {}

    @GetMapping("/content/product/productDetail2")
    public void goProductDetail2() {}

    @GetMapping("/content/product/productDetail3")
    public void goProductDetail3() {}

    @GetMapping("/content/product/productDetail4")
    public void goProductDetail4() {}

}

