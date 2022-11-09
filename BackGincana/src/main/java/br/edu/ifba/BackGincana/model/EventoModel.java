package br.edu.ifba.BackGincana.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_evento")
public class EventoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Evento")
	private int id_Evento;

	@Column(name = "nome_Evento", length = 30, nullable = false)
	private String nome_Evento;

	@Column(name = "descricao_Evento", length = 200, nullable = false)
	private String descricao_Evento;

	@Column(name = "tipo_Evento", length = 15,  nullable = false)
	private String tipo_Evento;

	@Column(name = "data_Evento", nullable = false)
	private Date data_Evento;

	@Column(name = "horario_Evento", length = 5, nullable = false)
	private String horario_Evento;

	@Column(name = "local_Evento", length = 20, nullable = false)
	private String local_Evento;
	
	@ManyToOne
	@JoinColumn(name = "id_gincana",  nullable = false)
	private GincanaModel id_gincana;
	
	@ManyToOne
	@JoinColumn(name = "id_status",  nullable = false)
	private StatusModel id_status;


	public EventoModel() {
		super();
	}

	public EventoModel(int id_Evento, String nome_Evento, String descricao_Evento, String tipo_Evento,
			Date data_Evento, String horario_Evento, String local_Evento) {
		super();
		this.id_Evento = id_Evento;
		this.nome_Evento = nome_Evento;
		this.descricao_Evento = descricao_Evento;
		this.tipo_Evento = tipo_Evento;
		this.data_Evento = data_Evento;
		this.horario_Evento = horario_Evento;
		this.local_Evento = local_Evento;
	}

	public int getId_Evento() {
		return id_Evento;
	}

	public void setId_Evento(int id_Evento) {
		this.id_Evento = id_Evento;
	}

	public String getNome_Evento() {
		return nome_Evento;
	}

	public void setNome_Evento(String nome_Evento) {
		this.nome_Evento = nome_Evento;
	}

	public String getDescricao_Evento() {
		return descricao_Evento;
	}

	public void setDescricao_Evento(String descricao_Evento) {
		this.descricao_Evento = descricao_Evento;
	}

	public String getTipo_Evento() {
		return tipo_Evento;
	}

	public void setTipo_Evento(String tipo_Evento) {
		this.tipo_Evento = tipo_Evento;
	}

	public Date getData_Evento() {
		return data_Evento;
	}

	public void setData_Evento(Date data_Evento) {
		this.data_Evento = data_Evento;
	}

	public String getHorario_Evento() {
		return horario_Evento;
	}

	public void setHorario_Evento(String horario_Evento) {
		this.horario_Evento = horario_Evento;
	}

	public String getLocal_Evento() {
		return local_Evento;
	}

	public void setLocal_Evento(String local_Evento) {
		this.local_Evento = local_Evento;
	}

}