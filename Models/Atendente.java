import java.util.Scanner;

public class Atendente extends Pessoa {
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


    public Atendente(String nome, String dataNascimento, String rg, String cpf, String email, String telefone, String rua, String bairro, int num, String cidade, String estado, String turno, String disponibilidade, String restricao, Scanner ler) {
        super(nome, dataNascimento, rg, cpf, email, telefone, rua, bairro, num, cidade, estado);

        this.turno = turno;
        this.disponibilidade = disponibilidade;
        this.restricao = restricao;
        this.ler = ler;
    }
}