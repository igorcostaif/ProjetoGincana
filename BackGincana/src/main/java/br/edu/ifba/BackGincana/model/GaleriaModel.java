package br.edu.ifba.BackGincana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_galeria")
public class GaleriaModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Galeria")
	private int id_Galeria;

	@Column(name = "nome_Galeria", length = 30, nullable = false)
	private String nome_Galeria;


	@Column(name = "descricao_Galeria", length = 300, nullable = false)
	private String descricao_Galeria;
	
	@ManyToOne
	@JoinColumn(name = "id_gincana", nullable = false)
	private GincanaModel id_gincana;

	public GaleriaModel() {
		super();
	}

	public GaleriaModel(int id_Galeria, String nome_Galeria, String descricao_Galeria, GincanaModel id_gincana) {
		super();
		this.id_Galeria = id_Galeria;
		this.nome_Galeria = nome_Galeria;
		this.descricao_Galeria = descricao_Galeria;
		this.id_gincana = id_gincana;
	}

	public int getId_Galeria() {
		return id_Galeria;
	}

	public void setId_Galeria(int id_Galeria) {
		this.id_Galeria = id_Galeria;
	}

	public String getNome_Galeria() {
		return nome_Galeria;
	}

	public void setNome_Galeria(String nome_Galeria) {
		this.nome_Galeria = nome_Galeria;
	}

	public String getDescricao_Galeria() {
		return descricao_Galeria;
	}

	public void setDescricao_Galeria(String descricao_Galeria) {
		this.descricao_Galeria = descricao_Galeria;
	}

	public GincanaModel getId_gincana() {
		return id_gincana;
	}

	public void setId_gincana(GincanaModel id_gincana) {
		this.id_gincana = id_gincana;
	}
	
	
	
}
