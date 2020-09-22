//@autor: Gabriel Nogueira 
//Descrição: Essa classe vai identificar o tipo de usuario que está logando em nosso sistema (se é um Paciente ou Administrador do sistema). Com ela, podemos direcionar corretamente cada usuário para a página que está de acordo com seus privilégios ou permissões.
public class  Privilegios {
    protected Boolean usuario_paciente;
    protected Boolean usuario_atendente;
    protected Boolean usuario_medico;
    protected Boolean usuario_admin;

    //Getters e Setters
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

    public Privilegios(Boolean usuario_paciente, Boolean usuario_atendente, Boolean usuario_medico,
            Boolean usuario_admin) {
        this.usuario_paciente = usuario_paciente;
        this.usuario_atendente = usuario_atendente;
        this.usuario_medico = usuario_medico;
        this.usuario_admin = usuario_admin;
    }

    
}
