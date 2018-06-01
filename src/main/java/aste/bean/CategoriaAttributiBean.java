package aste.bean;

import java.util.List;

import aste.model.Attributo;
import aste.model.Categoria;

public class CategoriaAttributiBean {
	
	Categoria categoria;
	List<Attributo> attributi;
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Attributo> getAttributi() {
		return attributi;
	}
	public void setAttributi(List<Attributo> attributi) {
		this.attributi = attributi;
	}
}
