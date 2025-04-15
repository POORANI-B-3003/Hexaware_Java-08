package com.hexaware.sis.dao;

import com.hexaware.sis.entity.Teacher;
import java.util.List;

public interface TeacherDAO {
    void addTeacher(Teacher teacher) throws Exception;
    Teacher getTeacherById(int teacherId) throws Exception;
    List<Teacher> getAllTeachers() throws Exception;
}

