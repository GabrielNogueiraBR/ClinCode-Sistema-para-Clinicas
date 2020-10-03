package com.api.clincode.controller;

import java.util.List;

import com.api.clincode.entity.PessoaEntity;
import com.api.clincode.service.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaService service;

    @GetMapping()
    public List<PessoaEntity> getAllPessoas(){
        return service.getAllPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaEntity> getPessoaByID(@PathVariable int id){
        PessoaEntity entity;

        entity = service.getPessoaByID(id);

        if(entity != null)
            return ResponseEntity.ok(entity);
        else
            return ResponseEntity.notFound().build();
    }

    

}
