package com.example.Okten_Java_Springboot.controller;

import com.example.Okten_Java_Springboot.dto.Car.CarCreateDTO;
import com.example.Okten_Java_Springboot.dto.Car.CarDTO;
import com.example.Okten_Java_Springboot.dto.Car.CarUpdateDTO;
import com.example.Okten_Java_Springboot.dto.Owner.OwnerDTO;
import com.example.Okten_Java_Springboot.services.CarService;
import com.example.Okten_Java_Springboot.services.OwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final OwnerService ownerService;

    @GetMapping()
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }
    @GetMapping("/{carId}")
    public ResponseEntity<CarDTO> getCar(@PathVariable Long carId) {
        return ResponseEntity.ok(carService.getCarById(carId));
    }

    @PostMapping()
    public ResponseEntity<CarDTO> createCar(@RequestBody @Valid CarCreateDTO car) {
        CarDTO carDTO = CarDTO.builder()
                .model(car.getModel())
                .enginePower(car.getEnginePower())
                .torque(car.getTorque())
                .fuelType(car.getFuelType())
                .build();
        String username = car.getOwnerName();
        OwnerDTO owner = ownerService.getOwnerByName(username);
        if (owner == null) {
            return ResponseEntity.status(400).body(null);
        }
        carDTO.setOwnerDTO(owner);
        carDTO.setLastMaintenanceTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(carService.createCar(carDTO));
    }

    @PutMapping("/{carId}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long carId, @RequestBody CarUpdateDTO carUpdateDTO){
        return ResponseEntity.ok(carService.updateCar(carId, carUpdateDTO));

    }
    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId){
        carService.deleteCarById(carId);
        return ResponseEntity.noContent().build();
    }
}
