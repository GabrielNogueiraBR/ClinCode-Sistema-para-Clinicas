package com.api.clincode.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class PacienteEntity extends PessoaEntity {

    private static final long serialVersionUID = 1L;
    private String tipoSanguineo;
    private String convenio;
    private int numeroCarteirinha;
    private String vicios;
    private String doencas;

    @OneToMany
    @JoinColumn(name="ID_PACIENTE")
    private List<AgendamentoEntity> agendamentos;

    @OneToMany
    @JoinColumn(name = "ID_PACIENTE")
    private List<ConsultaEntity> consultas;

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public List<AgendamentoEntity> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoEntity> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public int getNumeroCarteirinha() {
        return numeroCarteirinha;
    }

    public void setNumeroCarteirinha(int numeroCarteirinha) {
        this.numeroCarteirinha = numeroCarteirinha;
    }

    public String getVicios() {
        return vicios;
    }

    public void setVicios(String vicios) {
        this.vicios = vicios;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public List<ConsultaEntity> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaEntity> consultas) {
        this.consultas = consultas;
    }
    
    //metodo criado para a utilizacao no PUT
    public void setAtributosByObject(PacienteEntity entity){
        this.numeroCarteirinha = entity.getNumeroCarteirinha();
        this.convenio = entity.getConvenio();
        this.doencas = entity.getDoencas();
        this.tipoSanguineo = entity.getTipoSanguineo();
        this.vicios = entity.getVicios();
        
        this.setNome(entity.getNome());
        this.setDataNascimento(entity.getDataNascimento());
        this.setRg(entity.getRg());
        this.setCpf(entity.getCpf());
        this.setEmail(entity.getEmail());
        this.setTelefone1(entity.getTelefone1());
        this.setTelefone2(entity.getTelefone2());
        this.setRua(entity.getRua());
        this.setBairro(entity.getBairro());
        this.setNumeroCasa(entity.getNumeroCasa());
        this.setCidade(entity.getCidade());
        this.setEstado(entity.getEstado());
        this.setSenha(entity.getSenha());
    }
}
