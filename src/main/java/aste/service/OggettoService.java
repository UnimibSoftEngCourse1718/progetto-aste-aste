package aste.service;

import java.util.List;

import aste.model.Oggetto;

public interface OggettoService {
	     
	    public void addOggetto(Oggetto oggetto);
	 
	    public List<Oggetto> getAllOggetti();
	 
	    public void deleteOggetto(Integer oggettoId);
	 
	    public Oggetto getOggetto(int oggettoId);
	 
	    public Oggetto updateOggetto(Oggetto oggetto);
	    
	    public List<Oggetto> findByNome(String nome);
	    
}
