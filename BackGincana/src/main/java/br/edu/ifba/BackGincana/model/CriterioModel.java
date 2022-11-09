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
@Table(name = "tb_criterio")
public class CriterioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_criterio", nullable = false)
	private int id_criterio;
	
	@Column(name = "nome_Criterio", length = 30, nullable = false)
	private String nome_Criterio;
	
	@Column(name = "pontuacao_min_Criterio", nullable = false)
	private int pontuacao_min_Criterio;
	
	@Column(name = "pontuacao_max_Criterio", nullable = false)
	private int pontuacao_max_Criterio;
	
	@ManyToOne
	@JoinColumn(name = "id_Evento", nullable = false)
	private EventoModel id_Evento;

	public CriterioModel() {
		super();
	}

	public CriterioModel(int id_criterio, String nome_Criterio, int pontuacao_min_Criterio, int pontuacao_max_Criterio,
			EventoModel id_Evento) {
		super();
		this.id_criterio = id_criterio;
		this.nome_Criterio = nome_Criterio;
		this.pontuacao_min_Criterio = pontuacao_min_Criterio;
		this.pontuacao_max_Criterio = pontuacao_max_Criterio;
		this.id_Evento = id_Evento;
	}

	public int getId_criterio() {
		return id_criterio;
	}

	public void setId_criterio(int id_criterio) {
		this.id_criterio = id_criterio;
	}

	public String getNome_Criterio() {
		return nome_Criterio;
	}

	public void setNome_Criterio(String nome_Criterio) {
		this.nome_Criterio = nome_Criterio;
	}

	public int getPontuacao_min_Criterio() {
		return pontuacao_min_Criterio;
	}

	public void setPontuacao_min_Criterio(int pontuacao_min_Criterio) {
		this.pontuacao_min_Criterio = pontuacao_min_Criterio;
	}

	public int getPontuacao_max_Criterio() {
		return pontuacao_max_Criterio;
	}

	public void setPontuacao_max_Criterio(int pontuacao_max_Criterio) {
		this.pontuacao_max_Criterio = pontuacao_max_Criterio;
	}

	public EventoModel getId_Evento() {
		return id_Evento;
	}

	public void setId_Evento(EventoModel id_Evento) {
		this.id_Evento = id_Evento;
	}
	
	

}
