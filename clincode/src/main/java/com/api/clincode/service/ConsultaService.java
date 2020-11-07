package com.api.clincode.service;

import java.util.List;
import java.util.Optional;

import com.api.clincode.entity.ConsultaEntity;
import com.api.clincode.repository.ConsultaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ConsultaService {
    
    @Autowired
    private ConsultaRepository repository;

    public List<ConsultaEntity> getAllConsultas() {
        return repository.findAll();        
    }

    public ConsultaEntity getConsultaByID(int id) {
        Optional<ConsultaEntity> optional = repository.findById(id);

        return optional.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Consulta nao cadastrada.") ) ;
    }

    public ConsultaEntity cadastraConsulta(ConsultaEntity entity) {
        return repository.save(entity);
    }

    public ConsultaEntity alteraInformacoesByEntidade(ConsultaEntity destinoEntity, ConsultaEntity modificacoesEntity) {
        destinoEntity.setCrm(modificacoesEntity.getCrm());        
        destinoEntity.setRg(modificacoesEntity.getRg());        
        destinoEntity.setAlergia(modificacoesEntity.getAlergia());        
        destinoEntity.setQueixa(modificacoesEntity.getQueixa());        
        destinoEntity.setTempo(modificacoesEntity.getTempo());        
        destinoEntity.setDiagnostico(modificacoesEntity.getDiagnostico());        
        destinoEntity.setExameC(modificacoesEntity.getExameC());        
        destinoEntity.setMedicacao(modificacoesEntity.getMedicacao());        
        destinoEntity.setHabitos(modificacoesEntity.getHabitos());
        
        destinoEntity = repository.save(destinoEntity);

        return destinoEntity;
    }

    public boolean deleteConsultaByID(int id) {
        ConsultaEntity entity = getConsultaByID(id);

        if(entity == null)
            return false;
        
        repository.delete(entity);
        return true;
    }

}
