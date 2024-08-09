package com.example.Okten_Java_Springboot.dto.Owner;

import com.example.Okten_Java_Springboot.dto.Car.CarDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OwnerDTO {
    private Long id;
    private String username;
    private String email;

    private List<CarDTO> carDTOList;
}
