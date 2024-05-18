package org.example.controller;

import org.example.model.Post;
import org.example.service.PostService;

import java.util.List;

public class PostController {
    private final PostService postService;

    public PostController() {
        this.postService = new PostService();
    }

    public List<Post> getAllPost() {
        return postService.findAllPost();
    }

    public Post getPostById(Long id) {
        return postService.findPostById(id);
    }

    public Post addNewPost(Post post) {
        return postService.addNewPost(post);
    }

    public Post updatedPostBuId(Long id, Post post) {
        return postService.updatedPostById(id, post);
    }

    public void deletedPostById(Long id) {
        postService.deletePostById(id);
    }
}
