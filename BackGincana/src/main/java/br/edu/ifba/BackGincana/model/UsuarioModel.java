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

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = true)
	private int id_Usuario;
	
	@Column(name = "nome_Usuario", length = 60,  nullable = false)
	private String nome_Usuario;

	@Column(name = "email_Usuario", length = 60, nullable = false)
	private String email_Usuario;

	@Column(name = "senha_Usuario", length = 30, nullable = false)
	private String senha_Usuario;

	@Column(name = "sexo_Usuario", length = 9, nullable = false)
	private String sexo_Usuario;
	
	@Column(name = "data_cadastro_Usuario", nullable = false)
	private Date data_cadastro_Usuario;

	@ManyToOne
	@JoinColumn(name = "id_Gincana", nullable = false)
	private GincanaModel id_Gincana;
	
	@ManyToOne
	@JoinColumn(name = "id_Perfil", nullable = false)
	private PerfilModel id_Perfil;
	
	@ManyToOne
	@JoinColumn(name = "id_Evento", nullable = false)
	private EventoModel id_Evento;

	public UsuarioModel() {
		super();
	}

	public UsuarioModel(int id_Usuario, String nome_Usuario, String email_Usuario, String senha_Usuario,
			String sexo_Usuario, Date data_cadastro_Usuario, GincanaModel id_Gincana, PerfilModel id_Perfil,
			EventoModel id_Evento) {
		super();
		this.id_Usuario = id_Usuario;
		this.nome_Usuario = nome_Usuario;
		this.email_Usuario = email_Usuario;
		this.senha_Usuario = senha_Usuario;
		this.sexo_Usuario = sexo_Usuario;
		this.data_cadastro_Usuario = data_cadastro_Usuario;
		this.id_Gincana = id_Gincana;
		this.id_Perfil = id_Perfil;
		this.id_Evento = id_Evento;
	}

	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getNome_Usuario() {
		return nome_Usuario;
	}

	public void setNome_Usuario(String nome_Usuario) {
		this.nome_Usuario = nome_Usuario;
	}

	public String getEmail_Usuario() {
		return email_Usuario;
	}

	public void setEmail_Usuario(String email_Usuario) {
		this.email_Usuario = email_Usuario;
	}

	public String getSenha_Usuario() {
		return senha_Usuario;
	}

	public void setSenha_Usuario(String senha_Usuario) {
		this.senha_Usuario = senha_Usuario;
	}

	public String getSexo_Usuario() {
		return sexo_Usuario;
	}

	public void setSexo_Usuario(String sexo_Usuario) {
		this.sexo_Usuario = sexo_Usuario;
	}

	public Date getData_cadastro_Usuario() {
		return data_cadastro_Usuario;
	}

	public void setData_cadastro_Usuario(Date data_cadastro_Usuario) {
		this.data_cadastro_Usuario = data_cadastro_Usuario;
	}

	public GincanaModel getId_Gincana() {
		return id_Gincana;
	}

	public void setId_Gincana(GincanaModel id_Gincana) {
		this.id_Gincana = id_Gincana;
	}

	public PerfilModel getId_Perfil() {
		return id_Perfil;
	}

	public void setId_Perfil(PerfilModel id_Perfil) {
		this.id_Perfil = id_Perfil;
	}

	public EventoModel getId_Evento() {
		return id_Evento;
	}

	public void setId_Evento(EventoModel id_Evento) {
		this.id_Evento = id_Evento;
	}
	
	

}
