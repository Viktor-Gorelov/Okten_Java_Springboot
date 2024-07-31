package com.example.Okten_Java_Springboot.properties;

import lombok.Data;

import java.util.List;

@Data
public class Fuel {
    private String name;
    private List<String> types;
}
