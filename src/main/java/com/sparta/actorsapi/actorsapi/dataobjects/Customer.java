package com.sparta.actorsapi.actorsapi.dataobjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    public Customer(int id, String firstName, String lastName, String email){
        this.customerId=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    public Customer(int id, String firstName){
        this(id, firstName, null, null);
    }

    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("First Name")
    private String firstName;
    private String lastName;
    private String email;


}
