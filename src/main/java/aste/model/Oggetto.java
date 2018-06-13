package aste.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Oggetto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idOggetto;
	
	@Column
	private String nome;
	
	@Column
	private Integer tempoAsta;

	@ManyToOne
	@JoinColumn(name = "idUtente")
	@JsonBackReference
	private Utente utente;

	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;
	
	@ManyToMany(cascade = { 
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    })
	    @JoinTable(name = "ogg_att",
	        joinColumns = @JoinColumn(name = "idOggetto"),
	        inverseJoinColumns = @JoinColumn(name = "idAttributo")
	    )
	@Fetch(FetchMode.JOIN)	
	private List<Attributo> attributi;

	public Integer getIdOggetto() {
		return idOggetto;
	}

	public void setIdOggetto(Integer idOggetto) {
		this.idOggetto = idOggetto;
	}

	public Integer getTempoAsta() {
		return tempoAsta;
	}

	public void setTempoAsta(Integer tempoAsta) {
		this.tempoAsta = tempoAsta;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}
