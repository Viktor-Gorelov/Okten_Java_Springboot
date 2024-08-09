package com.example.Okten_Java_Springboot.services;

import com.example.Okten_Java_Springboot.entity.Owner;
import com.example.Okten_Java_Springboot.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceReminderService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private MailService mailService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void sendMaintenanceReminders() {
        List<Owner> owners = ownerRepository.findAll();
        mailService.sendMaintenanceReminderEmail(owners);
    }
}
