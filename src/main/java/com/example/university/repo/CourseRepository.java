package com.example.university.repo;

import com.example.university.domain.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    Course findByName(String name);

    List<Course> findByDepartmentChairMemberLastName(String chair);

    @Query("Select c from Course c where c.department.chair.member.lastName=:chair")
    List<Course> findByChairLastName(@Param("chair") String chairLastName);

    @Query("select c from Course c join c.prerequisites p where p.id= ?1")
    List<Course> findCourseByPrerequisites(int id);


}
