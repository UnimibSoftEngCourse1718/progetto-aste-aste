package aste.service;

import java.util.List;

import aste.model.Attributo;
import aste.model.CatAtt;

public interface CatAttService {
	     
	    public void addCatAtt(CatAtt catatt);
	    
	    public List<Attributo> findAttributiByCategoria(Integer idCategoria);
	 
	    public void deleteCatAtt(Integer catattId);  
}
