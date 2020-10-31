package com.api.clincode.service;

import java.util.List;
import java.util.Optional;

import com.api.clincode.entity.AgendamentoEntity;
import com.api.clincode.entity.ConsultaEntity;
import com.api.clincode.repository.AgendamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AgendamentoService {
    
    @Autowired
    private AgendamentoRepository repository;

    public List<AgendamentoEntity> getAllAgendamentos() {
        return repository.findAll();
    }

	public AgendamentoEntity getAgendamentoByID(int id) {
        Optional<AgendamentoEntity> op = repository.findById(id);
        
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento sem registros"));
	}

	public AgendamentoEntity cadastraConsulta(AgendamentoEntity entity) {
		return repository.save(entity);
	}

	public AgendamentoEntity alteraInformacoesByEntidade(AgendamentoEntity destinoEntity, AgendamentoEntity modificacoesEntity) {
        destinoEntity.setNome(modificacoesEntity.getNome());
        destinoEntity.setTelefone(modificacoesEntity.getTelefone());
        destinoEntity.setEmail(modificacoesEntity.getEmail());
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
