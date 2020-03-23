package com.example.university;

import com.example.university.domain.Course;
import com.example.university.domain.Person;
import com.example.university.repo.CourseRepository;
import com.example.university.repo.DepartmentRepository;
import com.example.university.repo.StaffRepository;
import com.example.university.repo.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryDemos {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    @Test
    public void studentQuery() {

        System.out.println("Find 20 year old student");
        studentRepository.findByAge(20).forEach(System.out::println);
        System.out.println("Find full time student");
        studentRepository.findByFullTime(true).forEach(System.out::println);
        System.out.println("Find the student with the last name fey");
        studentRepository.findByAttendeeLastName("fey").forEach(System.out::println);
    }

    @Test
    public void studentIntermediateQuery() {

        System.out.println("Find student by name and traverse entities \n" +
                studentRepository.findByAttendeeFirstNameAndAttendeeLastName("Ansh", "Sharma"));

        System.out.println("Find student by the person Object \n" +
                studentRepository.findByAttendee(new Person("Vijay", "Maja")));

        System.out.println("Find students older than 19 years \n ");
        studentRepository.findByAgeGreaterThan(19).forEach(System.out::println);

        System.out.println("Find student by last name by ignoring the case \n " +
                studentRepository.findByAttendeeLastNameIgnoreCase("maja"));

        System.out.println("Find student with an e in the last name \n");
        studentRepository.findByAttendeeLastNameLike("%e%").forEach(System.out::println);

        System.out.println("Find first student in the alphabet \n" +
                studentRepository.findFirstByOrderByAttendeeLastNameAsc());

        System.out.println("Find the oldest student \n" +
                studentRepository.findTopByOrderByAgeDesc());

        System.out.println("Find the top 3 oldest student \n");
        studentRepository.findTop3ByOrderByAgeDesc().forEach(System.out::println);

        System.out.println("Find the students under 25 years age");
        studentRepository.findByAgeLessThan(25);

    }

    @Test
    public void jqlQuery() {

        courseRepository.findByChairLastName("Sharma").forEach(System.out::println);

        System.out.println("find course where Sharma is department chair member by last name method");
        courseRepository.findByDepartmentChairMemberLastName("Sharma").forEach(System.out::println);

        System.out.println("Find the course English101");

        Course english101 = courseRepository.findByName("English101");

        System.out.println("Find the course where English101 is prerequeisite");
        System.out.println("english101 pid" + english101.getId());
        courseRepository.findCourseByPrerequisites(english101.getId()).forEach(System.out::println);

    }


}
