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
    private String TipoSanguineo;
    private String Convenio;
    private int Carteirinha;
    private String Vicios;
    private String Doencas;

    public String getTipoSanguineo() {
        return TipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        TipoSanguineo = tipoSanguineo;
    }

    public String getConvenio() {
        return Convenio;
    }

    public void setConvenio(String convenio) {
        Convenio = convenio;
    }

    public int getCarteirinha() {
        return Carteirinha;
    }

    public void setCarteirinha(int carteirinha) {
        Carteirinha = carteirinha;
    }

    public String getVicios() {
        return Vicios;
    }

    public void setVicios(String vicios) {
        Vicios = vicios;
    }

    public String getDoencas() {
        return Doencas;
    }

    public void setDoencas(String doencas) {
        Doencas = doencas;
    }
    
    

}
