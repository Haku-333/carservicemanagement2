package com.carservicemanagement.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;
    
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;
    
    @Column(nullable = false)
    private String diagnosis;
    
    @Column(nullable = false)
    private String recommendations;
    
    @Column(nullable = false)
    private Double totalCost;
    
    @Column(nullable = false)
    private String status;
    
    @Column(nullable = false)
    private Date createdDate;
    
    public Report() {
        this.createdDate = new Date();
        this.status = "PENDING";
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Appointment getAppointment() {
        return appointment;
    }
    
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
    public Service getService() {
        return service;
    }
    
    public void setService(Service service) {
        this.service = service;
    }
    
    public String getDiagnosis() {
        return diagnosis;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public String getRecommendations() {
        return recommendations;
    }
    
    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }
    
    public Double getTotalCost() {
        return totalCost;
    }
    
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
