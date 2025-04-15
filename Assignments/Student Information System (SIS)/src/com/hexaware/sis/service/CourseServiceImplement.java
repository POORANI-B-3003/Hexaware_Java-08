package com.hexaware.sis.service;

import com.hexaware.sis.dao.CourseDAO;
import com.hexaware.sis.dao.CourseDAOImplement;
import com.hexaware.sis.entity.Course;
import com.hexaware.sis.exception.CourseNotFoundException;
import com.hexaware.sis.exception.InvalidCourseDataException;

import java.util.List;

public class CourseServiceImplement implements CourseService {
    private CourseDAO courseDAO = new CourseDAOImplement();

    @Override
    public void addCourse(Course course) throws Exception {
       
        if (course.getCourseName() == null || course.getCourseName().trim().isEmpty()) {
            throw new InvalidCourseDataException("Course code cannot be empty.");
        }
       
        courseDAO.addCourse(course);
    }


    @Override
    public Course getCourseById(int courseId) throws Exception {
        Course course = courseDAO.getCourseById(courseId);
        if (course == null) {
            throw new CourseNotFoundException("Course not found.");
        }
        return course;
    }

    @Override
    public List<Course> getAllCourses() throws Exception {
        return courseDAO.getAllCourses();
    }


	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}
}


