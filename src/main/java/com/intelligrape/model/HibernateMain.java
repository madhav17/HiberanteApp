package com.intelligrape.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateMain {

    public static void main(String[] args) {
        System.out.println("fdgdg");
        UserDetails userDetails = new UserDetails("Madhav",new Date(),"First Address","desc");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();

        userDetails = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        // takes 2 arqument 1st class to be retrieved
        // for fetch data we need to tell hibernate what model object we trying to fetch i.e class name
        // like * from table name
        // 2nd is primary key and find it value where id = 1
        userDetails = (UserDetails)session.get(UserDetails.class,1);
        System.out.println(userDetails.getUserName());

    }
}
