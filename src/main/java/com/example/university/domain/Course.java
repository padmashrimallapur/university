package com.example.university.domain;

import javax.persistence.*;

@Entity
@Table(name="COURSE")
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @ManyToMany
    @JoinColumn
    private Department department;

    public Course(String name, Department department){
        this.name = name;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    @Override
    public String toString() {
        return "{Courses{" +"id=" +id+ ", name='" + name +'\''+ "department="+ department.getName() + '}';
    }
}
