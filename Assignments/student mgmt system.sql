create database sisdb;
use sisdb;

-- Task 1: Create the necessary tables for the Student Information System
CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DOB DATE,
    Gender VARCHAR(10),
    ContactNumber VARCHAR(15),
    Email VARCHAR(100)
);

CREATE TABLE Courses (
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(100),
    CourseCode VARCHAR(20),
    Credits INT
);

CREATE TABLE Enrollments (
    EnrollmentID INT PRIMARY KEY,
    StudentID INT,
    CourseID INT,
    EnrollmentDate DATE,
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

CREATE TABLE Faculty (
    FacultyID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Department VARCHAR(50),
    Email VARCHAR(100)
);

-- Insert sample Students
INSERT INTO Students (student_id, first_name, last_name, date_of_birth, email, phone_number) VALUES
(1, 'John', 'Doe', '2000-05-15', 'john.doe@example.com', '9876543210'),
(2, 'Jane', 'Smith', '2001-08-22', 'jane.smith@example.com', '9876543221'),
(3, 'Mike', 'Johnson', '2000-09-10', 'mike.johnson@example.com', '9876543232'),
(4, 'Emily', 'Davis', '1999-11-05', 'emily.davis@example.com', '9876543243'),
(5, 'Robert', 'Brown', '2001-06-30', 'robert.brown@example.com', '9876543254'),
(6, 'Laura', 'Wilson', '2002-02-18', 'laura.wilson@example.com', '9876543265'),
(7, 'David', 'Clark', '1998-07-25', 'david.clark@example.com', '9876543276'),
(8, 'Sophia', 'Lopez', '2000-12-12', 'sophia.lopez@example.com', '9876543287'),
(9, 'Daniel', 'White', '2001-03-09', 'daniel.white@example.com', '9876543298'),
(10, 'Olivia', 'Martin', '1999-10-22', 'olivia.martin@example.com', '9876543309');

-- Insert sample Teachers
INSERT INTO Teacher (teacher_id, first_name, last_name, email) VALUES
(1, 'Alice', 'Johnson', 'alice.johnson@example.com'),
(2, 'Bob', 'Williams', 'bob.williams@example.com'),
(3, 'Charlie', 'Brown', 'charlie.brown@example.com'),
(4, 'Diana', 'Taylor', 'diana.taylor@example.com'),
(5, 'Edward', 'Harris', 'edward.harris@example.com'),
(6, 'Fiona', 'Clark', 'fiona.clark@example.com'),
(7, 'George', 'Lewis', 'george.lewis@example.com'),
(8, 'Hannah', 'Walker', 'hannah.walker@example.com'),
(9, 'Ian', 'Scott', 'ian.scott@example.com'),
(10, 'Julia', 'Evans', 'julia.evans@example.com');

-- Insert sample Courses
INSERT INTO Courses (course_id, course_name, credits, teacher_id) VALUES
(1, 'Database Systems', 4, 1),
(2, 'Operating Systems', 3, 2),
(3, 'Data Structures', 4, 3),
(4, 'Machine Learning', 3, 4),
(5, 'Networking', 3, 5),
(6, 'Cyber Security', 4, 6),
(7, 'Software Engineering', 3, 7),
(8, 'Cloud Computing', 4, 8),
(9, 'Artificial Intelligence', 3, 9),
(10, 'Big Data Analytics', 4, 10);

-- Insert sample Enrollments
INSERT INTO Enrollments (enrollment_id, student_id, course_id, enrollment_date) VALUES
(1, 1, 1, '2024-01-10'),
(2, 2, 2, '2024-01-12'),
(3, 3, 3, '2024-01-14'),
(4, 4, 4, '2024-01-16'),
(5, 5, 5, '2024-01-18'),
(6, 6, 6, '2024-01-20'),
(7, 7, 7, '2024-01-22'),
(8, 8, 8, '2024-01-24'),
(9, 9, 9, '2024-01-26'),
(10, 10, 10, '2024-01-28');

-- Insert sample Payments
INSERT INTO Payments (payment_id, student_id, amount, payment_date) VALUES
(1, 1, 500.00, '2024-02-01'),
(2, 2, 700.00, '2024-02-03'),
(3, 3, 600.00, '2024-02-05'),
(4, 4, 800.00, '2024-02-07'),
(5, 5, 550.00, '2024-02-09'),
(6, 6, 900.00, '2024-02-11'),
(7, 7, 750.00, '2024-02-13'),
(8, 8, 650.00, '2024-02-15'),
(9, 9, 500.00, '2024-02-17'),
(10, 10, 720.00, '2024-02-19');

INSERT INTO Students (first_name, last_name, date_of_birth, email, phone_number) 
VALUES ('John', 'Doe', '1995-08-15', 'john.doe@example.com', '1234567890');

INSERT INTO Enrollments (student_id, course_id, enrollment_date) 
VALUES (1, 3, CURDATE());

UPDATE Teacher 
SET email = 'new.email@example.com' 
WHERE teacher_id = 2;

DELETE FROM Enrollments 
WHERE student_id = 1 AND course_id = 3;

UPDATE Courses 
SET teacher_id = 5 
WHERE course_id = 4;

DELETE FROM Students WHERE student_id = 1;

UPDATE Payments 
SET amount = 750.00 
WHERE payment_id = 3;

SELECT s.student_id, s.first_name, s.last_name, SUM(p.amount) AS total_payments
FROM Students s
JOIN Payments p ON s.student_id = p.student_id
WHERE s.student_id = 1
GROUP BY s.student_id, s.first_name, s.last_name;

SELECT c.course_id, c.course_name, COUNT(e.student_id) AS student_count
FROM Courses c
LEFT JOIN Enrollments e ON c.course_id = e.course_id
GROUP BY c.course_id, c.course_name;

SELECT s.student_id, s.first_name, s.last_name
FROM Students s
LEFT JOIN Enrollments e ON s.student_id = e.student_id
WHERE e.course_id IS NULL;

SELECT s.first_name, s.last_name, c.course_name
FROM Students s
JOIN Enrollments e ON s.student_id = e.student_id
JOIN Courses c ON e.course_id = c.course_id;

SELECT t.first_name, t.last_name, c.course_name
FROM Teacher t
JOIN Courses c ON t.teacher_id = c.teacher_id;

SELECT s.first_name, s.last_name, e.enrollment_date
FROM Students s
JOIN Enrollments e ON s.student_id = e.student_id
JOIN Courses c ON e.course_id = c.course_id
WHERE c.course_id = 2;

SELECT s.student_id, s.first_name, s.last_name
FROM Students s
LEFT JOIN Payments p ON s.student_id = p.student_id
WHERE p.payment_id IS NULL;

SELECT c.course_id, c.course_name
FROM Courses c
LEFT JOIN Enrollments e ON c.course_id = e.course_id
WHERE e.enrollment_id IS NULL;

SELECT s.student_id, s.first_name, s.last_name, COUNT(e.course_id) AS course_count
FROM Students s
JOIN Enrollments e ON s.student_id = e.student_id
GROUP BY s.student_id, s.first_name, s.last_name
HAVING COUNT(e.course_id) > 1;

SELECT t.teacher_id, t.first_name, t.last_name
FROM Teacher t
LEFT JOIN Courses c ON t.teacher_id = c.teacher_id
WHERE c.course_id IS NULL;

SELECT AVG(student_count) AS avg_students_per_course
FROM (
    SELECT course_id, COUNT(student_id) AS student_count
    FROM Enrollments
    GROUP BY course_id
) AS course_enrollments;

SELECT s.student_id, s.first_name, s.last_name, p.amount
FROM Students s
JOIN Payments p ON s.student_id = p.student_id
WHERE p.amount = (SELECT MAX(amount) FROM Payments);


SELECT c.course_id, c.course_name, COUNT(e.student_id) AS enrollment_count
FROM Courses c
JOIN Enrollments e ON c.course_id = e.course_id
GROUP BY c.course_id, c.course_name
HAVING COUNT(e.student_id) = (
    SELECT MAX(student_count)
    FROM (SELECT course_id, COUNT(student_id) AS student_count FROM Enrollments GROUP BY course_id) AS enroll_counts
);

SELECT t.teacher_id, t.first_name, t.last_name, 
       (SELECT SUM(p.amount) 
        FROM Payments p 
        JOIN Enrollments e ON p.student_id = e.student_id
        JOIN Courses c ON e.course_id = c.course_id
        WHERE c.teacher_id = t.teacher_id) AS total_payments
FROM Teacher t;

SELECT student_id, first_name, last_name
FROM Students
WHERE (SELECT COUNT(course_id) FROM Enrollments WHERE Students.student_id = Enrollments.student_id) = 
      (SELECT COUNT(course_id) FROM Courses);

SELECT teacher_id, first_name, last_name
FROM Teacher
WHERE teacher_id NOT IN (SELECT teacher_id FROM Courses);

SELECT AVG(YEAR(CURDATE()) - YEAR(date_of_birth)) AS avg_age
FROM Students;

SELECT course_id, course_name
FROM Courses
WHERE course_id NOT IN (SELECT DISTINCT course_id FROM Enrollments);

SELECT s.student_id, s.first_name, s.last_name, c.course_name, 
       (SELECT SUM(p.amount)
        FROM Payments p
        JOIN Enrollments e ON p.student_id = e.student_id
        WHERE e.course_id = c.course_id AND e.student_id = s.student_id) AS total_payments
FROM Students s
JOIN Enrollments e ON s.student_id = e.student_id
JOIN Courses c ON e.course_id = c.course_id;

SELECT student_id, first_name, last_name
FROM Students
WHERE student_id IN (
    SELECT student_id FROM Payments GROUP BY student_id HAVING COUNT(payment_id) > 1
);

SELECT s.student_id, s.first_name, s.last_name, SUM(p.amount) AS total_payments
FROM Students s
JOIN Payments p ON s.student_id = p.student_id
GROUP BY s.student_id, s.first_name, s.last_name;

SELECT c.course_id, c.course_name, COUNT(e.student_id) AS student_count
FROM Courses c
LEFT JOIN Enrollments e ON c.course_id = e.course_id
GROUP BY c.course_id, c.course_name;

SELECT s.student_id, s.first_name, s.last_name, AVG(p.amount) AS avg_payment
FROM Students s
JOIN Payments p ON s.student_id = p.student_id
GROUP BY s.student_id, s.first_name, s.last_name;
