package com.example.demo.controller;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Matiere;
import com.example.demo.repositories.EtudiantRepository;
import com.example.demo.repositories.MatiereRepository;
import com.example.demo.service.ServiceEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudiantController {
    private List<Matiere> l;
    @Autowired
    ServiceEtudiant se;
    @ResponseBody
    @RequestMapping("/etudiant")
    public Iterable<Etudiant> testSelect(){
        return se.find();
    }
    @ResponseBody
    @RequestMapping(value = "/etudiant/create",method = RequestMethod.POST)
    Etudiant create(@RequestParam String nom,@RequestParam String prenom,@RequestParam long matricule){
        return se.create(nom, prenom,matricule);
    }
    @ResponseBody
    @RequestMapping(value = "/etudiant/update/{id}",method = RequestMethod.PUT)
    Etudiant update(@PathVariable("id") Long id,String nom,String prenom,long matricule){
        return se.update(id,nom,prenom,matricule);

    }
    @RequestMapping(value="/etudiant/del/{id}",method = RequestMethod.DELETE)
    Etudiant sup(@PathVariable("id") Long id){

        return se.delete(id);
    }

    @RequestMapping(value = "/etudiants/{idet}/{idmat}",method = RequestMethod.PUT)
    Etudiant cour(@PathVariable("idet") Long idet,@PathVariable("idmat") Long idmat){
        return se.cour(idet,idmat);
    }
    @GetMapping(value = "/etudiant/{id}/mat")
    Iterable<Matiere> cours(@PathVariable("id") Long id){return se.cours(id);}

}
