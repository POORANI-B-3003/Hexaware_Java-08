package sis;

import com.hexaware.sis.entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.hexaware.sis.exception.DuplicateEnrollmentException;
import com.hexaware.sis.exception.InvalidPaymentException;


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

    public void enrollStudentInCourse(Student student, Course course) throws DuplicateEnrollmentException {
        if (course.getEnrolledStudents().contains(student)) {
            throw new DuplicateEnrollmentException("Student is already enrolled in this course.");
        }
        student.enrollInCourse(course);
        course.addStudent(student);
    }

    // Add Enrollment with enrollment date
    public void addEnrollment(Student student, Course course, Date enrollmentDate) {
        Enrollment enrollment = new Enrollment(student, course, enrollmentDate);
        student.enrollInCourse(course);
        course.addStudent(student);
    }

    // Assign course to teacher (already implemented, renamed for clarity)
    public void assignCourseToTeacher(Course course, Teacher teacher) {
        course.assignTeacher(teacher);
        teacher.assignCourse(course);
    }

    // Add payment (already implemented, renamed for clarity)
    public void addPayment(Student student, double amount, Date paymentDate) {
        Payment payment = new Payment(student, amount, paymentDate);
        student.addPayment(payment);
    }

    // Get enrollments for student
    public void getEnrollmentsForStudent(Student student) {
        System.out.println("Enrollments for " + student.getFirstName() + ":");
        for (Course c : student.getCourses()) {
            System.out.println("- " + c.getCourseName());
        }
    }

    // Get courses for teacher
    public void getCoursesForTeacher(Teacher teacher) {
        System.out.println("Courses assigned to " + teacher.getName() + ":");
        for (Course c : teacher.getAssignedCourses()) {
            System.out.println("- " + c.getCourseName());
        }
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
