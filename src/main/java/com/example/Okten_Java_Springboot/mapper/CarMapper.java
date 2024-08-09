package com.example.Okten_Java_Springboot.mapper;

import com.example.Okten_Java_Springboot.dto.Car.CarDTO;
import com.example.Okten_Java_Springboot.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    @Autowired
    private OwnerMapper ownerMapper;

    public CarDTO mapToDTO(Car car){
        return CarDTO.builder()
                .id(car.getId())
                .model(car.getModel())
                .enginePower(car.getEnginePower())
                .torque(car.getTorque())
                .fuelType(car.getFuelType())
                .ownerDTO(ownerMapper.mapToDTO(car.getOwner()))
                .build();
    }

    public Car mapToCar(CarDTO carDTO){
        Car car = new Car();
        car.setModel(carDTO.getModel());
        car.setEnginePower(carDTO.getEnginePower());
        car.setTorque(carDTO.getTorque());
        car.setFuelType(carDTO.getFuelType());
        car.setOwner(ownerMapper.mapToOwner(carDTO.getOwnerDTO()));
        return car;
    }
}
