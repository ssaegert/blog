package com.example.blog.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String body;

    @OneToOne
    private User user;

    public Post() {
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(long id, String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.id = id;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
