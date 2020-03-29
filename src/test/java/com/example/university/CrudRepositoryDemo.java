package com.example.university;

import com.example.university.domain.*;
import com.example.university.repo.CourseRepository;
import com.example.university.repo.DepartmentRepository;
import com.example.university.repo.StudentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepositoryDemo {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DepartmentRepository departmentRepository;

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

    @Test
    public void intermediateQueryExamples() {
        System.out.println("Find student by name and traverse entities  First name: Ansh  and Last name : Sharma\n " +
                studentRepository.findByAttendeeFirstNameAndAttendeeLastName("Ansh", "Sharma"));
        System.out.println("Find the student by person object \n" +
                studentRepository.findByAttendee(new Person("Vijay", "Maja")));
        System.out.println("Find the students who are older than 19  \n");
        studentRepository.findByAgeGreaterThan(19).forEach(System.out::println);
        System.out.println("Find the students who are younger than 19 \n");
        studentRepository.findByAgeLessThan(19).forEach(System.out::println);
        System.out.println("Find the student with last name fey despite the case \n" +
                studentRepository.findByAttendeeLastNameIgnoreCase("FEY"));
        System.out.println("Find all the students with 'm' in the last name");
        studentRepository.findByAttendeeLastNameLike("%m%").forEach(System.out::println);
        System.out.println("Find first student in alphabet \n" +
                studentRepository.findFirstByOrderByAttendeeLastNameAsc());
        System.out.println("Find oldest student \n" +
                studentRepository.findTopByOrderByAgeDesc());
        System.out.println("Find 3 oldest student");
        studentRepository.findTop3ByOrderByAgeDesc().forEach(System.out::println);
    }

    /**
     * @Query queries
     * <p>
     * Courses to persisted to H2 in-memory database at startup
     * @See UniversityApplication
     */
    @Test
    public void jpqlQueries() {
        System.out.println("Find courses where Sharma is the department chair with property expression");
        courseRepository.findByDepartmentChairMemberLastName("Sharma").forEach(System.out::println);

        System.out.println("Find the courses where sharma is the department chair using the query");
        courseRepository.findByChairLastName("Sharma").forEach(System.out::println);

        Course course = courseRepository.findByName("English101");
        System.out.println("Find Courses where english 101 is perquisites");
        courseRepository.findCourseByPrerequisites(course.getId()).forEach(System.out::println);
    }

    @Test
    public void pagingAndSortingQueries() {
        System.out.println("Find the Department with the name 'humanities' \n " +
                departmentRepository.findOne(Example.of(new Department("Humanities", null))));

        System.out.println("Find the department with the first name of the chair is 'siya' \n");
        departmentRepository.findAll(Example.of(new Department(null, new Staff(new Person("siya", null))))).forEach(System.out::println);

        System.out.println("Find the department with name ending in 'sciences', case sensitive");
        departmentRepository.findAll(Example.of(new Department("sciences", null), ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.ENDING))).forEach(System.out::println);
    }

    @Before
    @After
    public void printBanner() {
        System.out.println("************************************************************************");
    }
}
