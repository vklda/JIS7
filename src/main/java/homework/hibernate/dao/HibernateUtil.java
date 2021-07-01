package homework.hibernate.dao;

import homework.hibernate.entity.Lecturer;
import homework.hibernate.entity.Student;
import homework.hibernate.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                var configuration = new Configuration();
                var properties = loadProperties();
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(Lecturer.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(User.class);
                var serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private Properties loadProperties() {
        var properties = new Properties();
        try (var fis = new FileInputStream("src\\main\\resources\\hibernate.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
