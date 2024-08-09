package com.example.Okten_Java_Springboot.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class OwnerUpdateDTO {
    private String username;
    private String email;
}
