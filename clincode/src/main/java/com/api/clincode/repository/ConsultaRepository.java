package com.api.clincode.repository;

import com.api.clincode.entity.ConsultaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Integer> {
    
}
