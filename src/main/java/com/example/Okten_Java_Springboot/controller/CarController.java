package com.example.Okten_Java_Springboot.controller;

import com.example.Okten_Java_Springboot.dto.CarDTO;
import com.example.Okten_Java_Springboot.dto.CarUpdateDTO;
import com.example.Okten_Java_Springboot.services.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @GetMapping()
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }
    @GetMapping("/{carId}")
    public ResponseEntity<CarDTO> getCar(@PathVariable Long carId) {
        return ResponseEntity.ok(carService.getCarById(carId));
    }

    @PostMapping()
    public ResponseEntity<CarDTO> createCar(@RequestBody @Valid CarDTO car){
        return ResponseEntity.ok(carService.createCar(car));
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
