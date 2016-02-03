package com.intelligrape.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Transient
    private String userName;

    public static String getPos() {
        return pos;
    }

    public static void setPos(String pos) {
        UserDetails.pos = pos;
    }

    private static String pos;
    @Temporal(TemporalType.DATE)
//    @Temporal(TemporalType.TIME)
//    @Temporal(TemporalType.TIMESTAMP)
    private Date joinedDate;
    private String Address;
    private String description;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName + "fdgfdfd";

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserDetails(String userName, Date joinedDate, String address, String description) {
        this.userName = userName;
        this.joinedDate = joinedDate;
        Address = address;
        this.description = description;
    }

    public UserDetails(){
        
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getAddress() {
        return Address + "Address";
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
