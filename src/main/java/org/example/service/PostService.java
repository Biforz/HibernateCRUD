package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Post;
import org.example.repository.PostRepository;
import org.example.repository.hibernate.HibernatePostRepositoryImpl;

import java.util.List;

@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        this.postRepository = new HibernatePostRepositoryImpl();
    }

    public List<Post> findAllPost() {
        return postRepository.showAll();
    }

    public Post findPostById(Long id) {
        return postRepository.showById(id);
    }

    public Post addNewPost(Post post) {
        return postRepository.add(post);
    }

    public Post updatedPostById(Long id, Post post) {
        return postRepository.update(id, post);
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
