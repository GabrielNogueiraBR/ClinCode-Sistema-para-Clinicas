package com.api.clincode.model;

public class Pessoa {
    Endereco logradouro = new Endereco();

    protected String nome;
    protected String dataNascimento;
    protected String rg;
    protected String cpf;
    protected String email;

    protected String telefone;

    public Pessoa(String nome, String dataNascimento, String rg, String cpf, String email, String telefone, String rua, String bairro, int num, String cidade, String estado) {

        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        logradouro.rua = rua;
        logradouro.num = num;
        logradouro.bairro = bairro;
        logradouro.cidade = cidade;
        logradouro.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ",\nData de Nascimento: " + dataNascimento + ", \nRG: " + rg + ", \nCPF: " + cpf + ", \nEmail: " + email + ",\nTelefone: " + telefone + logradouro.toString();

    }

}
