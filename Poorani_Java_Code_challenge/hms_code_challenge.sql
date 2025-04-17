CREATE DATABASE hms;
USE hms;

CREATE TABLE IF NOT EXISTS patients (
    patientId INT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    dateOfBirth DATE,
    gender VARCHAR(10),
    contactNumber VARCHAR(20),
    address VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS doctors (
    doctorId INT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    specialization VARCHAR(100),
    contactNumber VARCHAR(20)
);


CREATE TABLE IF NOT EXISTS appointments (
    appointmentId INT PRIMARY KEY,
    patientId INT,
    doctorId INT,
    appointmentDate DATE,
    description VARCHAR(255),
    FOREIGN KEY (patientId) REFERENCES patients(patientId),
    FOREIGN KEY (doctorId) REFERENCES doctors(doctorId)
);


INSERT INTO patients (patientId, firstName, lastName, dateOfBirth, gender, contactNumber, address)
VALUES
    (1, 'Naveen', 'Varma', '1991-08-11', 'Male', '9091929394', '12 Lotus Park, Bangalore'),
    (2, 'Keerthi', 'Iyer', '1989-09-30', 'Female', '9192939495', '45 Marina Bay, Hyderabad'),
    (3, 'Abdul', 'Rahman', '1994-02-17', 'Male', '9293949596', '87 Pearl Street, Pune'),
    (4, 'Sneha', 'Kapoor', '1990-12-03', 'Female', '9876543211', '36 Sunrise Apt, Delhi'),
    (5, 'Rohan', 'Bhatia', '1987-06-18', 'Male', '9988776655', '78 Garden View, Chennai');


INSERT INTO doctors (doctorId, firstName, lastName, specialization, contactNumber)
VALUES
    (101, 'Meera', 'Desai', 'Oncologist', '9290909290'),
    (102, 'Arun', 'Menon', 'Ophthalmologist', '9383838383'),
    (103, 'Farah', 'Shaikh', 'Psychiatrist', '9484848484'),
    (104, 'Karan', 'Gill', 'Urologist', '9575757575'),
    (105, 'Divya', 'Pillai', 'Gynecologist', '9666666666');


INSERT INTO appointments (appointmentId, patientId, doctorId, appointmentDate, description)
VALUES
    (1001, 1, 101, '2025-04-21', 'Cancer treatment consultation'),
    (1002, 2, 102, '2025-04-26', 'Vision checkup'),
    (1003, 3, 103, '2025-04-23', 'Depression evaluation'),
    (1004, 1, 102, '2025-05-02', 'Eye allergy follow-up'),
    (1005, 4, 104, '2025-05-05', 'Kidney function test'),
    (1006, 5, 105, '2025-05-08', 'Prenatal check-up'),
    (1007, 3, 101, '2025-05-10', 'Follow-up cancer treatment');
