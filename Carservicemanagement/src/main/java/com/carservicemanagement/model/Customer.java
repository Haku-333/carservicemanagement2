package com.carservicemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Column(nullable = false)
    private String firstName;
    
    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Column(nullable = false)
    private String lastName;
    
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please provide a valid email address")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    @Column(nullable = false, unique = true)
    private String email;
    
    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Please provide a valid phone number")
    @Column(nullable = false)
    private String phone;
    
    @NotBlank(message = "Address cannot be blank")
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    @Column(nullable = false)
    private String address;
    
    @NotNull(message = "Registration date cannot be null")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date registrationDate;
    
    @NotBlank(message = "Password cannot be blank")
    // Password length validation should apply to the raw password before hashing.
    // The hashed password will be longer.
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters") // Adjust max if storing raw temporarily before hashing
    @Column(nullable = false)
    private String password;
    
    public Customer() {
        this.registrationDate = new Date();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public Date getRegistrationDate() {
        return registrationDate;
    }
    
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
