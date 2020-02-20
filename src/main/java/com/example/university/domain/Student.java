package com.example.university.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue
    private Integer studentId;
    @Column
    private Integer age;
    @Column
    private boolean fullTime;
    @Embedded
    private Person attendee;

    @OneToMany
    private List<Course> courses;

    public Student(Person attendee, Integer age, boolean fullTime){
        this.attendee = attendee;
        this.age = age;
        this.fullTime = fullTime;
        courses = new ArrayList<>();
    }

    protected Student(){}

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public Person getAttendee() {
        return attendee;
    }

    public void setAttendee(Person attendee) {
        this.attendee = attendee;
    }


    @Override
    public String toString() {
        return "Student{" + "studentId =" + studentId + ", attendee=" + attendee +", fullTime="+ fullTime +", age="+age +"}\n";
    }
}
