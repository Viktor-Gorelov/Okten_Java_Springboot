package com.example.Okten_Java_Springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int enginePower;
    private Integer torque;
    private String fuelType;
    private LocalDateTime lastMaintenanceTimestamp;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
