package org.example.view;

import org.example.controller.PostController;
import org.example.model.Post;
import org.example.model.status.PostStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class PostView {
    private final Scanner scanner;
    private final PostController postController;

    public PostView() {
        this.scanner = new Scanner(System.in);
        this.postController = new PostController();
    }

    public void showAllPost() {
        List<Post> posts = postController.getAllPost();
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    public void showPostById() {
        System.out.print("Введите id для поиска: ");
        Long numberId = scanner.nextLong();
        System.out.println(postController.getPostById(numberId));
    }

    public void saveNewPost() {
        Post post = new Post();
        System.out.print("Введите content: ");
        String content = scanner.nextLine();
        post.setContent(content);
        post.setCreated(LocalDateTime.now());
        post.setUpdated(LocalDateTime.now());
        post.setPostStatus(PostStatus.ACTIVE);

        postController.addNewPost(post);
    }

    public void updatePostById() {
        System.out.print("Введите id для редактирования: ");
        Long numberId = scanner.nextLong();
        Post post = postController.getPostById(numberId);
        scanner.nextLine();
        System.out.print("Введите content: ");
        String newContent = scanner.nextLine();
        post.setId(numberId);
        post.setContent(newContent);
        post.setCreated(post.getCreated());
        post.setUpdated(LocalDateTime.now());
        post.setPostStatus(PostStatus.UNDER_REVIEW);
        postController.updatedPostBuId(numberId, post);
    }

    public void deletedPostById() {
        System.out.print("Введите id для удаления: ");
        Long numberId = scanner.nextLong();
        postController.deletedPostById(numberId);
    }
}
