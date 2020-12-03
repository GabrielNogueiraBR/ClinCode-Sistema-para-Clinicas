package com.api.clincode.service;

import java.util.List;
import java.util.Optional;


import com.api.clincode.entity.PacienteEntity;
import com.api.clincode.entity.PessoaEntity;
import com.api.clincode.model.Login;
import com.api.clincode.repository.PacienteRepository;
import com.api.clincode.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PacienteService {
    
    @Autowired
	private PacienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public List<PacienteEntity> getAllPacientes() {
		return repository.findAll(); 
	}

	public PacienteEntity salvarPaciente(PacienteEntity entity) {
		return repository.save(entity);
	}

	public PacienteEntity getPacienteByID(int id) {
		Optional<PacienteEntity> paciente = repository.findById(id);

		return paciente.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente nao cadastrado.") );
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

	
	public String entrar(Login login) {
		
		PessoaEntity pessoa = pessoaRepository.findPessoaByEmailAndPassword(login.getEmail(), login.getPassword());

		//Caso exista o paciente vai executar normalmente
		PacienteEntity paciente = getPacienteByID(pessoa.getIdPessoa());

		return ("/pacientes" + "/" + paciente.getIdPessoa() + "/perfil");

	}

	
    

}
