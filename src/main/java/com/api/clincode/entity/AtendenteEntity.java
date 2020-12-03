package com.api.clincode.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class AtendenteEntity extends PessoaEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String area;
    private boolean grupoRisco;
    private String patologiaGrupoRisco;
    private String turno;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isGrupoRisco() {
        return grupoRisco;
    }

    public void setGrupoRisco(boolean grupoRisco) {
        this.grupoRisco = grupoRisco;
    }

    public String getPatologiaGrupoRisco() {
        return patologiaGrupoRisco;
    }

    public void setPatologiaGrupoRisco(String patologiaGrupoRisco) {
        this.patologiaGrupoRisco = patologiaGrupoRisco;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    
}
