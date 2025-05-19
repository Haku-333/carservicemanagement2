package com.carservicemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Make cannot be blank")
    @Size(max = 50, message = "Make cannot exceed 50 characters")
    @Column(nullable = false)
    private String make;
    
    @NotBlank(message = "Model cannot be blank")
    @Size(max = 50, message = "Model cannot exceed 50 characters")
    @Column(nullable = false)
    private String model;
    
    @NotBlank(message = "Year cannot be blank")
    @Pattern(regexp = "^\\d{4}$", message = "Year must be a 4-digit number")
    @Column(nullable = false)
    private String year;
    
    @NotBlank(message = "VIN cannot be blank")
    @Size(min = 17, max = 17, message = "VIN must be 17 characters") // Standard VIN length
    @Column(nullable = false, unique = true)
    private String vin;
    
    @NotBlank(message = "License plate cannot be blank")
    @Size(max = 20, message = "License plate cannot exceed 20 characters")
    @Column(nullable = false)
    private String licensePlate;
    
    @NotBlank(message = "Color cannot be blank")
    @Size(max = 30, message = "Color cannot exceed 30 characters")
    @Column(nullable = false)
    private String color;
    
    @NotNull(message = "Owner cannot be null")
    @ManyToOne(fetch = FetchType.LAZY) // LAZY is often a good default
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer owner;
    
    @NotNull(message = "Registration date cannot be null")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date registrationDate;
    
    public Vehicle() {
        this.registrationDate = new Date();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMake() {
        return make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getYear() {
        return year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public String getVin() {
        return vin;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public Customer getOwner() {
        return owner;
    }
    
    public void setOwner(Customer owner) {
        this.owner = owner;
    }
    
    public Date getRegistrationDate() {
        return registrationDate;
    }
    
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
