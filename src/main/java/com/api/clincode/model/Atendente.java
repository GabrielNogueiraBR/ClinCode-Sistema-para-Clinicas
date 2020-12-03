package com.api.clincode.model;
import java.util.Scanner;

public class Atendente {
    protected String turno;
    protected String disponibilidade;
    protected String restricao;
    Scanner ler = new Scanner(System.in);

    public String getTurno() {
        return turno;
    }

    public void setTurno(final String turno) {
        this.turno = turno;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(final String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getRestricao() {
        return restricao;
    }

    public void setRestricao(final String restricao) {
        this.restricao = restricao;
    }

    public Scanner getLer() {
        return ler;
    }

    public void setLer(final Scanner ler) {
        this.ler = ler;
    }

}