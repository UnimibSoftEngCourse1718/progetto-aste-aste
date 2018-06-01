package aste.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Attributo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idAttributo;
	
	@Column
	private String nome;

	@ManyToMany(mappedBy = "attributi")
    private List<Categoria> categorie = new ArrayList<Categoria>();

	public List<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}

	public Integer getIdAttributo() {
		return idAttributo;
	}

	public void setIdAttributo(Integer idAttributo) {
		this.idAttributo = idAttributo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
