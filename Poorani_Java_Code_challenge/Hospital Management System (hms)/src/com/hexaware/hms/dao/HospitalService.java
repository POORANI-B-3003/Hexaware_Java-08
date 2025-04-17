package com.hexaware.hms.dao;

import com.hexaware.hms.entity.Appointment;
import java.util.List;

public interface HospitalService {

    Appointment getAppointmentById(int appointmentId);

    List<Appointment> getAppointmentsForPatient(int patientId);

    List<Appointment> getAppointmentsForDoctor(int doctorId);

    boolean scheduleAppointment(Appointment appointment);

    boolean updateAppointment(Appointment appointment);

    boolean cancelAppointment(int appointmentId);
}
