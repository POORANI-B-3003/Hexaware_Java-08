package com.hexaware.sis.service;

import com.hexaware.sis.dao.TeacherDAO;
import com.hexaware.sis.dao.TeacherDAOImplement;
import com.hexaware.sis.entity.Teacher;
import com.hexaware.sis.exception.InvalidTeacherDataException;
import com.hexaware.sis.exception.TeacherNotFoundException;

import java.util.List;

public class TeacherServiceImplement implements TeacherService {
    private TeacherDAO teacherDAO = new TeacherDAOImplement();

    @Override
    public void addTeacher(Teacher teacher) throws Exception {
        if (teacher.getEmail() == null || teacher.getEmail().isEmpty()) {
            throw new InvalidTeacherDataException("Teacher email is required.");
        }
        teacherDAO.addTeacher(teacher);
    }

    @Override
    public Teacher getTeacherById(int teacherId) throws Exception {
        Teacher teacher = teacherDAO.getTeacherById(teacherId);
        if (teacher == null) {
            throw new TeacherNotFoundException("Teacher not found.");
        }
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() throws Exception {
        return teacherDAO.getAllTeachers();
    }
}
