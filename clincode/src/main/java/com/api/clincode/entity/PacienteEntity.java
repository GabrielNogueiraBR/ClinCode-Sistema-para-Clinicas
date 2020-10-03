package com.api.clincode.entity;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class PacienteEntity extends PessoaEntity{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String  tipoSanguineo;
    private String  convenio;
    private int     numeroCarteirinha;
    private String  vicios;
    private String  doencas;

    public String getTipoSanguineo() {
        return tipoSanguineo;
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
