package com.example.Okten_Java_Springboot.annotation;

import com.example.Okten_Java_Springboot.validator.FuelTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FuelTypeValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFuelType {
    String message() default "Invalid fuel type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
