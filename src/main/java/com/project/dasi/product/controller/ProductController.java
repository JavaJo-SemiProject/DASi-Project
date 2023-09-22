package com.project.dasi.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/content/product")
public class ProductController {

    @GetMapping("/product")
    public void goPortfolio() {}
    @GetMapping("/productDetail")
    public void goPortfolioDetail() {}
}

