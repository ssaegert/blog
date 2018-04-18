package com.example.blog.services;

import com.example.blog.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
        createPost();
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPost(long id) {
        return posts.get((int) id - 1);
    }




    //    public PostService () {
//        posts = new ArrayList<>();
//        createPost();
//    }

//    public List<Post> findAll() {
//        posts = new ArrayList<>();
//        createPost();
//        return posts;
//    }

//    public List<Post> findPostByTitle(String title) {
//
//        int index = posts.indexOf(title);
//    }


    private void createPost() {
        posts.add(new Post("New Post Title 1", "This is a description of post 1."));
        posts.add(new Post("New Post Title 2", "This is a description of post 2."));
        posts.add(new Post("New Post Title 3", "This is a description of post 3."));
        posts.add(new Post("New Post Title 4", "This is a description of post 4."));
    }

    public void save(Post post){
        this.posts.add(post);
    }
}
