package aste.service;

import java.util.List;

import aste.bean.OggettoAttributiBean;
import aste.model.Oggetto;

public interface OggettoService {
	     
	    public void addOggetto(OggettoAttributiBean oggettoAttributiBean);
	 
	    public List<Oggetto> getAllOggetti();
	    
	    public List<Oggetto> findAllNotVenduti();
	 
	    public void deleteOggetto(Integer oggettoId);
	 
	    public Oggetto getOggetto(Integer oggettoId);
	 
	    public Oggetto updateOggetto(Oggetto oggetto);
	    
	    public List<Oggetto> findByNome(String nome);
	    
}
