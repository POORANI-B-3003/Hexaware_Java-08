package com.hexaware.sis.dao;

import com.hexaware.sis.entity.Course;
import java.util.List;

public interface CourseDAO {
    void addCourse(Course course) throws Exception;
    Course getCourseById(int courseId) throws Exception;
    List<Course> getAllCourses() throws Exception;
}

