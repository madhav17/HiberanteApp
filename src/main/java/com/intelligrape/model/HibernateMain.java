package com.intelligrape.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<User> userList  = new ArrayList<User>();
        for(int i = 1; i<=10;i++){
            userList.add(new User("Madhav" + i));
        }
        Iterator iterator = userList.listIterator();
        while (iterator.hasNext()){
            session.save(iterator.next());
        }
        System.out.println("Fetching Data");
        for(int i = 1 ;i<=10;i++){
            System.out.println(((User)session.get(User.class,i)).getUserName());
        }
        User user = (User) session.get(User.class,6);
        User user1 = (User) session.get(User.class,7);

        // delete Object
        session.delete(user1);

        // update object
        User user2 = (User) session.get(User.class,8);
        user2.setUserName("Updated User");
        session.update(user2);
        session.getTransaction().commit();
        session.close();
        System.out.println(user.getUserName());
        // it will access irrespective of session is closed becoz first value can be fetched

    }
}
