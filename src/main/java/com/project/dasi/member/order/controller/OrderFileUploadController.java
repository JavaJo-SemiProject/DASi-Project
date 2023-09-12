package com.project.dasi.member.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class OrderFileUploadController {

    public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles
        , Model model){

        return null;
    }

}
