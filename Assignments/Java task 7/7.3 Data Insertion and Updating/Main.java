//Call the full data insertion code

package com.hexaware.sis.main;

import com.hexaware.sis.db.TestDataInserter;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Starting test data insertion...");
        TestDataInserter.insertTestData();
    }
}



// for testing 

package sis;

import com.hexaware.sis.dao.StudentDAO;

public class Main {
    public static void main(String[] args) {
        // Insert a new student
        StudentDAO.insertStudent("Karthik", 23);

        // Update an existing student
        StudentDAO.updateStudent(1, "Ram Kumar", 22);
    }
}
