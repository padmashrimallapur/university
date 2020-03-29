package com.example.university;

import com.example.university.domain.*;
import com.example.university.repo.CourseRepository;
import com.example.university.repo.DepartmentRepository;
import com.example.university.repo.StaffRepository;
import com.example.university.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Student
        boolean fullTime = true;
        studentRepository.save(new Student(new Person("Ansh", "Sharma"), 20, fullTime));
        studentRepository.save(new Student(new Person("Vijay", "Maja"), 32, fullTime));
        studentRepository.save(new Student(new Person("padma", "Mallapur"), 30, fullTime));
        studentRepository.save(new Student(new Person("Tina", "Fey"), 25, fullTime));

        //Staff
        Staff laura = staffRepository.save(new Staff(new Person("Laura", "ven")));
        Staff sara = staffRepository.save(new Staff(new Person("Sara", "Khan")));
        Staff siya = staffRepository.save(new Staff(new Person("Siya", "Sharma")));
        Staff Avni = staffRepository.save(new Staff(new Person("Avni", "Joshi")));
        Staff preeti = staffRepository.save(new Staff(new Person("Preeti", "Jain")));
        Staff Rutu = staffRepository.save(new Staff(new Person("Rutu", "Varma")));
        Staff Kate = staffRepository.save(new Staff(new Person("Kate", "Reddy")));
        Staff Sanvi = staffRepository.save(new Staff(new Person("Sanvi", "Oberoi")));
        Staff Moni = staffRepository.save(new Staff(new Person("Moni", "Appa")));
        Staff Ram = staffRepository.save(new Staff(new Person("Ram", "Lakhan")));

        //Departments
        Department humanities = departmentRepository.save(new Department("Humanities", siya));
        Department naturalSciences = departmentRepository.save(new Department("NaturalSciences", laura));

        // Course
        Course chemistry = courseRepository.save(new Course("Chemistry", 3, siya, humanities));
        Course english101 = courseRepository.save(new Course("English101", 1, Sanvi, humanities));
        Course english102 = courseRepository.save(new Course("English102", 1, Sanvi, humanities));
        courseRepository.save(english102.addPrerequisite(english101));

        courseRepository.save(new Course("Physics", 4, laura, naturalSciences));
    }
}
