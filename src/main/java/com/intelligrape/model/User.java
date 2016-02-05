package com.intelligrape.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    // So let suppose our is the combination of 2 columns and that itself is an object
    // how to do it

    //@Id and @Embeddded annotation will not work

    //@EmbeddedId as an Id
    //private LoginName loginName;
    // and we override the attribute also



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

    //    @Embedded
//    @Embedded

    // Now we have 2 address in User and both the column name cannot be same for home and office address
    //How to fix it or override it

    //override

    //it help is re configure it or change their default behaviour
    // it name of the attribute/field which is attribute to be overridded
    // AttributeOverrides allow us to override multiple attribute in one go
    @AttributeOverrides({

    // here we can also overidde the constraints also
    @AttributeOverride(name = "city" , column = @Column(name = "homeAddress_city",nullable = false )),
    @AttributeOverride(name = "state" , column = @Column(name = "homeAddress_state")),
    @AttributeOverride(name = "pinCode" , column = @Column(name = "homeAddress_pin_code",nullable = false ))

    })
    private Address homeAddress;

    private Address officeAddress;


    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public User(String userName,Address homeAddress,Address officeAddress) {
        this.userName = userName;
        this.homeAddress = homeAddress;
        this.officeAddress = officeAddress;
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