package com.api.clincode.model;

public class Endereco {
    protected String rua;
    protected String bairro;
    protected int num;
    protected String cidade;
    protected String estado;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return ", \nRua: " + rua + ", Bairro: " + bairro + ", Num: " + num + ", Cidade: " + cidade + ", Estado: " + estado;
    }
    
}
