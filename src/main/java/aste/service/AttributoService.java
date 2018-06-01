package aste.service;

import java.util.List;

import aste.model.Attributo;

public interface AttributoService {
	     
	    public void addAttributo(Attributo attributo);
	 
	    public List<Attributo> getAllOggetti();
	 
	    public void deleteAttributo(Integer attributoId);
	 	
	    public Attributo getAttributo(int attributoId);
	 
	    public Attributo updateAttributo(Attributo attributo);	    
}
