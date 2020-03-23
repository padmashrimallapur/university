package com.example.university.domain;

import javax.persistence.*;

@Entity
@Table(name = "Staff_member")
public class Staff {
    @Id
    @GeneratedValue
    private Integer id;

    @Embedded
    private Person member;

    public Staff(Person member) {
        this.member = member;
    }

    protected Staff() {
    }

    public Person getMember() {
        return this.member;
    }

    @Override
    public String toString() {
        return "+Staff {" +
                "id=" + id +
                ", member " + member + '}';
    }
}
