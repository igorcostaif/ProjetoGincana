package br.edu.ifba.BackGincana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_status")
public class StatusModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_status", nullable = false)
	private int id_status;

	@Column(name = "situacao_Status", length = 12, nullable = true)
	private String situacao_Status;

	
	public StatusModel() {
		super();
	}

	public StatusModel(int id_status, String situacao_Status) {
		super();
		this.id_status = id_status;
		this.situacao_Status = situacao_Status;
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}

	public String getSituacao_Status() {
		return situacao_Status;
	}

	public void setSituacao_Status(String situacao_Status) {
		this.situacao_Status = situacao_Status;
	}

}
