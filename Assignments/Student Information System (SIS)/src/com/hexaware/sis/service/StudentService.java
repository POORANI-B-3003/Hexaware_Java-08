package com.hexaware.sis.service;

import com.hexaware.sis.entity.Student;
import java.util.List;

public interface StudentService {
    void registerStudent(Student student) throws Exception;
    Student getStudentById(int studentId) throws Exception;
    List<Student> getAllStudents() throws Exception;
}

