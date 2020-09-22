public class Medico extends Pessoa {

    protected String crm;
	protected String login;
	protected String turno;
	protected String especialidade1;
	protected String especialidade2;
	

	public Medico(String nome, String dataNascimento, String rg, String cpf, String email, String telefone, String rua, String bairro, int num, String cidade, String estado, String crm, String login) {
		super(nome, dataNascimento, rg, cpf, email, telefone, rua, bairro, num, cidade, estado);
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

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getEspecialidade1() {
		return especialidade1;
	}

	public void setEspecialidade1(String especialidade1) {
		this.especialidade1 = especialidade1;
	}

	public String getEspecialidade2() {
		return especialidade2;
	}

	public void setEspecialidade2(String especialidade2) {
		this.especialidade2 = especialidade2;
	}

}
