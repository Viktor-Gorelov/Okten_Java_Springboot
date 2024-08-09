package com.example.Okten_Java_Springboot.services;

import com.example.Okten_Java_Springboot.dto.Car.CarDTO;
import com.example.Okten_Java_Springboot.dto.Car.CarUpdateDTO;
import com.example.Okten_Java_Springboot.entity.Car;
import com.example.Okten_Java_Springboot.mapper.CarMapper;
import com.example.Okten_Java_Springboot.repository.CarRepository;
import com.example.Okten_Java_Springboot.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private OwnerRepository ownerRepository;

    public List<CarDTO> getAllCars() {
        return carRepository
                .findAll()
                .stream().map(carMapper::mapToDTO)
                .toList();
    }

    public CarDTO createCar(CarDTO carDTO) {
        Car save = carRepository.save(carMapper.mapToCar(carDTO));
        return carMapper.mapToDTO(save);
    }

    public CarDTO getCarById(Long id) {
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("car with this id isn't present"));
        return carMapper.mapToDTO(car);
    }

    public CarDTO updateCar(Long id, CarUpdateDTO carUpdateDTO) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("car with this id isn't present"));
            car.setModel(carUpdateDTO.getModel());
            car.setEnginePower(carUpdateDTO.getEnginePower());
            car.setTorque(carUpdateDTO.getTorque());
            car.setFuelType(carUpdateDTO.getFuelType());
        Car savedCar = carRepository.save(car);
        return carMapper.mapToDTO(savedCar);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }
}
