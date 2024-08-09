package com.example.Okten_Java_Springboot.controller;

import com.example.Okten_Java_Springboot.dto.Owner.OwnerDTO;
import com.example.Okten_Java_Springboot.dto.Owner.OwnerUpdateDTO;
import com.example.Okten_Java_Springboot.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> getAllOwners() {
        return ResponseEntity.ok(ownerService.getAllOwners());
    }

    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO) {
        return ResponseEntity.ok(ownerService.createOwner(ownerDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Long id) {
        return ResponseEntity.ok(ownerService.getOwnerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDTO> updateOwner(@PathVariable Long id, @RequestBody OwnerUpdateDTO ownerUpdateDTO) {
        return ResponseEntity.ok(ownerService.updateOwner(id,ownerUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwnerById(id);
        return ResponseEntity.noContent().build();

    }
}
