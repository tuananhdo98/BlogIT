package com.tuananhdo.controller.web;

import com.tuananhdo.entity.Posts;
import com.tuananhdo.model.PostDTO;
import com.tuananhdo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/detail-blog{id}")
    public String detailBlog(ModelMap map, @PathVariable("id") int id) {
        map.addAttribute("post",postService.findPostById(id));
        return "web/detail-blog";
    }

    @GetMapping("/detail-blog")
    public String detailBlog() {
        return "web/detail-blog";
    }
}
