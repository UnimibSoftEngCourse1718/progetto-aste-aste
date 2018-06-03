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
	@Column
	private Integer idCat_att;
	
	@ManyToOne
	@JoinColumn(name = "idAttributo")
	private Attributo attributo;

	@ManyToOne
	@JoinColumn(name = "idCategoria")
	@JsonBackReference
	private Categoria categoria;

	public Integer getIdCat_att() {
		return idCat_att;
	}

	public void setIdCat_att(Integer idCat_att) {
		this.idCat_att = idCat_att;
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
