package com.api.clincode.entity;

import javax.persistence.Entity;

@Entity
public class PacienteEntity extends PessoaEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String tipoSanguineo;
    private String convenio;
    private int numCarteirinha;
    private String vicios;
    private String doencas;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

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

    public int getNumCarteirinha() {
        return numCarteirinha;
    }

    public void setNumCarteirinha(int numCarteirinha) {
        this.numCarteirinha = numCarteirinha;
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
    



}
