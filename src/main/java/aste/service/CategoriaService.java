package aste.service;

import java.util.List;

import aste.bean.CategoriaAttributiBean;
import aste.model.Attributo;
import aste.model.Categoria;

public interface CategoriaService {
	     
	    public void addCategoria(CategoriaAttributiBean categoriaAttributiBean);
	 
	    public List<Categoria> getAllOggetti();
	 
	    public void deleteCategoria(Integer categoriaId);
	 	
	    public Categoria getCategoria(int categoriaId);
	    
	    public List<Categoria> findAll();
	 
	    public Categoria updateCategoria(Categoria categoria);	 
	    
	    public List<Attributo> findAttributi(String nomeCategoria);	 
}
