package com.hexaware.hms.dao;

import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.util.DBConnectUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalServiceImplementation implements HospitalService {

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        Appointment appointment = null;
        String query = "SELECT * FROM appointments WHERE appointmentId = ?";

        try (Connection conn = DBConnectUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, appointmentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    appointment = new Appointment(
                            rs.getInt("appointmentId"),
                            rs.getInt("patientId"),
                            rs.getInt("doctorId"),
                            rs.getString("appointmentDate"),
                            rs.getString("description")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAppointmentsForPatient(int patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments WHERE patientId = ?";

        try (Connection conn = DBConnectUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, patientId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    appointments.add(new Appointment(
                            rs.getInt("appointmentId"),
                            rs.getInt("patientId"),
                            rs.getInt("doctorId"),
                            rs.getString("appointmentDate"),
                            rs.getString("description")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public List<Appointment> getAppointmentsForDoctor(int doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments WHERE doctorId = ?";

        try (Connection conn = DBConnectUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, doctorId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    appointments.add(new Appointment(
                            rs.getInt("appointmentId"),
                            rs.getInt("patientId"),
                            rs.getInt("doctorId"),
                            rs.getString("appointmentDate"),
                            rs.getString("description")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public boolean scheduleAppointment(Appointment appointment) {
        String query = "INSERT INTO appointments (appointmentId, patientId, doctorId, appointmentDate, description) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnectUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, appointment.getAppointmentId());
            stmt.setInt(2, appointment.getPatientId());
            stmt.setInt(3, appointment.getDoctorId());
            stmt.setString(4, appointment.getAppointmentDate());
            stmt.setString(5, appointment.getDescription());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {
        String query = "UPDATE appointments SET patientId = ?, doctorId = ?, appointmentDate = ?, description = ? WHERE appointmentId = ?";

        try (Connection conn = DBConnectUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, appointment.getPatientId());
            stmt.setInt(2, appointment.getDoctorId());
            stmt.setString(3, appointment.getAppointmentDate());
            stmt.setString(4, appointment.getDescription());
            stmt.setInt(5, appointment.getAppointmentId());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean cancelAppointment(int appointmentId) {
        String query = "DELETE FROM appointments WHERE appointmentId = ?";

        try (Connection conn = DBConnectUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, appointmentId);
            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
