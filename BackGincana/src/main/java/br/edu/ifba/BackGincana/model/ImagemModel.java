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
@Table(name = "tb_imagem")
public class ImagemModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Imagem", nullable = false)
	private int id_Imagem;

	@Column(name = "URL_Imagem", length = 400, nullable = false)
	private String URL_Imagem;
	
	@ManyToOne
	@JoinColumn(name = "id_galeria", nullable = false)
	private GaleriaModel id_galeria;

	public ImagemModel() {
		super();
	}

	public ImagemModel(int id_Imagem, String uRL_Imagem, GaleriaModel id_galeria) {
		super();
		this.id_Imagem = id_Imagem;
		URL_Imagem = uRL_Imagem;
		this.id_galeria = id_galeria;
	}

	public int getId_Imagem() {
		return id_Imagem;
	}

	public void setId_Imagem(int id_Imagem) {
		this.id_Imagem = id_Imagem;
	}

	public String getURL_Imagem() {
		return URL_Imagem;
	}

	public void setURL_Imagem(String uRL_Imagem) {
		URL_Imagem = uRL_Imagem;
	}

	public GaleriaModel getId_galeria() {
		return id_galeria;
	}

	public void setId_galeria(GaleriaModel id_galeria) {
		this.id_galeria = id_galeria;
	}
	
	

	

}
