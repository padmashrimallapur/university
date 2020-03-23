package com.example.university;

import com.example.university.repo.DepartmentRepository;
import com.example.university.repo.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UniversityApplicationTests {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

}
