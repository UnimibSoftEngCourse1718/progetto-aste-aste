package aste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Credito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idCredito;
	
	@Column
	private Boolean azione;
	
	@Column
	private Float quantita;
	
	@ManyToOne
	@JoinColumn(name="idUtente")
	private Utente idUtente;

	public Integer getIdCredito() {
		return idCredito;
	}

	public void setIdCredito(Integer idCredito) {
		this.idCredito = idCredito;
	}

	public Boolean getAzione() {
		return azione;
	}

	public void setAzione(Boolean azione) {
		this.azione = azione;
	}

	public Float getQuantita() {
		return quantita;
	}

	public void setQuantita(Float quantita) {
		this.quantita = quantita;
	}

	public Utente getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Utente idUtente) {
		this.idUtente = idUtente;
	}
	
}
