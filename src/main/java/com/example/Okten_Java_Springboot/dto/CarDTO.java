package com.example.Okten_Java_Springboot.dto;

import com.example.Okten_Java_Springboot.annotation.ValidFuelType;
import com.example.Okten_Java_Springboot.entity.Owner;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CarDTO {
    private Long id;
    @NotBlank(message = "Model may not be blank")
    private String model;

    @Min(value = 0, message = "engine power min 0")
    @Max(value = 1_000_000, message = "engine power max 1000000")
    private int enginePower;
    private Integer torque;
    @ValidFuelType
    private String fuelType;

    private LocalDateTime lastMaintenanceTimestamp; // Нове поле

    private OwnerDTO ownerDTO;
}
