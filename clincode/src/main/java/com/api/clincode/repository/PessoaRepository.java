package com.api.clincode.repository;

import com.api.clincode.entity.PessoaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity,Integer> {
    
}
