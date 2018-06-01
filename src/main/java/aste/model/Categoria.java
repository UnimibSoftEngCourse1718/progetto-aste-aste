package aste.model;

import java.util.ArrayList;
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

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idCategoria;

	@Column
	private String nome;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "cat_att", joinColumns = @JoinColumn(name = "idCategoria"), inverseJoinColumns = @JoinColumn(name = "idAttributo"))
	private List<Attributo> attributi = new ArrayList<Attributo>();

	public List<Attributo> getAttributi() {
		return attributi;
	}

	public void setAttributi(List<Attributo> attributi) {
		this.attributi = attributi;
	}
	
	public Integer getIdCategoria() {
		return idCategoria;
	}	

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
