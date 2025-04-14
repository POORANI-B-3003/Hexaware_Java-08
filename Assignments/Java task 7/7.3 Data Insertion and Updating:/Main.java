package sis;

import com.hexaware.sis.db.TestDataInserter;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Starting test data insertion...");
        TestDataInserter.insertTestData();
    }
}
