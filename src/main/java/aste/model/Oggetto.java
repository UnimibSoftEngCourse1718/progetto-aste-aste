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
	@JoinColumn
	private Utente idUtente;

	@ManyToOne
	@JoinColumn
	private Categoria idCategoria;

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

	public Utente getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Utente idUtente) {
		this.idUtente = idUtente;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}
	
}
