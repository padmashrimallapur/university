package com.example.university;

import com.example.university.domain.Course;
import com.example.university.domain.Person;
import com.example.university.domain.Student;
import com.example.university.repo.CourseRepository;
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

    @Autowired
    CourseRepository courseRepository;

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
        courseRepository.findByChairLastName("Sharma").forEach(System.out::println);

        System.out.println("find course where Sharma is department chair member by last name method");
        courseRepository.findByDepartmentChairMemberLastName("Sharma").forEach(System.out::println);

        System.out.println("Find the course English101");
        Course english101 = courseRepository.findByName("English101");

        System.out.println("Find the course where English101 is prerequeisite");
        System.out.println("english101 pid" + english101.getId());
        courseRepository.findCourseByPrerequisites(english101.getId()).forEach(System.out::println);

        System.out.println("\n Course view for the English101 " + courseRepository.getCourseView(english101.getId()));
    }
}
