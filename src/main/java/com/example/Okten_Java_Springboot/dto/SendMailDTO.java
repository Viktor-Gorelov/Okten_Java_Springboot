package com.example.Okten_Java_Springboot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendMailDTO {
    private String subject;
    private String text;
    private String recipient;
}
