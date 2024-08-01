package com.example.Okten_Java_Springboot.repository;

import com.example.Okten_Java_Springboot.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByEnginePowerBetween(int minEnginePower, int maxEnginePower);
}
