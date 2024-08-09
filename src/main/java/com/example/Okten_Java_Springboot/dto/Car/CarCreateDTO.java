package com.example.Okten_Java_Springboot.dto.Car;

import com.example.Okten_Java_Springboot.annotation.ValidFuelType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CarCreateDTO {
    @NotBlank(message = "Model may not be blank")
    private String model;

    @Min(value = 0, message = "engine power min 0")
    @Max(value = 1_000_000, message = "engine power max 1000000")
    private int enginePower;
    private Integer torque;
    @ValidFuelType
    private String fuelType;
    @NotNull(message = "Owner name may not be empty")
    private String ownerName;
}
