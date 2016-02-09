package com.intelligrape.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "user")
@NamedQuery(name="User.findById",query="from User where id = ?")
// it will require 2 parameters
//1st name of query
//2nd is query itself
// this query will give me user object of that id supplied
// parameter can be named or positional
@NamedNativeQuery(name="User.findByUserName",query = "select * from user where userName = ?",resultClass = User.class)
// now it is an SQL we need to refer column names and table name
// we can specify result class name in that why we need it
//if it a named namedquery(HQL) we now the class but in native hibernate does not know what object to cast Result
//class allow hibernate to know and cast into that object
// the advantage is that we have a stored procedure and we need to run we can use this option and can run it
public class User {

    @Id // create PK (Surrogate key)
    @GeneratedValue
    private int userId;

    private String userName;


    public User(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User() {

    }
}




/*
*
* Natural Key - one column has unique and it is required like email ID then it can be PK i.e key a Natural Key. Column which are there for business and assigned as PK is called NK
*
* surrogate key - more than one column can be marked as PK i.e a surrogate key
*
* In current system we do not know any column can marked as unique or we do not have it. In then that case we add a column to act as key
* i.e called as surrogate key
*
* so,if it as NK then it is our duty to provide Value
* and if it is surrogate key then we can ask hibernate to do that becoz it does not matter for us.
*
* */