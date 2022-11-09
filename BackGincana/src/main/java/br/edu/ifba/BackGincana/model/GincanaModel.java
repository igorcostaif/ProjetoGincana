package br.edu.ifba.BackGincana.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_gincana")
public class GincanaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Gincana", nullable = false)
	private int id_Gincana;

	@Column(name = "nome_Gincana", length = 45, nullable = false)
	private String nome_Gincana;

	@Column(name = "descricao_Gincana", length = 200, nullable = false)
	private String descricao_Gincana;

	@Column(name = "data_inicio_Gincana", nullable = false)
	private Date data_inicio_Gincana;

	@Column(name = "data_fim_Gincana", nullable = false)
	private Date data_fim_Gincana;

	@OneToOne
	@JoinColumn(name = "id_Status", nullable = false)
	private StatusModel id_Status;

	
	public GincanaModel() {
		super();
	}

	public GincanaModel(int id_Gincana, String nome_Gincana, String descricao_Gincana, Date data_inicio_Gincana,
			Date data_fim_Gincana, StatusModel id_Status) {
		super();
		this.id_Gincana = id_Gincana;
		this.nome_Gincana = nome_Gincana;
		this.descricao_Gincana = descricao_Gincana;
		this.data_inicio_Gincana = data_inicio_Gincana;
		this.data_fim_Gincana = data_fim_Gincana;
		this.id_Status = id_Status;
	}

	public int getId_Gincana() {
		return id_Gincana;
	}

	public void setId_Gincana(int id_Gincana) {
		this.id_Gincana = id_Gincana;
	}

	public String getNome_Gincana() {
		return nome_Gincana;
	}

	public void setNome_Gincana(String nome_Gincana) {
		this.nome_Gincana = nome_Gincana;
	}

	public String getDescricao_Gincana() {
		return descricao_Gincana;
	}

	public void setDescricao_Gincana(String descricao_Gincana) {
		this.descricao_Gincana = descricao_Gincana;
	}

	public Date getData_inicio_Gincana() {
		return data_inicio_Gincana;
	}

	public void setData_inicio_Gincana(Date data_inicio_Gincana) {
		this.data_inicio_Gincana = data_inicio_Gincana;
	}

	public Date getData_fim_Gincana() {
		return data_fim_Gincana;
	}

	public void setData_fim_Gincana(Date data_fim_Gincana) {
		this.data_fim_Gincana = data_fim_Gincana;
	}

	public StatusModel getId_Status() {
		return id_Status;
	}

	public void setId_Status(StatusModel id_Status) {
		this.id_Status = id_Status;
	}

}
