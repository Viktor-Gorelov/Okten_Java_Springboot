package com.example.Okten_Java_Springboot.repository;

import com.example.Okten_Java_Springboot.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByUsername(String username);
}
