package com.intelligrape.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateMain {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for(int i = 1;i<=10;i++){
            session.save(new User("Madhav" + i));
        }

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();

        Query query =  session.createQuery("from User");
        List<User> userList = query.list();
//        session.getTransaction().commit();

        Query query1 = session.createQuery("from User  where id > 5");
        List<User> userList1 = query1.list();
        session.close();
        System.out.println(userList.size());
        System.out.println(userList1.size());

    }
}
