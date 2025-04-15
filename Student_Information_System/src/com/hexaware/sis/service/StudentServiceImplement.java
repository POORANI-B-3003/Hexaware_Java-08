package com.hexaware.sis.service;

import com.hexaware.sis.dao.StudentDAO;
import com.hexaware.sis.dao.StudentDAOImplement;
import com.hexaware.sis.entity.Student;
import com.hexaware.sis.exception.InvalidStudentDataException;
import com.hexaware.sis.exception.StudentNotFoundException;

import java.util.List;

public class StudentServiceImplement implements StudentService {
    private StudentDAO studentDAO = new StudentDAOImplement();

    @Override
    public void registerStudent(Student student) throws Exception {
        if (student.getEmail() == null || !student.getEmail().contains("@")) {
            throw new InvalidStudentDataException("Invalid email format.");
        }
        studentDAO.addStudent(student);
    }

    @Override
    public Student getStudentById(int studentId) throws Exception {
        Student student = studentDAO.getStudentById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found.");
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        return studentDAO.getAllStudents();
    }
}

