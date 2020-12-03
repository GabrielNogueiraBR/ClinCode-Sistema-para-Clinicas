package com.api.clincode.repository;

import com.api.clincode.entity.PessoaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity,Integer> {
    
    @Query("SELECT A FROM PessoaEntity A  WHERE A.email = ?1 AND A.senha = ?2")
    PessoaEntity findPessoaByEmailAndPassword(String email, String password);

}
