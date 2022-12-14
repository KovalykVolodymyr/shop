package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import entities.Product;
import entities.Bying;

/**
 * Java based configuration
 * 
 * @author ramesh Fadatare
 *
 */
public class HibernateUtil {
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      try {
        Configuration configuration = new Configuration();

        // Hibernate settings equivalent to hibernate.cfg.xml's properties
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.h2.Driver");
        settings.put(Environment.URL, "jdbc:h2:mem:test");
        settings.put(Environment.USER, "sa");
        settings.put(Environment.PASS, "");
        settings.put(Environment.POOL_SIZE, "1");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");

        configuration.setProperties(settings);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Bying.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate Java Config serviceRegistry created");
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return sessionFactory;
  }
}