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
	@Column(name="idOgg_att")
	private Integer idOggAtt;
	
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

	public Integer getIdOggAtt() {
		return idOggAtt;
	}

	public void setIdOggAtt(Integer idOggAtt) {
		this.idOggAtt = idOggAtt;
	}

	public Oggetto getOggetto() {
		return oggetto;
	}

	public void setOggetto(Oggetto oggetto) {
		this.oggetto = oggetto;
	}
}
