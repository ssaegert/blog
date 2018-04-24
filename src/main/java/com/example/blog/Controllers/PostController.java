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
import com.example.blog.models.User;
import com.example.blog.repositories.PostRepository;
import com.example.blog.models.Post;
import com.example.blog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;



    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }



    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("posts", postDao.findById(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String create(Model viewModel) {
        viewModel.addAttribute("newPost", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@ModelAttribute Post newPost) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newPost.setUser(user);
        System.out.println("post user: " + newPost.getUser().getEmail());
        postDao.save(newPost);
        return "redirect:/";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("posts", postDao.findById(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post editPost) {
        postDao.save(editPost);
        return "redirect:/";
    }

    @GetMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("posts", postDao.findById(id));
        return "/posts/delete";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post deletePost) {
        postDao.delete(deletePost);
        return "redirect:/";
    }

    @GetMapping("/posts/register")
    public String createUser(Model viewModel) {
        viewModel.addAttribute("newUser", new User());
        return "/posts/register";
    }



    @PostMapping("/posts/register")
    public String insertUser(@ModelAttribute User newUser) {
        userDao.save(newUser);
        return "redirect:/";
    }


}
