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
@Table(name = "cat_att")
public class CatAtt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCat_att")
	private Integer idCatAtt;
	
	@ManyToOne
	@JoinColumn(name = "idAttributo")
	private Attributo attributo;

	@ManyToOne
	@JoinColumn(name = "idCategoria")
	@JsonBackReference
	private Categoria categoria;

	public Integer getIdCatAtt() {
		return idCatAtt;
	}

	public void setIdCatAtt(Integer idCatAtt) {
		this.idCatAtt = idCatAtt;
	}

	public Attributo getAttributo() {
		return attributo;
	}

	public void setAttributo(Attributo attributo) {
		this.attributo = attributo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	
}
