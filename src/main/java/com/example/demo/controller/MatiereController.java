package com.example.demo.controller;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Matiere;
import com.example.demo.repositories.MatiereRepository;
import com.example.demo.service.ServiceMatiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MatiereController {
    @Autowired
    ServiceMatiere sm;
    @Autowired
    MatiereRepository mr;
    @ResponseBody
    @RequestMapping("/mat")
    public Iterable<Matiere> testSelect(){
        return sm.findall();
    }
    @RequestMapping("/mat/{id}")
    public Matiere mat(@PathVariable("id") long id){
        return sm.findId(id);
    }

    @RequestMapping(value = "/mat/create",method = RequestMethod.POST)
    Matiere create(@RequestParam String nom ,@RequestParam String desc,@RequestParam Long id){
        return sm.add(nom,desc,id);
    }

    @RequestMapping(value = "/mat/{id}",method = RequestMethod.DELETE)
        String delete(@PathVariable("id")long id){
        return sm.delete(id);
    }
    @PutMapping(value = "/mat/{id}")
    Matiere update(@PathVariable("id")long id,String nom,String description){
        return sm.update(id,nom,description);
    }
    @GetMapping("/mat/etud/{id}")
    Iterable<Etudiant> etud(@PathVariable("id") long id){
        Matiere mat = mr.findById(id).get();
        return mat.getEtud();
    }
    @RequestMapping(value = "/mat/etudiant/{id}")
    public Iterable<Etudiant> etudiant(@PathVariable("id") long id) {return sm.getetud(id);}
    @RequestMapping(value = "/mat/{idprof}/{idmat}")
    Matiere prof(@PathVariable("idprof") long idprof,@PathVariable("idmat")long idmat){
        return sm.addprof(idprof, idmat);
    }
}
