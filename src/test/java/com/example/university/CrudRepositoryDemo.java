package com.example.university;

import com.example.university.domain.Person;
import com.example.university.domain.Student;
import com.example.university.repo.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepositoryDemo {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void simpleStudentCrudExample() {
        studentRepository.save(new Student(new Person("padmashri", "mallapur"), 20, true));

        System.out.println("\n*************Original student*************");
        studentRepository.findAll().forEach(System.out::println);

        //age up the students
        studentRepository.findAll().forEach(student -> {
            student.setAge(student.getAge() + 1);
            studentRepository.save(student);
        });

        System.out.println("\n*********** age up students ***********");
        studentRepository.findAll().forEach(System.out::println);

        studentRepository.deleteAll();
        System.out.println("\n***************Students Removed***************");
        studentRepository.findAll().forEach(System.out::println);

    }
}
