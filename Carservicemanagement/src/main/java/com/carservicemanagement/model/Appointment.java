package com.carservicemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Customer cannot be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @NotNull(message = "Vehicle cannot be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
    
    @NotNull(message = "Appointment date cannot be null")
    @FutureOrPresent(message = "Appointment date must be in the present or future")
    @Temporal(TemporalType.TIMESTAMP) // For date and time
    @Column(nullable = false)
    private Date appointmentDate;
    
    @NotBlank(message = "Time slot cannot be blank")
    @Size(max = 50, message = "Time slot cannot exceed 50 characters")
    @Column(nullable = false)
    private String timeSlot;
    
    @NotBlank(message = "Status cannot be blank")
    @Size(max = 30, message = "Status cannot exceed 30 characters")
    @Column(nullable = false)
    private String status; // e.g., SCHEDULED, COMPLETED, CANCELLED
    
    @NotBlank(message = "Description/Service requested cannot be blank")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @NotNull(message = "Creation date cannot be null")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdDate;
    
    public Appointment() {
        this.createdDate = new Date();
        this.status = "SCHEDULED"; // Default status
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Vehicle getVehicle() {
        return vehicle;
    }
    
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
    public String getTimeSlot() {
        return timeSlot;
    }
    
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
