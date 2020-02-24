package com.liuhang.jcartadministrationback.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("image")
public class ImageController {
    @PostMapping("upload")
    public String upload(){
        return null;
    }

}
