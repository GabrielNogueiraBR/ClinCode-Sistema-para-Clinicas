package com.api.clincode.service;

import java.util.List;
import java.util.Optional;

import com.api.clincode.entity.AtendenteEntity;
import com.api.clincode.entity.PessoaEntity;
import com.api.clincode.model.Login;
import com.api.clincode.repository.AtendenteRepository;
import com.api.clincode.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AtendenteService {
    
    @Autowired
    private AtendenteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

	public List<AtendenteEntity> getAllAtendentes() {
                return repository.findAll();
	}

	public AtendenteEntity getAtendenteByID(int id) {
        
                Optional<AtendenteEntity> optional = repository.findById(id);
                
                return optional.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atendente nao cadastrado") ) ;
	}

	public AtendenteEntity cadastraAtendente(AtendenteEntity entity) {
                return repository.save(entity);
        }

        public AtendenteEntity alteraInformacoesByEntidade(AtendenteEntity destinoEntity, AtendenteEntity modificacoesEntity) {
                
                destinoEntity.setNome(modificacoesEntity.getNome());
                destinoEntity.setDataNascimento(modificacoesEntity.getDataNascimento());
                destinoEntity.setRg(modificacoesEntity.getRg());
                destinoEntity.setCpf(modificacoesEntity.getCpf());
                destinoEntity.setEmail(modificacoesEntity.getEmail());
                destinoEntity.setTelefone1(modificacoesEntity.getTelefone1());
                destinoEntity.setTelefone2(modificacoesEntity.getTelefone2());
                destinoEntity.setRua(modificacoesEntity.getRua());
                destinoEntity.setBairro(modificacoesEntity.getBairro());
                destinoEntity.setNumeroCasa(modificacoesEntity.getNumeroCasa());
                destinoEntity.setCidade(modificacoesEntity.getCidade());
                destinoEntity.setEstado(modificacoesEntity.getEstado());
                destinoEntity.setSenha(modificacoesEntity.getSenha());

                destinoEntity = repository.save(destinoEntity);

                return destinoEntity;

        }

	public boolean deleteAtendenteByID(int id) {

                AtendenteEntity entity = getAtendenteByID(id);
                
                if(entity == null)
                return false;
                
                repository.delete(entity);
                return true;

	}

	public String entrar(Login login) {
                
                PessoaEntity pessoa = pessoaRepository.findPessoaByEmailAndPassword(login.getEmail(), login.getPassword());

                //Caso exista o paciente vai executar normalmente
                AtendenteEntity entity = getAtendenteByID(pessoa.getIdPessoa());

                return ("/atendentes" + "/" + entity.getIdPessoa() + "/perfil");
	}



}
