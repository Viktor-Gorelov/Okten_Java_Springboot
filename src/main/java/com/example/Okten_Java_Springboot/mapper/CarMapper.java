package com.example.Okten_Java_Springboot.mapper;

import com.example.Okten_Java_Springboot.dto.CarDTO;
import com.example.Okten_Java_Springboot.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public CarDTO mapToDTO(Car car){
        return CarDTO.builder()
                .id(car.getId())
                .model(car.getModel())
                .enginePower(car.getEnginePower())
                .torque(car.getTorque())
                .fuelType(car.getFuelType())
                .build();
    }

    public Car mapToCar(CarDTO carDTO){
        Car car = new Car();
        car.setModel(carDTO.getModel());
        car.setEnginePower(carDTO.getEnginePower());
        car.setTorque(carDTO.getTorque());
        car.setFuelType(carDTO.getFuelType());
        return car;
    }
}
