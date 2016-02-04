package com.intelligrape.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    //1st Way

    // So now these name is common in every entity which embed this
    @Column(name = "city_name")
    private String city;

    @Column(name = "state_name")
    private String state;

    @Column(name="pin_Code")
    private String pinCode;

    public Address() {

    }

    public Address(String city,String state,String pinCode){
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
