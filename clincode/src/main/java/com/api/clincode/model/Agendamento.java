package com.api.clincode.model;

public class Agendamento {

    protected String Nome;
    protected String Telefone;
    protected String Email;
    protected String Especilidade;
    protected String Data;
    protected String Horario;

    public String getNome(){
        return Nome;
    }

    public void setNome(final String Nome){
        this.Nome = Nome;
    }

    public String getTelefone(){
        return Telefone;
   }

    public void setTelefone(final String Telefone){
        this.Telefone = Telefone;
    }

    public String getEmail(){
        return Email;
    }

    public void setEmail(final String Email){
        this.Email = Email;
    }

    public String getEspecilidade(){
        return Especilidade;
    }

    public void setEspecilidade(final String Especilidade){
        this.Especilidade = Especilidade;
    }

    public String getData(){
        return Data;
    }

    public void setData(final String Data){
        this.Data = Data;
    }
    public String getHorario(){
        return Horario;
    }

    public void setHorario(final String Horario){
        this.Horario = Horario;
    }

    @Override
    public String toString(){
        return "Nome: " + Nome + ", Telefone: " + Telefone + ", Email: " + Email + ", Especilidade: " + Especilidade + ", Data: " + Data + ", Horario:" + Horario;
    }

}
