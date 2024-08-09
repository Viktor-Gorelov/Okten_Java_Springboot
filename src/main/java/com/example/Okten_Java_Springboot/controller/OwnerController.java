package com.example.Okten_Java_Springboot.controller;

import com.example.Okten_Java_Springboot.entity.Owner;
import com.example.Okten_Java_Springboot.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok(ownerRepository.save(owner));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        return ResponseEntity.of(ownerRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        return ownerRepository.findById(id)
                .map(owner -> {
                    owner.setUsername(ownerDetails.getUsername());
                    owner.setEmail(ownerDetails.getEmail());
                    return ResponseEntity.ok(ownerRepository.save(owner));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOwner(@PathVariable Long id) {
        return ownerRepository.findById(id)
                .map(owner -> {
                    if (owner.getCars().isEmpty()) {
                        ownerRepository.delete(owner);
                        return ResponseEntity.noContent().build();
                    } else {
                        return ResponseEntity.status(400).build();
                    }
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
