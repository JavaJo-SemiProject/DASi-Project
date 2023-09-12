package com.project.dasi.admin.productList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductListController {
    @RequestMapping("/admin/productList/adminProduct")
    public void goAdminProduct() {}
    @RequestMapping("/admin/productList/adminProductDetail")
    public void goAdminProductDetail() {}
}
