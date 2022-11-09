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
@Table(name = "tb_equipe")
public class EquipeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_equipe", nullable = false)
	private int id_equipe;

	@Column(name = "nome_equipe", length = 20, nullable = false)
	private String nome_Equipe;

	@ManyToOne
	@JoinColumn(name = "id_gincana", nullable = false)
	private GincanaModel id_gincana;

	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false)
	private CursoModel id_curso;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private UsuarioModel id_usuario;

	public EquipeModel() {
		super();
	}

	public EquipeModel(int id_equipe, String nome_Equipe, GincanaModel id_gincana, CursoModel id_curso,
			UsuarioModel id_usuario) {
		super();
		this.id_equipe = id_equipe;
		this.nome_Equipe = nome_Equipe;
		this.id_gincana = id_gincana;
		this.id_curso = id_curso;
		this.id_usuario = id_usuario;
	}

	public int getId_equipe() {
		return id_equipe;
	}

	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}

	public String getNome_Equipe() {
		return nome_Equipe;
	}

	public void setNome_Equipe(String nome_Equipe) {
		this.nome_Equipe = nome_Equipe;
	}

	public GincanaModel getId_gincana() {
		return id_gincana;
	}

	public void setId_gincana(GincanaModel id_gincana) {
		this.id_gincana = id_gincana;
	}

	public CursoModel getId_curso() {
		return id_curso;
	}

	public void setId_curso(CursoModel id_curso) {
		this.id_curso = id_curso;
	}

	public UsuarioModel getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(UsuarioModel id_usuario) {
		this.id_usuario = id_usuario;
	}

}
