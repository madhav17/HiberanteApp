package com.intelligrape.model;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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

        User user = (User)session.get(User.class,1); // now it fetch user object from DB
        // assume there is lot of code b/w and we again fetch that same user
//        user.setUserName("sdfdsfs");
        User user2 = (User)session.get(User.class,1); // now it will not fetch user object from DB it will pick from cache
        // The reason is that the hibernate know b/w these 2 line there is no code for updating data so it will fetch from cache

        // and if update the same user and again fetch it then there will be 1 select query because hibernate has the
        //update will get from update command

        session.getTransaction().commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        session2.get(User.class,1);
        session2.getTransaction().commit();
        session2.close();

        // now for session 2 it will fetch from DB again becoz first session is closed so its cache also

        // This problem will be solved in second level cache both these session will talk to second level cache.
       // Once we have object in second level cache then session 2 will get data from second level cache and go to
        // database if not found in 1st and 2nd level cache
    }
}
