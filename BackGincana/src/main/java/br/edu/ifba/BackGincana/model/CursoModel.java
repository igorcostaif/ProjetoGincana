package br.edu.ifba.BackGincana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class CursoModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso", nullable = false)
	private int id_curso;
	
	@Column(name = "nome_Curso", length = 25, nullable = false)
	private String nome_Curso;
	
	@Column(name = "modalidade_Curso", length = 12, nullable = false)
	private String modalidade_Curso;

	public CursoModel() {
		super();
	}

	public CursoModel(int id_curso, String nome_Curso, String modalidade_Curso) {
		super();
		this.id_curso = id_curso;
		this.nome_Curso = nome_Curso;
		this.modalidade_Curso = modalidade_Curso;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getNome_Curso() {
		return nome_Curso;
	}

	public void setNome_Curso(String nome_Curso) {
		this.nome_Curso = nome_Curso;
	}

	public String getModalidade_Curso() {
		return modalidade_Curso;
	}

	public void setModalidade_Curso(String modalidade_Curso) {
		this.modalidade_Curso = modalidade_Curso;
	}
	
	

}
