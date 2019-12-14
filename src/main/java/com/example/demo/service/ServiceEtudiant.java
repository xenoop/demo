package com.example.demo.service;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Matiere;
import com.example.demo.repositories.EtudiantRepository;
import com.example.demo.repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEtudiant {
    @Autowired
    EtudiantRepository er;
    @Autowired
    MatiereRepository mr;
    public  Iterable<Etudiant> find(){
        return er.findAll();
    }
    public Etudiant create(String nom, String prenom, long matricule){
        Etudiant e = new Etudiant(nom,prenom,matricule);
        er.save(e);
        return e;
    }
    public Etudiant update(long id, String nom, String prenom, long matricule){
        Etudiant etud =er.findById(id).get();
        Etudiant et = new Etudiant(nom,prenom,matricule);
        et.setId(id);
        et.setCours(etud.getCours());
        er.save(et);
        er.delete(etud);
        return et;
    }
    public Etudiant delete(long id){
        Etudiant et = er.findById(id).get();
        er.delete(et);
        return et;
    }
    public Etudiant cour(long idet,long idmat){
        Matiere mat = mr.findById(idmat).get(); //mr MatiereRepository
        Etudiant et = er.findById(idet).get();//er EtudiantRepository
        et.getCours().add(mat);
        mat.getEtud().add(et);
        er.save(et);
        mr.save(mat);
        return et;
    }
    public Iterable<Matiere> cours (Long id){
        Etudiant etud = er.findById(id).get();
        return etud.getCours();
    }
}
