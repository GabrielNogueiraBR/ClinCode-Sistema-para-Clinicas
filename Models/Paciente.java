public class Paciente extends Pessoa {

    protected String TipoSanguineo;
    protected String Convenio;
    protected int Carteirinha;
    protected String Vicios;
    protected String Doencas;
    


    public Paciente(String nome, String dataNascimento, String rg, String cpf, String email, String telefone, String rua, String bairro, int num, String cidade, String estado, String tipoSanguineo, String Convenio, int Carteirinha, String Vicios, String Doencas) {
        super(nome, dataNascimento, rg, cpf, email, telefone, rua, bairro, num, cidade, estado);
        this.TipoSanguineo = tipoSanguineo;

        this.Convenio = Convenio;
        this.Carteirinha = Carteirinha;
        this.Vicios = Vicios;
        this.Doencas = Doencas;
    }

    public String getTipoSanguineo(){
        return TipoSanguineo;
    }
    public void setTipoSanguineo(String TipoSanguineo){
        this.TipoSanguineo = TipoSanguineo;
    }

    public String getConvenio() {
        return Convenio;
    }

    public void setConvenio(String convenio) {
        Convenio = convenio;
    }

    public int getCarteirinha() {
        return Carteirinha;
    }

    public void setCarteirinha(int carteirinha) {
        Carteirinha = carteirinha;
    }

    public String getVicios() {
        return Vicios;
    }

    public void setVicios(String vicios) {
        Vicios = vicios;
    }

    public String getDoencas() {
        return Doencas;
    }

    public void setDoencas(String doencas) {
        Doencas = doencas;
    }

}
