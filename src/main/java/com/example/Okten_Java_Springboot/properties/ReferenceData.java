package com.example.Okten_Java_Springboot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "reference-data")
public class ReferenceData {
    private List<Fuel> fuels;
}
