package com.example.Okten_Java_Springboot.validator;

import com.example.Okten_Java_Springboot.annotation.ValidFuelType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.Value;

import java.util.Arrays;
import java.util.List;

public class FuelTypeValidator implements ConstraintValidator<ValidFuelType, String> {
    private final List<String> validFuelTypesList;

    public FuelTypeValidator() {
        String[] validFuelTypes = new String[]{"Diesel", "Electric", "Hybrid"};
        this.validFuelTypesList = Arrays.asList(validFuelTypes);
    }

    @Override
    public boolean isValid(String fuelType, ConstraintValidatorContext context) {
        return fuelType != null && validFuelTypesList.contains(fuelType);
    }
}
