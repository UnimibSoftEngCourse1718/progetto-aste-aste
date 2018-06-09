package aste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ogg_att")
public class OggAtt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idOgg_att;
	
	@Column
	private String valore;
	
	@ManyToOne
	@JoinColumn(name = "idAttributo")
	private Attributo attributo;

	@ManyToOne
	@JoinColumn(name = "idOggetto")
	@JsonBackReference
	private Oggetto oggetto;


	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public Attributo getAttributo() {
		return attributo;
	}

	public void setAttributo(Attributo attributo) {
		this.attributo = attributo;
	}

	public Integer getIdOgg_att() {
		return idOgg_att;
	}

	public void setIdOgg_att(Integer idOgg_att) {
		this.idOgg_att = idOgg_att;
	}

	public Oggetto getOggetto() {
		return oggetto;
	}

	public void setOggetto(Oggetto oggetto) {
		this.oggetto = oggetto;
	}
}
