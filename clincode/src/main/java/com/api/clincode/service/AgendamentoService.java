package com.api.clincode.service;

import java.util.List;
import java.util.Optional;

import com.api.clincode.entity.AgendamentoEntity;
import com.api.clincode.entity.PacienteEntity;
import com.api.clincode.repository.AgendamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AgendamentoService {
    
    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private PacienteService pacienteService;

    public List<AgendamentoEntity> getAllAgendamentos() {
        return repository.findAll();
    }

    public AgendamentoEntity getAgendamentoByID(int id) {
        Optional<AgendamentoEntity> op = repository.findById(id);
        
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento sem registros"));
    }

    /**
     * Esse metodo realizara o cadastro da consulta em nosso banco de dados utilizando o AgendamentoRepository.
     * @author Gabriel Nogueira
     * @param id do paciente que sera utilizado para recuperar o objeto PacienteEntity caso este exista, caso contrario, sera exibida a mensagem de 404 (Not Found)
     * @param entity entidade AgendamentoEntity que sera salva.
     * @return o retorno sera o objeto salvo.
     */
    public AgendamentoEntity cadastraConsulta(int id, AgendamentoEntity entity) {
        
        PacienteEntity paciente = pacienteService.getPacienteByID(id);
        entity.setPaciente(paciente);

        return repository.save(entity);
    }

    public AgendamentoEntity alteraInformacoesByEntidade(AgendamentoEntity destinoEntity, AgendamentoEntity modificacoesEntity) {
        destinoEntity.setPaciente(modificacoesEntity.getPaciente());
        destinoEntity.setEspecialidade(modificacoesEntity.getEspecialidade());
        destinoEntity.setData(modificacoesEntity.getData());
        destinoEntity.setHorario(modificacoesEntity.getHorario());

        destinoEntity = repository.save(destinoEntity);

        return destinoEntity;
    }

    public boolean deleteAgendamentoByID(int id) {
        AgendamentoEntity entity = getAgendamentoByID(id);
                
        repository.delete(entity);

        return true;
    }

}
