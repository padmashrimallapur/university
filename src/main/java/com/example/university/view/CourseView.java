package com.example.university.view;

public class CourseView {
    private String name;
    private String instructorLastName;
    private String department;

    public CourseView(String name, String instructorLastName, String department) {
        this.name = name;
        this.instructorLastName = instructorLastName;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructorLastName() {
        return instructorLastName;
    }

    public void setInstructorLastName(String instructorLastName) {
        this.instructorLastName = instructorLastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "CourseView{" +
                "name='" + name + '\'' +
                ", instructorLastName='" + instructorLastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
