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

    public void setNome(String Nome){
        this.Nome = Nome;
    }

    public String getTelefone(){
        return Telefone;
   }

    public void setTelefone(String Telefone){
        this.Telefone = Telefone;
    }

    public String getEmail(){
        return Email;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public String getEspecilidade(){
        return Especilidade;
    }

    public void setEspecilidade(String Especilidade){
        this.Especilidade = Especilidade;
    }

    public String getData(){
        return Data;
    }

    public void setData(String Data){
        this.Data = Data;
    }
    public String getHorario(){
        return Horario;
    }

    public void setHorario(String Horario){
        this.Horario = Horario;
    }

    @Override
    public String toString(){
        return "Nome: " + Nome + ", Telefone: " + Telefone + ", Email: " + Email + ", Especilidade: " + Especilidade + ", Data: " + Data + ", Horario:" + Horario;
    }

}
