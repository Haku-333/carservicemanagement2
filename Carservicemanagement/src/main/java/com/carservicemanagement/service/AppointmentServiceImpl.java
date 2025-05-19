package com.carservicemanagement.service;

import com.carservicemanagement.model.Appointment;
import java.util.List; // Optional: for future methods like getAllAppointments

public interface AppointmentServiceImpl {

    /**
     * Saves a new appointment or updates an existing one.
     * @param appointment The appointment object to save.
     */
    void saveAppointment(Appointment appointment);

    // You can add more methods here as needed, for example:
    // List<Appointment> getAllAppointments();
    // Appointment getAppointmentById(Long id); // Assuming id is Long
    // void deleteAppointment(Long id);

}