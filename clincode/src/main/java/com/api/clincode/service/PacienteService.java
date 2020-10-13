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
		PacienteEntity paciente;

		if(repository.findById(id).isPresent()){
			paciente = repository.findById(id).get();	
			return paciente;
		}
		else
			return null;
	}

	public PacienteEntity putPacienteByID(int id, PacienteEntity paciente) {
		
		PacienteEntity auxiliar = getPacienteByID(id);

		if(auxiliar != null){
			auxiliar.setAtributosByObject(paciente);
			repository.save(auxiliar);
			return auxiliar;
		}
		else
			return null;
	}

	public void deletePacienteByID(int id) {
		PacienteEntity auxiliar = getPacienteByID(id);
		
		if(existePacienteByID(id)){
			repository.delete(auxiliar);
		}

	}

	public Boolean existePacienteByID(int id) {
		PacienteEntity paciente;
		paciente = getPacienteByID(id);

		if(paciente != null)
			return true; //existe o paciente informado
		
		return false; //nao existe o paciente informado

	}

	
    

}
