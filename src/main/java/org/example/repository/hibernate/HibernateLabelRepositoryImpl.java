package org.example.repository.hibernate;

import org.example.config.HibernateSessionFactory;
import org.example.model.Label;
import org.example.repository.LabelRepository;
import org.hibernate.Session;

import java.util.List;

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
                throw new IllegalArgumentException("id не найден");
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
            label = Label.builder()
                    .id(id)
                    .name(label.getName())
                    .build();
            session.beginTransaction();
            session.saveOrUpdate(label);
            session.getTransaction().commit();
            return label;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateSessionFactory.session()) {
//            session.beginTransaction();
//            Label label;
//            label = session.find(Label.class, id);
//            session.createQuery("delete from Label where id = :id")
//                            .setParameter("id", label.getId())
//                            .executeUpdate();
//            session.beginTransaction().commit();


            Label label;
            label = session.find(Label.class, id);
            session.beginTransaction();
            session.remove(label);
            session.flush();
            session.clear();
            session.beginTransaction().commit();
        }
    }
}
