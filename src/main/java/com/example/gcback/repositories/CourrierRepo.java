package com.example.gcback.repositories;

import com.example.gcback.entities.Courrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourrierRepo extends JpaRepository<Courrier, Long> {
}
