package com.example.university.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Person {

    @Column
    private String firstName;

    @Column
    private  String lastName;

    private Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return " firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + "\'";
    }
}
