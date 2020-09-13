public class Medico extends Pessoa {

    protected String crm;
    protected String login;

	public Medico(String nome, String dataNascimento, String rg, String cpf, String email, String rua, String bairro,
			int num, String cidade, String estado, String crm, String login) {
		super(nome, dataNascimento, rg, cpf, email, rua, bairro, num, cidade, estado);
		this.crm = crm;
		this.login = login;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
