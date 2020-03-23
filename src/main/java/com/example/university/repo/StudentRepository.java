package com.example.university.repo;

import com.example.university.domain.Person;
import com.example.university.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByAge(int age);

    List<Student> findByFullTime(boolean fullTime);

    List<Student> findByAttendeeLastName(String fey);

    Student findByAttendeeFirstNameAndAttendeeLastName(String firstName, String lastName);

    Student findByAttendee(Person attendee);

    List<Student> findByAgeGreaterThan(int minimumAge);

    List<Student> findByAgeLessThan(int maximumAge);

    List<Student> findByAttendeeLastNameIgnoreCase(String lastName);

    List<Student> findByAttendeeLastNameLike(String likeString);

    Student findFirstByOrderByAttendeeLastNameAsc();

    Student findTopByOrderByAgeDesc();

    List<Student> findTop3ByOrderByAgeDesc();

}
