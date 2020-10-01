package com.api.clincode.controller;

import java.net.URI;
import java.util.List;

import com.api.clincode.entity.UsuarioEntity;
import com.api.clincode.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    UsuarioService service;

    @GetMapping()
    public List<UsuarioEntity> getAllUsuarios(){
        return service.getAllUsuarios();
    }

    @PostMapping()
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody UsuarioEntity entity) {
        
        entity = service.cadastrarUsuario(entity);
        URI uri = URI.create("http://localhost:8080/usuarios/" + entity.getId_usuario());
        return ResponseEntity.created(uri).build();
    }
    
    @GetMapping("/login")
    public ModelAndView redirecionaLogin(){
        ModelAndView mv = new ModelAndView("loginPaciente");
        return mv;
    }
}
