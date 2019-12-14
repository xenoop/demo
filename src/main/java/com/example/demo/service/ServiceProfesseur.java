package com.example.demo.service;

import com.example.demo.entities.Matiere;
import com.example.demo.entities.Professeur;
import com.example.demo.repositories.MatiereRepository;
import com.example.demo.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
public class ServiceProfesseur {
    @Autowired
    ProfesseurRepository pr;
    @Autowired
    MatiereRepository mr;
    public Iterable<Professeur> findall() {
        return pr.findAll();
    }

    public Professeur findbyid(long id) {
        return pr.findById(id).get();
    }

    public String delete(long id) {
        pr.deleteById(id);
        return "success";
    }
    public Professeur add(String nom,String prenom){
        Professeur prof;
        pr.save(prof =new Professeur(nom,prenom));
        return prof;
    }
    public String addMatiere(long idprof,long idmat){
        Professeur prof =pr.findById(idprof).get();
        Matiere mat =mr.findById(idmat).get();
        if (mat.getProf()==null){
            mat.setProf(prof);
            prof.getMatiere().add(mat);
            pr.save(prof);
            mr.save(mat);
            return"success";
        }
        else return "error";
    }
    public Professeur update(long id,String nom,String prenom){
        Professeur prof = pr.findById(id).get();
        Professeur newprof = new Professeur();
        newprof.setID(id);
        newprof.setNom(nom);
        newprof.setPrenom(prenom);
        newprof.setMatiere(prof.getMatiere());
        pr.delete(prof);
        pr.save(newprof);
        return newprof;

    }
    public Iterable<Matiere> Getmatiere(long id){
        Professeur prof = pr.findById(id).get();
        return prof.getMatiere();
    }
    public Professeur supmatiere(long idprof,long idmat){
        Professeur prof =pr.findById(idprof).get();
        Matiere mat =mr.findById(idmat).get();
        prof.getMatiere().remove(mat);
        return prof;
    }
}
