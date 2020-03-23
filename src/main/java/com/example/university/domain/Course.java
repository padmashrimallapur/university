package com.example.university.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="COURSE")
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer credits;

    @ManyToOne
    @JoinColumn
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> prerequisites = new ArrayList<>();


    @OneToOne
    private Staff instructor;

    public Course(String name, Integer credits, Staff instructor, Department department) {
        this.name = name;
        this.department = department;
        this.credits = credits;
        this.instructor = instructor;
    }

    protected Course() {
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

    public Course addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
        return this;
    }

    @Override
    public String toString() {
        return "{Courses{" +"id=" +id+ ", name='" + name +'\''+ "department="+ department.getName() + '}';
    }
}
