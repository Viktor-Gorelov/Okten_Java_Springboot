package com.example.Okten_Java_Springboot.services;

import com.example.Okten_Java_Springboot.dto.SendMailDTO;
import com.example.Okten_Java_Springboot.entity.Car;
import com.example.Okten_Java_Springboot.entity.Owner;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailSender mailSender;

    @Value("${mail.sender.username}")
    private String mailSendersUsername;

    public void sendMaintenanceEmailToOwners(String maintenanceDescription, List<Owner> owners) {
        for (Owner owner : owners) {
            sendMail(SendMailDTO.builder()
                    .recipient(owner.getEmail())
                    .subject("New Maintenance Added")
                    .text("Maintenance description: " + maintenanceDescription)
                    .build());
        }
    }

    public void sendMaintenanceReminderEmail(List<Owner> owners) {
    for (Owner owner : owners) {
        StringBuilder message = new StringBuilder("The following cars need maintenance:\n\n");
        boolean hasCarsNeedingMaintenance = false;

        for (Car car : owner.getCars()) {
            if (car.getLastMaintenanceTimestamp() != null &&
                car.getLastMaintenanceTimestamp().isBefore(LocalDateTime.now().minusYears(1))) {
                message.append("Car: ").append(car.getModel())
                       .append(", Last Maintenance: ").append(car.getLastMaintenanceTimestamp())
                       .append("\n");
                hasCarsNeedingMaintenance = true;
            }
        }

        if (hasCarsNeedingMaintenance) {
            sendMail(SendMailDTO.builder()
                    .recipient(owner.getEmail())
                    .subject("Maintenance Reminder")
                    .text(message.toString())
                    .build());
        }
    }
}
    public void sendMail(SendMailDTO mailDTO){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailSendersUsername);
        mailMessage.setTo(mailDTO.getRecipient());
        mailMessage.setSubject(mailDTO.getSubject());
        mailMessage.setText(mailDTO.getText());
        mailSender.send(mailMessage);
    }


}
