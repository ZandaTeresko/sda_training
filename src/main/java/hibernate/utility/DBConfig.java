package hibernate.utility;

import hibernate.entities.Book;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import hibernate.entities.User;

import java.util.Properties;

public class DBConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){

        if(sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                //settings.put(Environment.DRIVER, "coms.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/sda_training");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "224800123asd");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                //settings.put(Environment.HBM2DDL_AUTO, "create_drop");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class); //access through package
                configuration.addAnnotatedClass(Book.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e){
                System.err.println(e);
            }
        }
        return sessionFactory;
    }

    public static void closeConnection(){
        getSessionFactory().close();
    }

}
