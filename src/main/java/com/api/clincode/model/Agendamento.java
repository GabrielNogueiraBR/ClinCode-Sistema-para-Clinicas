package com.api.clincode.model;

public class Agendamento {

    protected String nome;
    protected String telefone;
    protected String email;
    protected String especilidade;
    protected String data;
    protected String horario;

    public String getNome(){
        return nome;
    }

    public void setNome(final String Nome){
        this.nome = Nome;
    }

    public String getTelefone(){
        return telefone;
   }

    public void setTelefone(final String Telefone){
        this.telefone = Telefone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(final String Email){
        this.email = Email;
    }

    public String getEspecilidade(){
        return especilidade;
    }

    public void setEspecilidade(final String Especilidade){
        this.especilidade = Especilidade;
    }

    public String getData(){
        return data;
    }

    public void setData(final String Data){
        this.data = Data;
    }
    public String getHorario(){
        return horario;
    }

    public void setHorario(final String Horario){
        this.horario = Horario;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email + ", Especilidade: " + especilidade + ", Data: " + data + ", Horario:" + horario;
    }

}
