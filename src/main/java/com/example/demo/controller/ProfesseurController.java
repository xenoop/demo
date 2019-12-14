package com.example.demo.controller;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Professeur;
import com.example.demo.repositories.EtudiantRepository;
import com.example.demo.repositories.ProfesseurRepository;
import com.example.demo.service.ServiceProfesseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProfesseurController {
        @Autowired
        ProfesseurRepository pr;
        @Autowired
        ServiceProfesseur sr;
        @ResponseBody
        @RequestMapping("/prof")
        public Iterable<Professeur> testSelect(){
            return sr.findall();
        }
        @RequestMapping(value = "/prof/mat/{id}",method = RequestMethod.GET)
        Iterable<Matiere> matiere(@PathVariable("id")long id) {
        return sr.Getmatiere(id);
    }

        @ResponseBody
        @RequestMapping(value = "/prof/create",method = RequestMethod.POST)
        Professeur create(@RequestParam String nom, @RequestParam String prenom){
            return sr.add(nom, prenom);
        }
        @RequestMapping(value = "/prof/{id}",method = RequestMethod.GET)
        Professeur get(@PathVariable("id")long id){
            return sr.findbyid(id);
        }
        @RequestMapping(value = "/prof/{idprof}/{idmat}",method = RequestMethod.POST)
        String addmat(@PathVariable("idprof")long idprof,@PathVariable("idmat")long idmat){
            return sr.addMatiere(idprof, idmat);
        }
        @PutMapping(value = "/prof/{id}")
        Professeur up(@PathVariable("id") long id,String nom,String prenom){
            return sr.update(id,nom,prenom);
        }
        @RequestMapping(value = "/prof/{idprof}/{idmat}",method = RequestMethod.DELETE)
         String supmat(@PathVariable("idprof")long idprof,@PathVariable("idmat")long idmat){
             return sr.addMatiere(idprof, idmat);
    }
        @RequestMapping(value = "/prof/{idprof}",method = RequestMethod.DELETE)
        String supmat(@PathVariable("idprof")long idprof){
        return sr.delete(idprof);
        }



    }



