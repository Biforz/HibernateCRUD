package org.example.repository.hibernate;

import org.example.config.HibernateSessionFactory;
import org.example.model.Label;
import org.example.repository.LabelRepository;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;
import java.util.NoSuchElementException;

public class HibernateLabelRepositoryImpl implements LabelRepository {
    @Override
    public List<Label> showAll() {
        try (Session session = HibernateSessionFactory.session()) {
            return session.createQuery("FROM Label", Label.class).list();
        }
    }

    @Override
    public Label showById(Long id) {
        try (Session session = HibernateSessionFactory.session()) {
            Label label = session.get(Label.class, id);
            if (label == null) {
                throw new NoSuchElementException("id не найден");
            }
            return label;
        }
    }

    @Override
    public Label add(Label label) {
        try (Session session = HibernateSessionFactory.session()) {
            session.beginTransaction();
            session.save(label);
            session.getTransaction().commit();
            return label;
        }
    }

    @Override
    public Label update(Long id, Label label) {
        try (Session session = HibernateSessionFactory.session()) {
            session.beginTransaction();
            session.saveOrUpdate(label);
            session.getTransaction().commit();
            return label;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateSessionFactory.session()) {
            session.beginTransaction();
            Label getLabelById = session.get(Label.class, id);
            if (getLabelById != null) {
                Query query = session.createQuery("DELETE FROM Label WHERE id = :id");
                query.setParameter("id", id);
                query.executeUpdate();
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
