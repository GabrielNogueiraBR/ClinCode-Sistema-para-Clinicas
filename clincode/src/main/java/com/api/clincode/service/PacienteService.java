package com.api.clincode.service;

import java.util.List;

import com.api.clincode.entity.PacienteEntity;
import com.api.clincode.repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepository repository;

	public List<PacienteEntity> getAllPacientes() {
		return repository.findAll();
	}

	public PacienteEntity salvarPaciente(PacienteEntity entity) {
		return repository.save(entity);
	}
    

}
