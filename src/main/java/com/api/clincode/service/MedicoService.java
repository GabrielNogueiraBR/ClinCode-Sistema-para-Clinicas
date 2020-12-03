package com.api.clincode.service;

import java.util.List;
import java.util.Optional;

import com.api.clincode.entity.MedicoEntity;
import com.api.clincode.entity.PessoaEntity;
import com.api.clincode.model.Login;
import com.api.clincode.repository.MedicoRepository;
import com.api.clincode.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MedicoService {
    
    @Autowired
    private MedicoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

	public List<MedicoEntity> getAllMedicos() {
		return repository.findAll();
	}

	public MedicoEntity getMedicoByID(int id) {
        Optional<MedicoEntity> medico = repository.findById(id);
        
        return medico.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico nao cadastrado.") );
	}

	public MedicoEntity cadastraMedico(MedicoEntity medico) {
        
        medico = repository.save(medico);
        
        if(medico != null)
            return medico;
        else
            return null;
	}

	public MedicoEntity putMedicoByID(int id, MedicoEntity medico) {
        
        MedicoEntity auxiliar = getMedicoByID(id);

        if(auxiliar != null){
            auxiliar.setBairro(medico.getBairro());
            auxiliar.setCidade(medico.getCidade());
            auxiliar.setCpf(medico.getCpf());
            auxiliar.setCrm(medico.getCrm());
            auxiliar.setDataNascimento(medico.getDataNascimento());
            auxiliar.setEmail(medico.getEmail());
            auxiliar.setEspecialidade1(medico.getEspecialidade1());
            auxiliar.setEspecialidade2(medico.getEspecialidade2());
            auxiliar.setEstado(medico.getEstado());
            auxiliar.setNome(medico.getNome());
            auxiliar.setNumeroCasa(medico.getNumeroCasa());
            auxiliar.setRg(medico.getRg());
            auxiliar.setRua(medico.getRua());
            auxiliar.setSenha(medico.getSenha());
            auxiliar.setTelefone1(medico.getTelefone1());
            auxiliar.setTelefone2(medico.getTelefone2());
            auxiliar.setTurno(medico.getTurno());
            
            repository.save(auxiliar);
            
            return auxiliar;
        }
        else
            return null;
	}

	public void deletaMedicoByID(int id) {
        
        MedicoEntity medico = getMedicoByID(id);
        repository.delete(medico);
        
	}

	public Boolean existeMedicoByID(int id) {
       
        if(getMedicoByID(id) != null)
            return true;
        
        return false;
	}

	public String entrar(Login login) {
            PessoaEntity pessoa = pessoaRepository.findPessoaByEmailAndPassword(login.getEmail(), login.getPassword());

            //Caso exista o paciente vai executar normalmente
            MedicoEntity entity = getMedicoByID(pessoa.getIdPessoa());

            return ("/medicos" + "/" + entity.getIdPessoa() + "/perfil");
	}





}
