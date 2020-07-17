package com.tuananhdo.controller.web;

import com.tuananhdo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String listPost(ModelMap map) {
        map.addAttribute("listPost", postService.listAll());
        return "web/home";
    }
}
