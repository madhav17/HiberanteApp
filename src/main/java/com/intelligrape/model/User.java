package com.intelligrape.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user")
public class User {

    @Id // create PK (Surrogate key)

    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(generator = "increment")
    private int userId;

    private String userName;


    /*
    * we do not have PK in user_address table and no index in it.
    *
    * How we can define it
    *
    * So,in order to define index we should use that data type which
    * support index that is List not Set.
    *
    * But we choose Interface Collection for Some reason
    *
    * How to Define PK for Collection table
    *
    * @CollectionId
    *
    * all the other annotation are from jpa annotation
    *
    * that means all the annotation are jpa annotation
    *
    * hibernate jpa annotation implement and this feature is additional feature
    *
    *
    * If we change our implementer(Hibernate) than this annotation will not work
    *
    * options in @CollectionId
    *
    * columns - to be defined as PK
    * generator - how PK should be generated
    * type - type of PK data type
    *
    * generator - we need to @GenericGenerator and define its name and strategy
    * and its name is provide in generator
    *
    * Summary
    *
    * In order to have a collection of object as member variable inside the entity class
    *
    * 1. Change the data type of collection which supports index i.e list
    * 2. @CollectionId annotation - tell this collection should have identifier
    * 3. then define it property and for that we need generated and we need generic generator
    *
    * and we need to define id becoz address does not have id becoz it will persist in DB becoz it is an embedded object.
    *
    *
    * */

    @ElementCollection
    @JoinTable(name = "user_address",joinColumns = @JoinColumn(name = "user_id")) // it will change the table name and join column name

    @GenericGenerator(name = "hilo-gen",strategy = "hilo")
//    @GenericGenerator(name = "hilo-gen",strategy = "uuid")
//    @GenericGenerator(name = "hilo-gen",strategy = "increment")
    @CollectionId(columns = {@Column(name = "address_id")},generator = "hilo-gen",type = @Type(type = "long"))
     private Collection<Address> addressList = new ArrayList<Address>();


    public Collection<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }


    public User(String userName,List<Address> addressList) {
        this.userName = userName;
        this.addressList = addressList;
    }

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