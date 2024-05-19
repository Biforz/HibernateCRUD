package org.example.config;

import org.example.model.Label;
import org.example.model.Post;
import org.example.model.Writer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Label.class);
                configuration.addAnnotatedClass(Post.class);
                configuration.addAnnotatedClass(Writer.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return sessionFactory;
    }

    public static Session session() {
        return getSessionFactory().openSession();
    }
}
