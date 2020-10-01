package com.api.clincode.service;

import java.util.List;

import com.api.clincode.entity.UsuarioEntity;
import com.api.clincode.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository repository;

	public List<UsuarioEntity> getAllUsuarios() {
        return repository.findAll();
	}

	public UsuarioEntity cadastrarUsuario(UsuarioEntity entity) {
        repository.save(entity);
        return entity;
	}

}
