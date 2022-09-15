package com.narendran.learncourses.Repository;

import com.narendran.learncourses.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseById(Long id);

}