package com.example.university.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
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

    public Student(Integer studentId, Integer age, boolean fullTime){
        this.studentId = studentId;
        this.age = age;
        this.fullTime = fullTime;
        courses = new ArrayList<>();
    }

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
