package com.api.clincode.controller;

import java.util.List;


import com.api.clincode.entity.AgendamentoEntity;
import com.api.clincode.service.AgendamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoService service;

    @GetMapping
    public List<AgendamentoEntity> getAllAgendamentos() {
        return service.getAllAgendamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoEntity> getConsultaByID(@PathVariable final int id) {
        AgendamentoEntity entity = service.getAgendamentoByID(id);

        return ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoEntity> putAgendamentoByID(@PathVariable final int id, @RequestBody AgendamentoEntity entity) {
        AgendamentoEntity consultaEntity = service.getAgendamentoByID(id);

        consultaEntity = service.alteraInformacoesByEntidade(consultaEntity, entity);

        return ResponseEntity.ok(consultaEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AgendamentoEntity> deleteAgendamentoByID(@PathVariable final int id) {
        service.deleteAgendamentoByID(id);
        
        return ResponseEntity.noContent().build();
    }

}
