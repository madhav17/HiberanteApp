package com.intelligrape.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id // create PK (Surrogate key)
//    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue asking hibernate to generate value and it check the data type and generate value

//        @GeneratedValue(strategy = GenerationType.AUTO)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
//It has some strategy and its of 4 type by default it auto
    // auto means hibernate decide startegy to use to generate unique keys
    private int userId;

    private String userName;

    @Embedded
//    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public User(String userName,Address address) {
        this.userName = userName;
        this.address = address;
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

    public User(){

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