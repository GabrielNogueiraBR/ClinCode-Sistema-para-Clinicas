import java.util.Scanner;


public class Consulta {
    protected String crm;
    protected int id_consulta;
    protected String rg;
    protected String alergia;
    protected String queixa;
    protected String tempo;
    protected String diagnostico;
    protected String exameC;
    protected String medicacao;
    protected String habitos;
    Scanner ler = new Scanner(System.in);

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getQueixa() {
        return queixa;
    }

    public void setQueixa(String queixa) {
        this.queixa = queixa;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getExameC() {
        return exameC;
    }

    public void setExameC(String exameC) {
        this.exameC = exameC;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public String getHabitos() {
        return habitos;
    }

    public void setHabitos(String habitos) {
        this.habitos = habitos;
    }

    public Consulta() {
        System.out.println("Digite o seu RG: ");
        this.rg = ler.next();
        
        System.out.println ("Medico, digite sua CRM: ");
        this.crm= ler.next();

        String aux;
        System.out.println("Voce Possui alguma alergia?<S/N>: ");
        aux = ler.next();
        if (aux.equals("S")){
            System.out.println("Digite a sua alergia: ");
            this.alergia = ler.next();
        }else{
            alergia="Nenhuma alergia";
            this.alergia = "null";
        } 

        System.out.println("Digite a queixa do paciente: ");
        this.queixa = ler.next();

        System.out.println("Digite a quanto tempo o paciente esta se queixando do problema: ");
        this.tempo = ler.next();

        System.out.println("Digite o seu diagnostico do paciente: ");
        this.diagnostico = ler.next();

        String auxC;
        System.out.println("Sera necessario exame complementar?<S/N>: ");
        auxC = ler.next();
        if ("S".equals(auxC)){
            System.out.println("Digite qual sera o exame: ");
            this.exameC= ler.next();
        }
        else{
            this.exameC="Nenhum exame";
        }  

        System.out.println ("Digite qual sera a medicacao do paciente: ");
        this.medicacao= ler.next();

        System.out.println("O paciente possui algum habito? Ex: cigarro, bebida, etc.: ");
        this.habitos= ler.next();
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    
}
