package sis;

import com.hexaware.sis.db.TransactionManager;

public class Main {
    public static void main(String[] args) {
        // Try enrolling student 1 in course 101 and pay ₹2500
        TransactionManager.enrollStudentAndMakePayment(
            1,       // student_id
            101,     // course_id
            9001,    // enrollment_id
            8001,    // payment_id
            2500.00, // amount
            "2025-04-15" // payment_date
        );
    }
}
