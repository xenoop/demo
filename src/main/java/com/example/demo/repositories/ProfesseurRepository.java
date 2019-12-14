package com.example.demo.repositories;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
}
