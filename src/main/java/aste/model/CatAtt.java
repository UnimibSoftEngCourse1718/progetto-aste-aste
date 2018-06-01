package aste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cat_att")
public class CatAtt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idCat_att;
	
	@ManyToOne
	@JoinColumn(name = "idAttributo")
	private Attributo idAttributo;

	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Categoria idCategoria;

	public Integer getIdCat_att() {
		return idCat_att;
	}

	public void setIdCat_att(Integer idCat_att) {
		this.idCat_att = idCat_att;
	}

	public Attributo getIdAttributo() {
		return idAttributo;
	}

	public void setIdAttributo(Attributo idAttributo) {
		this.idAttributo = idAttributo;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}
	

	
}
