package com.example.Okten_Java_Springboot.dto;

import com.example.Okten_Java_Springboot.annotation.ValidFuelType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarUpdateDTO {
    @NotBlank(message = "Model may not be blank")
    private String model;

    @Min(value = 0, message = "engine power min 0")
    @Min(value = 1_000_000, message = "engine power max 1000000")
    private int enginePower;
    private Integer torque;
    @ValidFuelType
    private String fuelType;
}
