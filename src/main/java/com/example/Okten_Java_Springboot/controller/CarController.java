package com.example.Okten_Java_Springboot.controller;

import com.example.Okten_Java_Springboot.entity.Car;
import com.example.Okten_Java_Springboot.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(@RequestParam(required = false) Integer minEnginePower,
                                                @RequestParam(required = false) Integer maxEnginePower){
        if (minEnginePower != null && maxEnginePower != null) {
            return ResponseEntity.ok(carRepository.findByEnginePowerBetween(minEnginePower, maxEnginePower));
        }
        return ResponseEntity.ok(carRepository.findAll());
    }
    @GetMapping("/cars/{carId}")
    public ResponseEntity<Car> getCar(@PathVariable Long carId) {
        return ResponseEntity.of(carRepository.findById(carId));
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        return ResponseEntity.ok(carRepository.save(car));
    }

    @PutMapping("/cars/{carId}")
    public ResponseEntity<Car> updateCar(@PathVariable Long carId, @RequestBody Car carUpdateWith){
        return  ResponseEntity.of(carRepository
                .findById(carId)
                .map(existingCar ->{
                    existingCar.setModel(carUpdateWith.getModel());
                    existingCar.setEnginePower(carUpdateWith.getEnginePower());
                    return carRepository.save(existingCar);
                }));

    }
    @DeleteMapping("/cars/{carId}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long carId){
        carRepository.deleteById(carId);
        return ResponseEntity.noContent().build();
    }
}
