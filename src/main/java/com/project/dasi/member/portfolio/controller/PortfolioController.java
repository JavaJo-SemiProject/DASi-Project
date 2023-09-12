package com.project.dasi.member.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortfolioController {

    @RequestMapping("/member/portfolio/portfolio")
    public void goPortfolio() {}
    @RequestMapping("/member/portfolio/portfolioDetail")
    public void goPortfolioDetail() {}
}

