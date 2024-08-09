package com.example.Okten_Java_Springboot.mapper;

import com.example.Okten_Java_Springboot.dto.Owner.OwnerDTO;
import com.example.Okten_Java_Springboot.entity.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {
    public OwnerDTO mapToDTO(Owner owner){
        return OwnerDTO.builder()
                .id(owner.getId())
                .username(owner.getUsername())
                .email(owner.getEmail())
                .build();
    }

    public Owner mapToOwner(OwnerDTO ownerDTO){
        Owner owner = new Owner();
        owner.setId(ownerDTO.getId());
        owner.setUsername(ownerDTO.getUsername());
        owner.setEmail(ownerDTO.getEmail());
        return owner;
    }
}
