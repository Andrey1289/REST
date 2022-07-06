package andrey.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;
    private static Transaction transaction;
    private static Session session;

    private static SessionFactory getSessionFactory(){
        if(sessionFactory ==null){
            return sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
    public static Session getSession(){
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        return session;
    }
    public static void closeSession(Session session){
        transaction.commit();
        session.close();
    }
}
