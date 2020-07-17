package com.tuananhdo.controller.admin;

import com.tuananhdo.entity.Posts;
import com.tuananhdo.model.PostDTO;
import com.tuananhdo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Controller
public class PostAdminController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/morePost")
    public String addProduct(Model map) {
        map.addAttribute("post", new PostDTO());
        return "admin/morePost";
    }

//    @GetMapping(value = "/403")
//    public String access() {
//        return "admin/403";
//    }

    @PostMapping(value = "/save")
    public String addProduct(@ModelAttribute(name = "post") MultipartFile file, com.tuananhdo.entity.Posts posts, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/morePost";
        } else {
            try {
                posts.setImageUrl(file.getOriginalFilename());
                File newFile = new File("/Users/TuanAnhDo/Desktop/MyBlogIT/src/main/resources/static/web/post/" + file.getOriginalFilename());
                FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                fileOutputStream.write(file.getBytes());
                fileOutputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            postService.savePost(posts);
        }
        return "redirect:/admin-home";
    }


    @GetMapping(value = "/editPost/{id}")
    public String editProduct(ModelMap map, @PathVariable(name = "id") int id, PostDTO postDTO) {
        map.addAttribute("post", postService.findPostById(id));
        map.addAttribute("post", postDTO);
        return "admin/editPost";
    }

    @PostMapping(value = "/editPost")
    public String editProduct(@ModelAttribute(name = "product") Posts posts, MultipartFile file) {
        try {
            posts.setImageUrl(file.getOriginalFilename());
            File newFile = new File("/Users/TuanAnhDo/Desktop/MyBlogIT/src/main/resources/static/web/post/" + file.getOriginalFilename());
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        postService.savePost(posts);

        return "redirect:/admin-home";
    }


    @GetMapping(value = "/deletePost/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        postService.deletePost(id);
        return "redirect:/admin-home";
    }

//    @GetMapping(value = "/logout-admin")
//    public String logoutAdmin(HttpServletRequest request, HttpServletResponse response) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            new SecurityContextLogoutHandler().logout(request, response, authentication);
//        }
//        return "redirect:/";
//    }

    @GetMapping(value = "/logout-admin")
    public String logoutAdmin() {
        return "redirect:/";
    }
}
