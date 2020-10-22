package com.api.clincode.repository;

import com.api.clincode.entity.AtendenteEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendenteRepository extends JpaRepository<AtendenteEntity, Integer>{
    
}
