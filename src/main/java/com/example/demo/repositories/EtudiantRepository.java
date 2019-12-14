package com.example.demo.repositories;

import com.example.demo.entities.Etudiant;
import org.springframework.data.repository.CrudRepository;

public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {
}
