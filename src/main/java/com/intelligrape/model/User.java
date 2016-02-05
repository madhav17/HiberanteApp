package com.intelligrape.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id // create PK (Surrogate key)

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;

    // what we need collection to be member address keep track of all the address of user we do not know how many address
    // we also need to intialize it not required and it depend how we intailize it
    // we will require an annotation to let hibernate know that to save this as list

    // it will mark entire collection object to saved and not as embedded as object
    @ElementCollection
    //    @ElementCollection(targetClass = "Address",fetch = FetchType.EAGER)


    private Set<Address> addressSet = new HashSet<Address>();

    /*
    * It will insert the address in User_addressSet table  nameofEntity_collection name
    * and create FK User_userId for reference
    *
    * */

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }


    public User(String userName,Set<Address> addressSet) {
        this.userName = userName;
        this.addressSet = addressSet;
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