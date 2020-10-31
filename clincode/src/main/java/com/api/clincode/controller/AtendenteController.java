package com.api.clincode.controller;

import java.net.URI;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import com.api.clincode.entity.AtendenteEntity;
import com.api.clincode.service.AtendenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/atendentes")
public class AtendenteController {
    
    @Autowired
    private AtendenteService service;

    @GetMapping()
    public List<AtendenteEntity> getAllAtendentes(){
        return service.getAllAtendentes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendenteEntity> getAtendenteByID(@PathVariable final int id){
        AtendenteEntity entity = service.getAtendenteByID(id);

        //caso não tenha encontrado o Atendente pelo ID fornecido na URL (requisição)
        if(entity == null)
            return ResponseEntity.notFound().build();


        //caso tenha encontrado
        return ResponseEntity.ok(entity);
    }

    @PostMapping()
    public ResponseEntity<Void> cadastraAtendente(@ModelAttribute AtendenteEntity entity, HttpServletRequest request, UriComponentsBuilder builder){

        entity = service.cadastraAtendente(entity);

        //Cria os componentes da URI
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + entity.getIdPessoa()).build();

        //Cria a URI a partir dos componentes
        URI uri = uriComponents.toUri();

        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<AtendenteEntity> putAtendenteByID(@PathVariable final int id, @RequestBody AtendenteEntity entity){

        AtendenteEntity atendenteEntity = service.getAtendenteByID(id);

        if(atendenteEntity == null)
            return ResponseEntity.notFound().build();
        
        atendenteEntity = service.alteraInformacoesByEntidade(atendenteEntity, entity);
        return ResponseEntity.ok(atendenteEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendenteByID(@PathVariable final int id){
        
        if(service.deleteAtendenteByID(id) == false)
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.noContent().build();
    }
}
