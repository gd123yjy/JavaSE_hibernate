package com.hibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by yjy on 16-9-24.
 */
public class HibernateLoader {

    private static Properties props = null;
    private static Configuration configuration = null;
    private static SessionFactory sessionFactory = null;
    private static Session session = null;

    static {
        try {
            init();
            getConfiguration();
            getSessionFactory();
            //getSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void init() throws ClassNotFoundException, SQLException {
        props = new Properties();
        try {
            props.load(props.getClass().getResourceAsStream("/com/hibernateUtils/hibernate.properties"));
        } catch (Exception e) {
            System.out.println("Error loading hibernate " + "properties.");
            e.printStackTrace();
            System.exit(0);
        }
      /*  String driver = props.getProperty("hibernate.connection." + "driver_class");
        String connUrl = props.getProperty("hibernate.connection.url");
        String username = props.getProperty("hibernate.connection." + "username");
        String password = props.getProperty("hibernate.connection.password");

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(connUrl, username, password);

        Configuration cfg = new Configuration();
        cfg.setProperties( props );
        SessionFactory sessions = cfg.buildSessionFactory();
        Session session = sessions.openSession(conn);*/
    }

    public static Configuration getConfiguration() {
        if (configuration == null) {
            configuration = new Configuration();
            //此处不能写成：/com/bean/Student.hbm.xml,略坑略坑
            configuration.addResource("com/bean/Student.hbm.xml");
            configuration.setProperties(props);
        }
        return configuration;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }
}
