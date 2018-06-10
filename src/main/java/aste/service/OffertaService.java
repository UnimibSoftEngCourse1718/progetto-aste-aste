package aste.service;

import java.util.List;

import aste.model.Offerta;
import aste.model.Oggetto;

public interface OffertaService {
	     
	    public void addOfferta(Offerta offerta) throws Exception;
	 
	    public List<Offerta> getAllOggetti();
	 
	    public void deleteOfferta(Integer offertaId);
	 
	    public Offerta getOfferta(int offertaId);
	 
	    public Offerta updateOfferta(Offerta offerta);
	    
	    public List<Offerta> findAllOggettoInAsta();
	    
	    public Offerta getOffertaByOggetto(Oggetto idOggetto);
	    
}
