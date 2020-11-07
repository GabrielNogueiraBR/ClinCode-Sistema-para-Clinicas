package com.api.clincode.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class MedicoEntity extends PessoaEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(unique = true)
	private String crm;
	private String turno;
	private String especialidade1;
	private String especialidade2;

	@OneToMany
	@JoinColumn(name = "ID_MEDICO")
	private List<ConsultaEntity> consultas;

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
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
