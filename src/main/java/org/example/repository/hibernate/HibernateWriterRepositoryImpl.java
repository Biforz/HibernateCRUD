package org.example.repository.hibernate;

import org.example.config.HibernateSessionFactory;
import org.example.model.Writer;
import org.example.repository.WriterRepository;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;

public class HibernateWriterRepositoryImpl implements WriterRepository {
    @Override
    @Transactional
    public List<Writer> showAll() {
        try (Session session = HibernateSessionFactory.session()) {
            return session.createQuery("FROM Writer w LEFT JOIN FETCH w.posts").getResultList();
        }
    }

    @Override
    public Writer showById(Long id) {
        try (Session session = HibernateSessionFactory.session()) {
            Writer writer = session.get(Writer.class, id);
            return writer;
//            return session.createQuery("FROM Writer w LEFT JOIN FETCH w.posts WHERE w.posts = :id", Writer.class)
//                    .setParameter("id", id)
//                    .getSingleResult();
        }
//        return null;
    }

    @Override
    public Writer add(Writer writer) {
        try (Session session = HibernateSessionFactory.session()) {

        }
        return null;
    }

    @Override
    public Writer update(Long id, Writer writer) {
        try (Session session = HibernateSessionFactory.session()) {

        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateSessionFactory.session()) {

        }
    }
}
