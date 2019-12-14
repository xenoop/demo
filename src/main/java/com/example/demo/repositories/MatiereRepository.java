package com.example.demo.repositories;

import com.example.demo.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    Matiere findByDescription(String description);
}
