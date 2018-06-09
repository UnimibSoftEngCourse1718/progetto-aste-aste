package aste.model;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idCategoria;

	@Column
	private String nome;
	
	@ManyToMany(cascade = { 
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    })
	    @JoinTable(name = "cat_att",
	        joinColumns = @JoinColumn(name = "idCategoria"),
	        inverseJoinColumns = @JoinColumn(name = "idAttributo")
	    )
	@Fetch(FetchMode.JOIN)	
	private List<Attributo> attributi;
	
	public Integer getIdCategoria() {
		return idCategoria;
	}	

	public List<Attributo> getAttributi() {
		return attributi;
	}

	public void setAttributi(List<Attributo> attributi) {
		this.attributi = attributi;
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
