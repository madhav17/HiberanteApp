package com.intelligrape.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateMain {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Address address = new Address("1","XYZ","123");
        Address address1 = new Address("2","XYZ","123");
        Address address2 = new Address("3","XYZ","123");
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(address);
        addresses.add(address1);
        addresses.add(address2);
        User user = new User("Madhav",addresses);
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        user = null;
        user =(User) session.get(User.class,1);

        // this user object has list of address how to get the list w/o hibernate
        //1. we get user;
        //2. we get address were user_id is of above user;

        // above command will give the user does the list also get pulled up
        // the answer is yes

        // let suppose we have many address . so, when we get user then all address will be pulled and increase cost

        // now we can define fetch strategy

        // by default Fetch is lazy and we can configure it

        System.out.println(user.getUserName());
        System.out.println("sdfsdf");
        System.out.println(user.getAddressList());
        System.out.println("sdfsdf 1");
        System.out.println(user.getAddressList());

        // how calling getter hibernate pull all values
        /*
        * hibernate uses proxy class to get data.Hibernate instead of getting actual we want it will get the proxy of that
        * class that is a sub class of User class
        *
        * when we make a call to getListAdress() it has the code to get data and then it exceute the query get the data.
        *
        * after it does that then it do parent.getList()
        *
        *
        * */




    }
}
