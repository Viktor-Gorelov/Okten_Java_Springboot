package com.example.Okten_Java_Springboot.repository;

import com.example.Okten_Java_Springboot.entity.Maintenance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MaintenanceRepository extends MongoRepository<Maintenance, String> {
}
