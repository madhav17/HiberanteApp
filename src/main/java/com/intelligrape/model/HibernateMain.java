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

        // here we use session object to get named query it take name of the query
        Query query = session.getNamedQuery("User.findByUserName");
//        Query query = session.getNamedQuery("User.findById");
//        query.setInteger(0,1);
        query.setString(0,"Madhav1");
        List<User> userList = query.list();
        session.getTransaction().commit();
        session.close();

        for(User user : userList){
            System.out.println(user.getUserName());
        }

    }
}
