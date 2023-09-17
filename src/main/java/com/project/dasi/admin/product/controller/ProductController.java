package com.project.dasi.admin.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @RequestMapping("/admin/product/adminProduct")
    public void goAdminProduct() {}
    @RequestMapping("/admin/product/adminProductDetail")
    public void goAdminProductDetail() {}
}
