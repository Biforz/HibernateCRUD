package org.example.repository.hibernate;

import org.example.model.Post;
import org.example.model.status.PostStatus;
import org.example.repository.PostRepository;
import org.example.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class HibernatePostRepositoryImplTest {
    private final PostRepository postRepository = Mockito.mock(PostRepository.class);
    private final PostService postService = new PostService(postRepository);
    private Post post;

    @BeforeEach
    void setUp() {
        post = Post.builder()
                .id(1L)
                .content("testContent")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .postStatus(PostStatus.ACTIVE)
                .build();
    }

    @Test
    void getAllPost() {
        List<Post> posts = new ArrayList<>();
        posts.add(post);

        when(postService.findAllPost()).thenReturn(posts);

        List<Post> postsActual = postService.findAllPost();

        assertNotNull(postsActual);
        assertEquals(postsActual, posts);
    }

    @Test
    void getPostById() {
        when(postService.findPostById(1L)).thenReturn(post);

        Post actualPost = postService.findPostById(1L);

        assertNotNull(actualPost);
        assertEquals(actualPost.getId(), post.getId());
        assertEquals(actualPost.getContent(), post.getContent());
        assertEquals(actualPost.getCreated(), post.getCreated());
        assertEquals(actualPost.getUpdated(), post.getUpdated());
        assertEquals(actualPost.getPostStatus(), post.getPostStatus());
    }

    @Test
    void createdNewPost() {
        when(postService.addNewPost(post)).thenReturn(post);

        Post actualPost = postService.addNewPost(post);

        assertNotNull(actualPost);
        assertEquals(actualPost.getId(), post.getId());
        assertEquals(actualPost.getContent(), post.getContent());
        assertEquals(actualPost.getCreated(), post.getCreated());
        assertEquals(actualPost.getUpdated(), post.getUpdated());
        assertEquals(actualPost.getPostStatus(), post.getPostStatus());
    }

    @Test
    void updatedPost() {
        when(postService.updatedPostById(1L, post)).thenReturn(post);

        Post actualPost = postService.updatedPostById(1L, post);

        assertNotNull(actualPost);
        assertEquals(actualPost.getId(), post.getId());
        assertEquals(actualPost.getContent(), post.getContent());
        assertEquals(actualPost.getCreated(), post.getCreated());
        assertEquals(actualPost.getUpdated(), post.getUpdated());
        assertEquals(actualPost.getPostStatus(), post.getPostStatus());
    }

    @Test
    void deletePost() {
        postService.deletePostById(1L);
        verify(postRepository, times(1)).deleteById(1L);
    }
}
