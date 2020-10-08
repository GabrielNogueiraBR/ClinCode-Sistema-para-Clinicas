package com.api.clincode.controller;

import java.net.URI;
import java.util.List;

import com.api.clincode.entity.MedicoEntity;
import com.api.clincode.service.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    
    @Autowired
    private MedicoService service;
    private String location = "http://localhost:8080";

    @GetMapping()
    public List<MedicoEntity> getAllMedicos(){
        return service.getAllMedicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoEntity> getMedicoByID(@PathVariable final int id){
        MedicoEntity medico = service.getMedicoByID(id);

        if(medico != null){
            return ResponseEntity.ok(medico);
        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping()
    public ResponseEntity<Void> cadastraMedico(@ModelAttribute MedicoEntity medico){
        medico = service.cadastraMedico(medico);

        if(medico != null){
            URI uri = URI.create(location+"/"+medico.getIdPessoa());
            return ResponseEntity.created(uri).build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoEntity> alteraMedicoByID(@PathVariable final int id, @ModelAttribute MedicoEntity medico){
        medico = service.alteraMedicoByID(id,medico);

        if(medico != null){
            return ResponseEntity.ok(medico);
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaMedicoByID(@PathVariable final int id){
        Boolean existe = service.existeMedicoByID(id);

        if(existe == true)
        {
            service.deletaMedicoByID(id);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }



}
