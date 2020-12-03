package com.api.clincode.service;

import java.util.List;
import java.util.Optional;

import com.api.clincode.entity.PessoaEntity;
import com.api.clincode.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository repository;

	public List<PessoaEntity> getAllPessoas() {
		return repository.findAll();
	}
	
	public PessoaEntity getPessoaByID(int id) {
		Optional<PessoaEntity> pessoa = repository.findById(id);

		return pessoa.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa nao cadastrada."));
	}

	
    
}
