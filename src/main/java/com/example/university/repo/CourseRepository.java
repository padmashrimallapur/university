package com.example.university.repo;

import com.example.university.domain.Course;
import com.example.university.view.CourseView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("select new com.example.university.view.CourseView" +
            "(c.name, c.instructor.member.lastName, c.department.name) from Course c where c.id=?1")
    CourseView getCourseView(int CourseId);

    List<Course> findByCredits(@Param("credits") int credits);

    Page<Course> findByCredits(@Param("credits") int credits, Pageable pageable);
}
