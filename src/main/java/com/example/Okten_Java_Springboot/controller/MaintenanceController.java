package com.example.Okten_Java_Springboot.controller;

import com.example.Okten_Java_Springboot.dto.SendMailDTO;
import com.example.Okten_Java_Springboot.entity.Maintenance;
import com.example.Okten_Java_Springboot.entity.Owner;
import com.example.Okten_Java_Springboot.repository.MaintenanceRepository;
import com.example.Okten_Java_Springboot.repository.OwnerRepository;
import com.example.Okten_Java_Springboot.services.MailService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/maintenances")
public class MaintenanceController {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    private final MailService mailService;

    @GetMapping
    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    @PostMapping
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance) {
        Maintenance savedMaintenance = maintenanceRepository.save(maintenance);
        List<Owner> owners = ownerRepository.findAll();
        mailService.sendMaintenanceEmailToOwners(maintenance.getDescription(), owners);
        return savedMaintenance;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getMaintenanceById(@PathVariable ObjectId id) {
        return ResponseEntity.of(maintenanceRepository.findById(String.valueOf(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable ObjectId id, @RequestBody Maintenance maintenanceDetails) {
        return maintenanceRepository.findById(String.valueOf(id))
                .map(maintenance -> {
                    maintenance.setName(maintenanceDetails.getName());
                    maintenance.setDescription(maintenanceDetails.getDescription());
                    maintenance.setPrice(maintenanceDetails.getPrice());
                    return ResponseEntity.ok(maintenanceRepository.save(maintenance));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable ObjectId id) {
        maintenanceRepository.deleteById(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
