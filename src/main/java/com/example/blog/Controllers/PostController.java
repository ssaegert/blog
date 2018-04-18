package com.example.blog.Controllers;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class PostController {
//    @GetMapping("/posts")
//    @ResponseBody
//    public String allPosts() {
//        return "posts index page";
//    }
//
//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String singlePost(@PathVariable int id) {
//        return "viewing post number - " + id;
//    }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String createPostForm() {
//        return "view the form for creating a post";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createPost() {
//        return "create a new post";
//    }
//}
import com.example.blog.Post;
import com.example.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostService postsvc;


    public PostController(PostService posts) {
        this.postsvc = posts;
    }



    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postsvc.getAllPosts());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("posts", postsvc.getPost(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String create(Model viewModel) {
        viewModel.addAttribute("newPost", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@ModelAttribute Post newPost) {
        postsvc.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("posts", postsvc.getPost(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post editPost) {
        postsvc.save(editPost);
        return "redirect:/posts";
    }

}
