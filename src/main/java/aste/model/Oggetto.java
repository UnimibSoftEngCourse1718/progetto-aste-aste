package aste.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NamedQuery(name = "Oggetto.findAllNotVenduti",
	query = "SELECT o FROM Oggetto o WHERE idOggetto NOT IN( SELECT idOggetto FROM Offerta off WHERE off.stato='VENDUTO')"
)

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
	@JsonIgnoreProperties("oggetto")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name = "idCategoria")	
	private Categoria categoria;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="oggetto")
	@Fetch(FetchMode.JOIN)
	@JsonManagedReference
    public Set<OggAtt> oggAtt;
	
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
