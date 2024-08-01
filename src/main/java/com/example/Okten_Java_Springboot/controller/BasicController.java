package com.example.Okten_Java_Springboot.controller;

import com.example.Okten_Java_Springboot.properties.Fuel;
import com.example.Okten_Java_Springboot.properties.ReferenceData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class BasicController {
    @Value("${reference-data.engineTypes}")
    private List<String> engines;

    private final ReferenceData referenceData;

    @GetMapping("/engine-types")
    public ResponseEntity<List<String>> getEngineTypes(){
        return ResponseEntity.ok(engines);
    }

    @GetMapping("/fuel-types")
    public ResponseEntity<List<Fuel>> getFuelTypes(){
        return ResponseEntity.ok(referenceData.getFuels());
    }

    @GetMapping("/fuel-types/{name}")
    public ResponseEntity<Fuel> getFuelType(@PathVariable String name){
        Optional<Fuel> result = Optional
                .ofNullable(referenceData)
                .map(ReferenceData::getFuels)
                .stream()
                .flatMap(java.util.Collection::stream)
                .filter(fuel -> Objects.equals(fuel.getName(), name))
                .findFirst();
        return ResponseEntity.of(result);
    }
}