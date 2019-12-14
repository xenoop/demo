package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Matiere  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nom",length=40,nullable=false)
    private String nom;
    @Column(name="description",length=400,nullable = false)
    private String description;

    @ManyToMany
    private List<Etudiant> etud;

    @ManyToOne
    private Professeur prof;

    public Matiere(Long id) {
        this.id = id;
    }
    public Matiere(String nom, String desc){
        this.nom=nom;
        this.description=desc;
    }
    public Matiere() {
    }

    public Matiere(String nom) {
        this.nom=nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Etudiant> getEtud() {
        return etud;
    }

    public Professeur getProf() {
        return prof;
    }

    public void setProf(Professeur prof) {
        this.prof = prof;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtud(List<Etudiant> etud) {
        this.etud = etud;
    }
}
