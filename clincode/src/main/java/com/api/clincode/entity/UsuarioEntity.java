package com.api.clincode.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@autor: Gabriel Nogueira 
//Descrição: Essa classe vai conter as informações de login de cada usuário. 
//Vai buscar no BD as informaçoes DE ACORDO com os privilégio (se é medico, paciente, atendente ou admin) e construir a o objeto de acordo com essas informações.
@Entity
public class UsuarioEntity implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String login_usuario;
    private String password_usuario;
    
    //privilegios
    private Boolean usuario_paciente;
    private Boolean usuario_atendente;
    private Boolean usuario_medico;
    private Boolean usuario_admin;

    //chaves estrangeiras nas tabelas de paciente, medico e atendente
    private int fk_idPessoa;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public Boolean getUsuario_paciente() {
        return usuario_paciente;
    }

    public void setUsuario_paciente(Boolean usuario_paciente) {
        this.usuario_paciente = usuario_paciente;
    }

    public Boolean getUsuario_atendente() {
        return usuario_atendente;
    }

    public void setUsuario_atendente(Boolean usuario_atendente) {
        this.usuario_atendente = usuario_atendente;
    }

    public Boolean getUsuario_medico() {
        return usuario_medico;
    }

    public void setUsuario_medico(Boolean usuario_medico) {
        this.usuario_medico = usuario_medico;
    }

    public Boolean getUsuario_admin() {
        return usuario_admin;
    }

    public void setUsuario_admin(Boolean usuario_admin) {
        this.usuario_admin = usuario_admin;
    }

    public int getFk_idPessoa() {
        return fk_idPessoa;
    }

    public void setFk_idPessoa(int fk_idPessoa) {
        this.fk_idPessoa = fk_idPessoa;
    }
    
    
    
}
