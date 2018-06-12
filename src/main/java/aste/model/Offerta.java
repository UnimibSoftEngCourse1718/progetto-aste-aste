package aste.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Offerta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idOfferta;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Stato stato;
	
	@Column
	private Float importo;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date data;

	@ManyToOne
	@JoinColumn(name="idOggetto")
	private Oggetto idOggetto;
	
	@ManyToOne
	@JoinColumn(name="idUtente")
	private Utente idUtente;

	public Integer getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(Integer idOfferta) {
		this.idOfferta = idOfferta;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public Float getImporto() {
		return importo;
	}

	public void setImporto(Float importo) {
		this.importo = importo;
	}

	public Oggetto getIdOggetto() {
		return idOggetto;
	}

	public void setIdOggetto(Oggetto idOggetto) {
		this.idOggetto = idOggetto;
	}

	public Utente getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Utente idUtente) {
		this.idUtente = idUtente;
	}
	
	public enum Stato {
	    PAGATO,
	    VENDUTO,
	    ATTIVO
	}
}
