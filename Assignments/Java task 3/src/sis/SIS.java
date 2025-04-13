package sis;

import com.hexaware.sis.entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SIS {
    private List<Student> students;
    private List<Course> courses;
    private List<Teacher> teachers;

    public SIS() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void enrollStudentInCourse(Student student, Course course) {
        student.enrollInCourse(course);
        course.addStudent(student);
    }

    public void assignTeacherToCourse(Teacher teacher, Course course) {
        course.assignTeacher(teacher);
        teacher.assignCourse(course);
    }

    public void recordPayment(Student student, double amount, Date paymentDate) {
        Payment payment = new Payment(student, amount, paymentDate);
        student.addPayment(payment);
    }

    public void generateEnrollmentReport(Course course) {
        course.displayEnrolledStudents();
    }

    public void generatePaymentReport(Student student) {
        student.displayPayments();
    }

    public void calculateCourseStatistics(Course course) {
        System.out.println("Total Students Enrolled: " + course.getEnrolledStudents().size());
    }
}
