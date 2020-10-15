package com.api.clincode.repository;

import com.api.clincode.entity.MedicoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity,Integer>{
    
}
