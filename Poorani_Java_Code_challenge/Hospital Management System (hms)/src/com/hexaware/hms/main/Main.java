package com.hexaware.hms.main;

import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.dao.HospitalService;
import com.hexaware.hms.dao.HospitalServiceImplementation;
import com.hexaware.hms.exception.PatientNumberNotFoundException;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalService service = new HospitalServiceImplementation();
        int choice;

        do {
            System.out.println("\n HOSPITAL MANAGEMENT SYSTEM ");
            System.out.println("-----------------------------------");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. View Appointment by ID");
            System.out.println("3. View Appointments by Patient ID");
            System.out.println("4. View Appointments by Doctor ID");
            System.out.println("5. Update Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("0. Exit");
            System.out.println("------------------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Appointment ID: ");
                    int aId = sc.nextInt();
                    System.out.print("Enter Patient ID: ");
                    int pId = sc.nextInt();
                    System.out.print("Enter Doctor ID: ");
                    int dId = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Date (yyyy-mm-dd): ");
                    String date = sc.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();
                    Appointment newAppt = new Appointment(aId, pId, dId, date, desc);
                    if (service.scheduleAppointment(newAppt)) {
                        System.out.println(" Appointment Scheduled Successfully.");
                    } else {
                        System.out.println(" Failed to schedule appointment.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Appointment ID: ");
                    int aid = sc.nextInt();
                    Appointment appt = service.getAppointmentById(aid);
                    if (appt != null) {
                        System.out.println(appt);
                    } else {
                        System.out.println(" No appointment found with ID: " + aid);
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID: ");
                    int pid = sc.nextInt();
                    try {
                        List<Appointment> appointments = service.getAppointmentsForPatient(pid);
                        if (appointments.isEmpty()) {
                            throw new PatientNumberNotFoundException(" No appointments found for patient ID: " + pid);
                        }
                        appointments.forEach(System.out::println);
                    } catch (PatientNumberNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Doctor ID: ");
                    int did = sc.nextInt();
                    List<Appointment> docAppointments = service.getAppointmentsForDoctor(did);
                    if (docAppointments.isEmpty()) {
                        System.out.println(" No appointments found for doctor ID: " + did);
                    } else {
                        docAppointments.forEach(System.out::println);
                    }
                    break;

                case 5:
                    System.out.print("Enter Appointment ID to Update: ");
                    int upId = sc.nextInt();
                    System.out.print("Enter New Patient ID: ");
                    int nPid = sc.nextInt();
                    System.out.print("Enter New Doctor ID: ");
                    int nDid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Date: ");
                    String nDate = sc.nextLine();
                    System.out.print("Enter New Description: ");
                    String nDesc = sc.nextLine();
                    Appointment updateAppt = new Appointment(upId, nPid, nDid, nDate, nDesc);
                    if (service.updateAppointment(updateAppt)) {
                        System.out.println(" Appointment Updated Successfully.");
                    } else {
                        System.out.println(" Failed to update appointment.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Appointment ID to Cancel: ");
                    int cancelId = sc.nextInt();
                    if (service.cancelAppointment(cancelId)) {
                        System.out.println(" Appointment Canceled Successfully.");
                    } else {
                        System.out.println(" Failed to cancel appointment.");
                    }
                    break;

                case 0:
                    System.out.println("System exited!");
                    break;

                default:
                    System.out.println("❗ Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
