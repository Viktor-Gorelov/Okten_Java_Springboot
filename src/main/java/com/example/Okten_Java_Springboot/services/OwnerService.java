package com.example.Okten_Java_Springboot.services;

import com.example.Okten_Java_Springboot.dto.Owner.OwnerDTO;
import com.example.Okten_Java_Springboot.dto.Owner.OwnerUpdateDTO;
import com.example.Okten_Java_Springboot.entity.Owner;
import com.example.Okten_Java_Springboot.mapper.OwnerMapper;
import com.example.Okten_Java_Springboot.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public List<OwnerDTO> getAllOwners(){
        return ownerRepository
                .findAll()
                .stream().map(ownerMapper::mapToDTO)
                .toList();
    }

    public OwnerDTO createOwner(OwnerDTO ownerDTO){
        Owner save = ownerRepository.save(ownerMapper.mapToOwner(ownerDTO));
        return ownerMapper.mapToDTO(save);
    }

    public OwnerDTO getOwnerById(Long id){
        Owner owner = ownerRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("owner with this id isn't present"));
        return ownerMapper.mapToDTO(owner);
    }
    public OwnerDTO getOwnerByName(String name){
        Owner owner = ownerRepository.findByUsername(name);
        return ownerMapper.mapToDTO(owner);
    }


    public OwnerDTO updateOwner(Long id, OwnerUpdateDTO ownerUpdateDTO){
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("owner with this id isn't present"));
        owner.setUsername(ownerUpdateDTO.getUsername());
        owner.setEmail(ownerUpdateDTO.getEmail());
        Owner savedOwner = ownerRepository.save(owner);
        return ownerMapper.mapToDTO(savedOwner);
    }

    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }
}
