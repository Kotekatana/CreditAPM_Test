package ru.test.creditapm.EntityProvider;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EntityManagerProvider {
    private static EntityManager entityManager ;

    static {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        entityManager = sessionFactory.createEntityManager();
    }
    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
