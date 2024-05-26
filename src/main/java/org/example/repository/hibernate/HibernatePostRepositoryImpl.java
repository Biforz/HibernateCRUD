package org.example.repository.hibernate;

import org.example.config.HibernateSessionFactory;
import org.example.model.Post;
import org.example.model.status.PostStatus;
import org.example.repository.PostRepository;
import org.hibernate.Session;

import java.util.List;

public class HibernatePostRepositoryImpl implements PostRepository {
    @Override
    public List<Post> showAll() {
        try (Session session = HibernateSessionFactory.session()) {
            return session.createQuery("FROM Post p LEFT JOIN FETCH p.labels").getResultList();
        }
    }

    @Override
    public Post showById(Long id) {
        try (Session session = HibernateSessionFactory.session()) {
            return session.createQuery("FROM Post p LEFT JOIN FETCH p.labels WHERE p.id = :id", Post.class)
                    .setParameter("id", id).getSingleResult();
        }
    }

    @Override
    public Post add(Post post) {
        try (Session session = HibernateSessionFactory.session()) {
            session.beginTransaction();
            session.save(post);
            session.getTransaction().commit();
        }
        return post;
    }

    @Override
    public Post update(Long id, Post post) {
        try (Session session = HibernateSessionFactory.session()) {
            session.beginTransaction();
            session.update(post);
            session.getTransaction().commit();
        }
        return post;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateSessionFactory.session()) {
            session.beginTransaction();
            Post resultPost = session.get(Post.class, id);
            if (resultPost != null) {
                resultPost.setPostStatus(PostStatus.DELETED);
                session.update(resultPost);
            }
            session.getTransaction().commit();
        }
    }
}
