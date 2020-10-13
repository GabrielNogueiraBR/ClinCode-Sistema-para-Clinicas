package com.api.clincode.service;

import java.util.List;

import com.api.clincode.entity.PessoaEntity;
import com.api.clincode.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository repository;

	public List<PessoaEntity> getAllPessoas() {
		return repository.findAll();
	}
	
	public PessoaEntity getPessoaByID(int id) {
		return repository.getOne(id);
	}

	
    
}
