package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nom",length=40,nullable=false)
    private String nom;
    @Column(name= "prenom",length=40,nullable=false)
    private String prenom;
    @JsonIgnore
    @ManyToMany
    private List<Matiere> cours;
    @Column(name= "matricule",length=40,nullable=false)
    private long matricule;

    public Etudiant(String nom, String prenom, long matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule=matricule;
    }

    public long getMatricule() {
        return matricule;
    }

    public void setMatricule(long matricule) {
        this.matricule = matricule;
    }

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.cours = new ArrayList<Matiere>();
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

    public List<Matiere> getCours() {
        return cours;
    }

    public void setCours(List<Matiere> cours) {
        this.cours = cours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etudiant() {
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\''
                ;
    }
}
