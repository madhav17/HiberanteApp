package com.intelligrape.model;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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

        // Projection is gerenally used for implementing agreegate function and grouping function
        Criteria criteria = session.createCriteria(User.class)
                            .setProjection(Projections.property("userId"))
                            .addOrder(Order.desc("userId"));

        //aggregration
//        Criteria criteria = session.createCriteria(User.class)
//                .setProjection(Projections.max("userId"));

    // ordering

        List<Integer> userIdList = criteria.list();


        session.getTransaction().commit();
        session.close();
        for(Integer id : userIdList){
            System.out.println(id);
        }

    }
}
