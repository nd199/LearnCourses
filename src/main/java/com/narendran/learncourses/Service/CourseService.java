package com.narendran.learncourses.Service;

import com.narendran.learncourses.Entity.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);

    List<Course> getCourses();

    Course getCourseByCourseId(Long id);

    Course updateCourse(Course course);

    void deleteCourseById(Long id);
}
