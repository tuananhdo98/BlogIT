package com.tuananhdo.controller.admin;

import com.tuananhdo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeAdminController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/admin-home")
    public String list(Model map) {
        map.addAttribute("allPost",postService.listAll());
        return "admin/admin-home";
    }



}
