package com.carservicemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Service name cannot be blank")
    @Size(max = 100, message = "Service name cannot exceed 100 characters")
    @Column(nullable = false)
    private String name;
    
    @NotBlank(message = "Description cannot be blank")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @Column(nullable = false)
    private String description;
    
    @NotNull(message = "Price cannot be null")
    @PositiveOrZero(message = "Price must be zero or positive")
    @Column(nullable = false)
    private Double price;
    
    @NotNull(message = "Duration cannot be null")
    @Positive(message = "Duration must be positive")
    @Column(nullable = false)
    private Integer durationInMinutes;
    
    @NotBlank(message = "Category cannot be blank")
    @Size(max = 50, message = "Category cannot exceed 50 characters")
    @Column(nullable = false)
    private String category;
    
    @NotNull(message = "Active status cannot be null")
    @Column(nullable = false)
    private Boolean isActive;
    
    @NotNull(message = "Created date cannot be null")
    @Temporal(TemporalType.TIMESTAMP) 
    @Column(nullable = false)
    private Date createdDate;
    
    public Service() {
        this.createdDate = new Date();
        this.isActive = true;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }
    
    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public Boolean getActive() {
        return isActive;
    }
    
    public void setActive(Boolean active) {
        isActive = active;
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
