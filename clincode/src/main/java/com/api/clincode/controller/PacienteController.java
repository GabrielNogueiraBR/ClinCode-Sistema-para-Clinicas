package com.api.clincode.controller;

import java.net.URI;
import java.util.List;

import com.api.clincode.entity.PacienteEntity;
import com.api.clincode.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    @Autowired
    private PacienteService service;

    @GetMapping()
    public List<PacienteEntity> getAllPacientes(){
        return service.getAllPacientes();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PacienteEntity> getPacienteByID(@PathVariable final int id){
        PacienteEntity paciente;
        paciente = service.getPacienteByID(id);

        if(paciente != null)
            return ResponseEntity.ok(paciente);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Void> postPaciente(@RequestBody PacienteEntity entity){
        entity = service.salvarPaciente(entity);

        if(entity != null)
        {
            URI uri = URI.create("http://localhost:8080/pacientes/"+entity.getIdPessoa());
            return ResponseEntity.created(uri).build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteEntity> putPacienteByID(@PathVariable int id, @RequestBody PacienteEntity paciente){
       
        paciente = service.putPacienteByID(id, paciente);

        if(paciente != null){
            return ResponseEntity.ok(paciente);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacienteByID(@PathVariable int id){
        Boolean val = service.existePacienteByID(id);

        if(val == true){
            service.deletePacienteByID(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
