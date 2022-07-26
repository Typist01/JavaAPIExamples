package com.sparta.actorsapi.actorsapi.dataobjects;

import java.util.Date;

public class Actor {

    public Actor(int id, String firstName, String lastName, Date date){
        this.actorId=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.lastUpdate=date;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
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

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    private int actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;
}

