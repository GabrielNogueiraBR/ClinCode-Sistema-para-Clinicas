package com.api.clincode.repository;

import com.api.clincode.entity.AgendamentoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Integer>{
   
}
