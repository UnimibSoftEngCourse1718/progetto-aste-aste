package aste.service;

import java.util.List;

import aste.bean.CategoriaAttributiBean;
import aste.model.Categoria;

public interface CategoriaService {
	     
	    public void addCategoria(CategoriaAttributiBean categoriaAttributiBean);
	 
	    public void deleteCategoria(Integer categoriaId);
	 	
	    public Categoria getCategoria(int categoriaId);
	    
	    public List<Categoria> findAll();
	 
	    public Categoria updateCategoria(Categoria categoria);	 
}
