package com.albasha.springrestapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
    //change the name of the field in the response
    //@JsonProperty("Full Name")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    //ignore this field in the response
    //@JsonIgnore
    private Long age = 0L;

    private String location;
    @Email(message = "please enter a valid email address")
    private String email;

    @NotNull(message = "Department cannot be null")
    @NotBlank(message = "Department cannot be blank")
    @NotEmpty(message = "Department cannot be empty")
    private String department;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false ,updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}