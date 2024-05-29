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
            return session.createQuery("FROM Writer w LEFT JOIN FETCH w.posts", Writer.class).getResultList();
        }
    }

    @Override
    public Writer showById(Long id) {
        try (Session session = HibernateSessionFactory.session()) {
            return session.createQuery("FROM Writer w LEFT JOIN FETCH w.posts WHERE w.id = :id", Writer.class)
                    .setParameter("id", id).getSingleResult();
        }
    }

    @Override
    public Writer add(Writer writer) {
        try (Session session = HibernateSessionFactory.session()) {
            session.beginTransaction();
            session.save(writer);
            session.getTransaction().commit();
        }
        return writer;
    }

    @Override
    public Writer update(Long id, Writer writer) {
        try (Session session = HibernateSessionFactory.session()) {
            session.beginTransaction();
            session.merge(writer);
            session.getTransaction().commit();
        }
        return writer;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateSessionFactory.session()) {
            Writer writer = session.get(Writer.class, id);
            session.beginTransaction();
            session.remove(writer);
            session.getTransaction().commit();
        }
    }
}
