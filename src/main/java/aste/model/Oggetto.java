package aste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Oggetto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idOggetto;
	
	@Column
	private String nome;

	@ManyToOne
	@JoinColumn(name="idUtente")
	private Utente utente_id;

	@ManyToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria_id;

	public Integer getIdOggetto() {
		return idOggetto;
	}

	public void setIdOggetto(Integer idOggetto) {
		this.idOggetto = idOggetto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Utente getUtente_id() {
	    return utente_id;
	}

	public void setUtente_id(Utente utente_id) {
		this.utente_id = utente_id;
	}

	public Categoria getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Categoria categoria_id) {
		this.categoria_id = categoria_id;
	}

	
}
