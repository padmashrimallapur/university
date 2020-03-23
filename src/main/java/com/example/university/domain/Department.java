package com.example.university.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @OneToOne
    private Staff chair;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    private Department() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department(String name, Staff chair) {
        this.name = name;
        this.chair = chair;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    @Override
    public String toString() {
        return "{Department{" +"id=" +id+ ", name='" + name +'\''+ "course="+ courses + '}';
    }
}
