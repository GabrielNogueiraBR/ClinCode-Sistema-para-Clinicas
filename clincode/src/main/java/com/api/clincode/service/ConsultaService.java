package com.api.clincode.service;

import java.util.List;
import java.util.Optional;

import com.api.clincode.entity.ConsultaEntity;
import com.api.clincode.repository.ConsultaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    
    @Autowired
    private ConsultaRepository repository;

    public List<ConsultaEntity> getAllConsultas() {
        return repository.findAll();        
    }

    public ConsultaEntity getConsultaByID(int id) {
        Optional<ConsultaEntity> optional = repository.findById(id);

        if(optional.isPresent())
            return optional.get();

        return null;
    }

    public ConsultaEntity cadastraConsulta(ConsultaEntity entity) {
        return repository.save(entity);
    }

    // public ConsultaEntity alteraInformacoesByEntidade(ConsultaEntity destinoEntity, ConsultaEntity modificacoesEntity) {
        
    // }

    public boolean deleteConsultaByID(int id) {
        ConsultaEntity entity = getConsultaByID(id);

        if(entity == null)
            return false;
        
        repository.delete(entity);
        return true;
    }

}
