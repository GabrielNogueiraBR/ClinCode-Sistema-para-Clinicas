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

	public PacienteEntity getPacienteByID(int id) {
		return repository.getOne(id);
	}

	public PacienteEntity putPacienteByID(int id, PacienteEntity paciente) {
		
		PacienteEntity auxiliar = repository.getOne(id);

		if(auxiliar != null){
			auxiliar.setAtributosByObject(paciente);
			return auxiliar;
		}
		else
			return null;
	}

	public void deletePacienteByID(int id) {
		PacienteEntity auxiliar = repository.getOne(id);
		
		if(existePacienteByID(id)){
			repository.delete(auxiliar);
		}

	}

	public Boolean existePacienteByID(int id) {
		PacienteEntity paciente = repository.getOne(id);

		if(paciente != null)
			return true; //existe o paciente informado
		
		return false; //nao existe o paciente informado

	}

	
    

}
