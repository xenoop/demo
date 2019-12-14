package com.example.demo.service;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Professeur;
import com.example.demo.repositories.MatiereRepository;
import com.example.demo.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMatiere {
    @Autowired
    ProfesseurRepository pr;
    @Autowired
    MatiereRepository mr;
    public Iterable<Matiere> findall(){
        return mr.findAll();
    }
    public Matiere findId(long id){
        return mr.findById(id).get();

    }
    public Matiere add(String nom, String desc, Long id){
        Professeur prof = pr.findById(id).get();
        Matiere mat =new Matiere(nom,desc);
        prof.getMatiere().add(mat);
        mat.setProf(prof);
        mr.save(mat);
        pr.save(prof);
        return mat;
    }
    public String delete(long id){
        Matiere mat=mr.findById(id).get();
        if (mat.getEtud().isEmpty()){
            mr.delete(mat);
            return "success";
        }
        else {
            return "error";
        }
    }
    public Matiere addprof(long idprof,long idmat){
        Professeur prof =pr.findById(idprof).get();
        Matiere mat = mr.findById(idmat).get();
        prof.getMatiere().add(mat);
        mat.setProf(prof);
        return mat;
    }
    public Matiere save(Matiere mat, Long id){
        Professeur prof = pr.findById(id).get();
        mat.setProf(prof);
        prof.getMatiere().add(mat);
        pr.save(prof);
        mr.save(mat);
        return mat;
    }
    public Matiere update(long id,String nom,String description){
        Matiere matiere = new Matiere();
        Matiere mat = mr.findById(id).get();
        matiere.setId(id);
        matiere.setProf(mat.getProf());
        matiere.setEtud(mat.getEtud());
        mr.delete(mat);
        mr.save(matiere);
        return matiere;
    }
    public Iterable<Etudiant> getetud(long id){
        Matiere mat = mr.findById(id).get();
        return mat.getEtud();

    }
}
