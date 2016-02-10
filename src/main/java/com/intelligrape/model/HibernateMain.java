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

        User exampleUser = new User();
        // we can set multiple porperties
//        exampleUser.setUserName("Madhav1"); // we set the value to fetch value accordingly
        // used with
        exampleUser.setUserName("Madhav%"); // we set the value to fetch value accordingly
//        exampleUser.setUserId(1); // we set the value to fetch value accordingly

        // now we create example object which hibernate can use and pass our example use Object
//        Example example = Example.create(exampleUser);
//        Example example = Example.create(exampleUser).excludeProperty("userName");
        // used with like
        Example example = Example.create(exampleUser).enableLike();

        Criteria criteria = session.createCriteria(User.class)
                            .add(example);
        // createCriteria has add which takes criteria

        // so,now what is the need of this let's see
        //lets comment setUserName then it will return all user reason
        //now we comment setUserid then only match record will be displayed

        /*
        *
        * The reason is hibernate ignores 2 things considering example is if any of the property has the value
        * of null it will not consider it.
        *
        * If property happens to be a primary key it will not consider that
         *
         * apart from the above it consider every thing
        *
        *
        * while creating example object we can ask hibenrate to exlcude or ignore properties using exclude
        * method
        *
        * we can also like operator using enable like
        *
        * */

        List<User> userIdList = criteria.list();


        session.getTransaction().commit();
        session.close();
        for(User user: userIdList){
            System.out.println(user.getUserName());
        }

    }
}
