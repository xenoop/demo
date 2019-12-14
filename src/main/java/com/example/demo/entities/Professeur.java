package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Professeur {
    @Id
    private long Id;
    @Column(name="nom",length=40,nullable=false)
    private String nom;
    @Column(name="prenom",length=40,nullable=false)
    private String prenom;
    @JsonIgnore
    @OneToMany
    private List<Matiere> matiere;

    public Professeur() {
    }

    public Professeur(String nom, String prenom) {
        this.nom=nom;
        this.prenom=prenom;
    }

    public Long getID() {
        return Id;
    }

    public void setID(long ID) {
        this.Id = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Matiere> getMatiere() {
        return  matiere;
    }

    public void setMatiere( List<Matiere> matiere) {
        this.matiere =  matiere;
    }
}
